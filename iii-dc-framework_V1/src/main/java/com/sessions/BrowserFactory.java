package com.sessions;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.RequestFilterAdapter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.setting.TestSettings;
import com.utilites.LogStatuses;
import com.utilites.Logger;
import com.utilites.StaticWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.*;

public class BrowserFactory
{
	public enum BrowserType 
	{
	    Chrome,
	    Firefox,
	    IE,
	    PhantomJS;
	}
	static synchronized Browser getBrowser() throws ExecutionException, TimeoutException, InterruptedException
	{
		OpenedRequestsContainer openedRequests = new OpenedRequestsContainer();
		BrowserMobProxy browserMobProxy = ProxyFactory.getBrowserMobProxy(openedRequests);
		browserMobProxy.addFirstHttpFilterFactory(new RequestFilterAdapter.FilterSource(new RequestFilter() 
		{
			@Override
			public HttpResponse filterRequest(HttpRequest request, HttpMessageContents contents, HttpMessageInfo messageInfo) 
			{
				return null;
			}
		}, 16777216));

		SessionProxy proxy = new SessionProxy(browserMobProxy, openedRequests);

		Callable<WebDriver> browserInit = () -> TestSettings.Current.getBrowserType().equals("Remote")
				? getRemote(browserMobProxy)
				: getLocal(browserMobProxy);

		WebDriver browser;
		ExecutorService executor;
		Future<WebDriver> future;

		try 
		{
			Logger.write(LogStatuses.INFO, "Initializing browser");

			executor = Executors.newSingleThreadExecutor();
			future = executor.submit(browserInit);

			browser = future.get(10, TimeUnit.SECONDS);
		} catch (TimeoutException | InterruptedException | CancellationException e) 
		{
			//Second attempt
			//future.cancel(true);
			StaticWait.forSeconds(10);
			Logger.write(LogStatuses.ERR, "Browser init failed. Retrying...", e);

			executor = Executors.newSingleThreadExecutor();
			future = executor.submit(browserInit);

			browser = future.get(10, TimeUnit.SECONDS);
		}

		executor.shutdownNow();

		return new Browser(browser, proxy);
	}

	private static DesiredCapabilities getChromeCapabilities(BrowserMobProxy bmpProxy) 
	{

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", TestSettings.Current.getTempFolder());
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); //to disable browser extension popup

		Proxy proxy = ClientUtil.createSeleniumProxy(bmpProxy);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		return capabilities;
	}

	private static DesiredCapabilities getIECapabilities(BrowserMobProxy bmpProxy) {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("initialBrowserUrl", TestSettings.Current.getEncoreWebURL());
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		return capabilities;
	}

	private static DesiredCapabilities getFirefoxCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		return capabilities;
	}

	private static WebDriver getChrome(BrowserMobProxy bmpProxy) {
		String extension = "";
		if (SystemUtils.IS_OS_WINDOWS) extension = ".exe";
		String driverPath = TestSettings.Current.getDriverPath() + "chromedriver" + extension;

		System.setProperty("webdriver.chrome.driver", driverPath);
		return new ChromeDriver(getChromeCapabilities(bmpProxy));
	}

	private static WebDriver getIE(BrowserMobProxy bmpProxy) {
		System.setProperty("webdriver.ie.driver", TestSettings.Current.getDriverPath() + "IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver(getIECapabilities(bmpProxy));
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver getFirefox() {
		System.setProperty("webdriver.gecko.driver", TestSettings.Current.getDriverPath() + "geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver(getFirefoxCapabilities());
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver getPhantomJs(BrowserMobProxy bmpProxy) {
		Proxy proxy = ClientUtil.createSeleniumProxy(bmpProxy);

		DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		System.setProperty("phantomjs.binary.path", TestSettings.Current.getDriverPath());
		return new PhantomJSDriver(capabilities);
	}

	private static WebDriver getRemote(BrowserMobProxy bmpProxy) {
		DesiredCapabilities capabilities;

		String browser = TestSettings.Current.getBrowserName();
		BrowserType browserType = BrowserType.valueOf(browser);

		//Add more cases if needed
		switch (browserType) {
			case Chrome:
				capabilities = getChromeCapabilities(bmpProxy);
				break;
			case IE:
				capabilities = getIECapabilities(bmpProxy);
				break;
			case Firefox:
				capabilities = getFirefoxCapabilities();
				break;
			default: capabilities = new DesiredCapabilities();
		}

		try {
			RemoteWebDriver driver = new RemoteWebDriver(new URL(TestSettings.Current.getDriverPath()), capabilities);

			if(!browserType.equals(BrowserType.Chrome)) {
				driver.manage().window().maximize();
			}

			driver.setFileDetector(new LocalFileDetector());
			return driver;
		} catch (MalformedURLException e) {
			Logger.write(LogStatuses.ERR, "Error during remote browser init", e);
			return null;
		}
	}

	private static WebDriver getLocal(BrowserMobProxy bmpProxy) {
		String browser = TestSettings.Current.getBrowserName();
		BrowserType browserType = BrowserType.valueOf(browser);

		//Add more cases if needed
		switch (browserType) {
			case Chrome: return getChrome(bmpProxy);
			case IE: return getIE(bmpProxy);
			case Firefox: return getFirefox();
			case PhantomJS: return getPhantomJs(bmpProxy);
			default: return getChrome(bmpProxy);
		}
	}
}