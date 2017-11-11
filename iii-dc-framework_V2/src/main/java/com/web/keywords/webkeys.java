package com.web.keywords;

import com.file.handling.exlReader;

public interface webkeys 

{
	

	public static void performClick(String sheetName, String keyName)
	{
		
		System.out.println("Perform clickLink");
		//driver.findElement(RespositoryParser.getbjectLocator("DC", "username")).sendKeys(s);
		//browser.getDriver().findElement(exlReader.getbjectLocator(sheetName, keyName )).click();
		System.out.println("Done-Performed clickLink");
		//browser.getDriver().findElement(by)
		
		/*Set<String> windows = browser.getDriver().getWindowHandles();
		String window = Iterables.getLast(windows);
		browser.getDriver().switchTo().window(window);*/
	}
}
