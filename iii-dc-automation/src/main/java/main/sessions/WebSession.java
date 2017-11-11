package main.sessions;

import main.file.handling.exlReader;
import main.file.handling.xmlReader;
import main.tests.execution.BasicSuite;

public class WebSession extends BrowserSession
{

	
	
	
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

	@Override
	public void logout() 
	{
		// TODO Auto-generated method stub
		
	}
}
