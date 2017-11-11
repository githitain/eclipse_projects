package com.dc.common.functions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.dc.connectivity.exlReader;
import com.dc.connectivity.*;



public class cFuntion 
{
	
	
	static WebDriver driver;
	
	public static WebDriver init_open() throws Exception
	{	
		System.out.println("Find the Browser===================================================");
		
		String strBrow=proReader.getString("browser");
		//System.out.println(str1);
		String strGk=proReader.getString("geckodriver");
		String strGexe=proReader.getString("Gexe");
		String strUrl=proReader.getString("local");
		long strImplicitTime=proReader.getInteger("time");
		
		
		System.out.println("browswer" +strBrow);
		System.out.println("geo" +strGk);
		System.out.println("url" +strUrl);
		
		if ((strBrow.equals("firefox")))
		{
			System.setProperty("webdriver.firefox.marionette",strGk);
			driver = new FirefoxDriver();
			System.out.println("Open Firfox Browser=======================================================");
		}
		
		else if	((strBrow.equals("googlechrome")))
		{
			System.setProperty("webdriver.chrome.driver",strGexe );
			driver = new ChromeDriver();
			System.out.println("Open Google Chrome Browser=======================================================");
		}
		
		System.out.println("Ready to Open Application URL=====================================================");
		driver.get(strUrl);
		System.out.println("Opened  Application URL=====================================================");
		driver.manage().timeouts().implicitlyWait(strImplicitTime, TimeUnit.MILLISECONDS);
		return driver;
	}
	

	public  static WebDriver sendKeysInput(String sheetName, String keyName, String testDataTag, String TestDataKey) throws Exception
	{	
		System.out.println("Perform Sendkeys");
		//driver.findElement(RespositoryParser.getbjectLocator("DC", "username")).sendKeys(s);
		driver.findElement(exlReader.getbjectLocator(sheetName, keyName )).sendKeys(xmlReader.getXMLTagValue(testDataTag,TestDataKey ));
		System.out.println("Done-Performed Sendkeys");
		return driver;
	}
	

	public  static WebDriver clickLink(String sheetName, String keyName)
	{	
		System.out.println("Perform clickLink");
		//driver.findElement(RespositoryParser.getbjectLocator("DC", "username")).sendKeys(s);
		driver.findElement(exlReader.getbjectLocator(sheetName, keyName )).click();
		System.out.println("Done-Performed clickLink");
		return driver;
	}
	
	public  static WebDriver clickLink2(String loctorvalue)
	{	
		System.out.println("Perform clickLink");
		//driver.findElement(RespositoryParser.getbjectLocator("DC", "username")).sendKeys(s);
		driver.findElement( By.xpath(loctorvalue)).click();
		System.out.println("Done-Performed clickLink");
		return driver;
	}
	
	

	public static  WebDriver verifyElement(String sheetName, String keyName)
	{	
		List<WebElement> we;
		
		
		System.out.println("Verify element");
		
		we=driver.findElements(exlReader.getbjectLocator(sheetName, keyName));
		
		
		if(!we.isEmpty())
		{
			System.out.println("Element is Persent on the page");
		} 
		else
		{
			System.out.println("Element is not Persent on the page");
		}
		Assert.assertEquals(true, !we.isEmpty());
		
		System.out.println("Done-Verified element");
		return driver;
	}
	
	public  static WebDriver waitImplicit(int time)
	{	
		try 
		{
			System.out.println("Wait till" +time);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	public  static WebDriver waitThread(int time)
	{	
		try 
		{
			System.out.println("Wait till" +time);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	public  static WebDriver quit_Browser()
	{	
		driver.quit();
		return driver;
	}
}
