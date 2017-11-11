package com.web.ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sessions.BrowserSession;
import com.utilites.LogStatuses;
import com.utilites.Logger;
import com.utilites.StaticWait;
import com.utilites.StringHelper;
import com.web.keywords.WebObject;
import com.web.keywords.WebObjectFinder;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public abstract class WebPage extends WebObjectsContainer<WebDriver> 
{

    protected final BrowserSession session;

	protected WebPage(BrowserSession session, String name) {
			super(session.getBrowser().getDriver(), new WebObjectFinder<WebDriver>() {

				@Override
				public WebDriver findObject() {
					return session.getBrowser().getDriver();
				}
			}, name);

			this.session = session;
	}
	
	@Override
	public WebPage getParentPage() {
		return this;
	}

	public WebObject getRoot() {
		return getChildWebObject(By.xpath("//html/body"), "Root node");
	}

	public boolean waitForPageLoading() throws Exception {
		return waitForPageLoading(500);
	}

	public boolean waitForPageLoading(int milliseconds) throws Exception 
	{
		StaticWait.forMilliseconds(milliseconds);

		Instant start = Instant.now();

		waitForJSandJQueryToLoad();

		Instant waitForQuiescenceStart = Instant.now();

		boolean synchronizationSuccessful = session.getBrowser().getProxy().getOpenedRequestsContainer().waitForAllRequestProcessing(15);

		if (synchronizationSuccessful) {
			Instant waitForQuiescenceEnd = Instant.now();
			Duration waitForQuiescenceTimeElapsed = Duration.between(waitForQuiescenceStart, waitForQuiescenceEnd);
			if (waitForQuiescenceTimeElapsed.toMillis() > 5000) {
				Logger.write(LogStatuses.DEBUG, String.format("WebProxy synchronization took %1s milliseconds", waitForQuiescenceTimeElapsed.toMillis()));
			}
		}
		waitForLoadingDisappearsFromBodyClass();
		waitForJSandJQueryToLoad();

		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);

		session.getBrowser().getProxy().getOpenedRequestsContainer().clear();

		//Logger.write(LogStatuses.DEBUG, String.format("Synchronization took %1s milliseconds + %2s of static wait", timeElapsed.toMillis(), milliseconds));

		return synchronizationSuccessful;
	}
	
	protected boolean waitForLoadingDisappearsFromBodyClass() throws Exception {
		try {
		Wait<WebPage> waitForBodyClass = new FluentWait<>(this)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class).
				ignoring(StaleElementReferenceException.class);

		return waitForBodyClass.until(page -> {
            if (!page.getRoot().isExist()) {
            	StaticWait.forMilliseconds(200); //Added to minimize amount of commands executed by selenium
                return false;
            }

            String bodyClass = StringHelper.normalizeSpaces(page.getRoot().getAttribute("class"));
            boolean result = StringHelper.isEmpty(bodyClass) || !bodyClass.contains("loading");
            if (!result) {
				StaticWait.forMilliseconds(200); //Added to minimize amount of commands executed by selenium
			}
            return result;
        });
		} catch (Exception e) {
			Logger.write(LogStatuses.ERR, "Waiting until 'Loading' will disappear is not successful. Reason: " + e.getMessage());
			takeScreenshot();
		}

		return false;
	}

	protected boolean waitForJSandJQueryToLoad() throws Exception 
	{

		try {
			WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);

			// wait for jQuery to load
			ExpectedCondition<Boolean> jQueryLoad = driver ->
			{
				try {
					boolean result = (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0;
					if (!result) {
						StaticWait.forMilliseconds(200); //Added to minimize amount of commands executed by selenium
					}
					return result;
				} catch (Exception e) {
					Logger.write(LogStatuses.DEBUG, "No jQuery present");
					return true;
				}
			};

			// wait for Javascript to load
			ExpectedCondition<Boolean> jsLoad = driver -> {
				String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
				boolean result = readyState.equals("complete");
				if (!result) {
					StaticWait.forMilliseconds(200); //Added to minimize amount of commands executed by selenium
				}
				return result;
			};

			return wait.until(jQueryLoad) && wait.until(jsLoad);
		} catch (Exception e) {
			Logger.write(LogStatuses.ERR, "Waiting for JS and jQuery is not successful. Reason: " + e.getMessage());
			takeScreenshot();
		}

		return false;
	}

	public void takeScreenshot() throws Exception {
		session.PassedScreenshot("WebPage Class");
	}

	public BrowserSession getSession()
	{
		return session;
	}
}