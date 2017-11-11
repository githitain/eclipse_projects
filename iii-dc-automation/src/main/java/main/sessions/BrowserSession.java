package main.sessions;

import com.google.common.collect.Iterables;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import main.config.TestSettings;
import main.file.handling.exlReader;
import main.file.handling.xmlReader;
import main.utils.LogStatuses;
import main.utils.Logger;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//public abstract class BrowserSession
public class BrowserSession
{
		private Project project;
		protected final Browser browser;
		protected final String mainWindowHandle;
	
		public BrowserSession()
		{
			System.out.println("Step-5-BrowserSession-BrowserSession");
			
			try
			{
				browser = BrowserFactory.getBrowser();
			} catch (ExecutionException | InterruptedException | TimeoutException e) {
				throw new RuntimeException(e);
			}
	
			browser.getDriver().manage().timeouts().implicitlyWait(TestSettings.Current.getWaitElementTimeout(), TimeUnit.SECONDS);
	
			SessionsManager.addSession(this);
			
			mainWindowHandle = browser.getDriver().getWindowHandle();
			//project = Project.SIERRA;
		}
	
		public BrowserSession(Project project) {
			this();
			this.project = project;
		}
		
		public Browser getBrowser()
		{
			return browser;
		}
	
		public Project getProject()
		{
			return project;
		}
	
		public void navigate(String url)
		{
			Logger.write(LogStatuses.INFO, "Navigating " + url);
			browser.getDriver().get(url);
		}
	
		public void close()
		{
			close(true);
		}
	
		protected void close(boolean removeSession) 
		{
			browser.getDriver().quit();
			if (removeSession) {
				SessionsManager.removeSession(this);
			}
	
			getBrowser().getProxy().getNativeProxy().stop();
		}
	
		public void takeScreenshot() 
		{
			if (browser.getDriver() == null) 
			{
				Logger.write(LogStatuses.DEBUG, "Unable to take screenshot - the browser is not opened");
				return;
			}
	
			File scrFile = ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.FILE);
			Logger.saveScreenshot(scrFile);
		}
		
	
		public void performClick(String sheetName, String keyName)
		{
			
			System.out.println("Perform clickLink");
			//driver.findElement(RespositoryParser.getbjectLocator("DC", "username")).sendKeys(s);
			browser.getDriver().findElement(exlReader.getbjectLocator(sheetName, keyName )).click();
			System.out.println("Done-Performed clickLink");
			//browser.getDriver().findElement(by)
			
			/*Set<String> windows = browser.getDriver().getWindowHandles();
			String window = Iterables.getLast(windows);
			browser.getDriver().switchTo().window(window);*/
		}
	
		public  void  sendKeys(String sheetName, String keyName, String testDataTag, String TestDataKey) 
		{	
			try {
		
		
			System.out.println("Perform Sendkeys");
			//driver.findElement(RespositoryParser.getbjectLocator("DC", "username")).sendKeys(s);
			browser.getDriver().findElement(exlReader.getbjectLocator(sheetName, keyName )).sendKeys(xmlReader.getXMLTagValue(testDataTag,TestDataKey));
			System.out.println("Done-Performed Sendkeys");
		}
		

			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//return driver;
		}
		
	
		public void switchToLastOpenedWindow()
		{
			Set<String> windows = browser.getDriver().getWindowHandles();
			String window = Iterables.getLast(windows);
			browser.getDriver().switchTo().window(window);
		}
	
		//public abstract void logout() 
		
		public void logout() 
		{
		}
}