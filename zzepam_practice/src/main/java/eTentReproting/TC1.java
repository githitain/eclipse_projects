package eTentReproting;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;*/

public class TC1 
{
	
	//ExtentReports extent;
	//ExtentTest test;
	static WebDriver driver;
	
	@BeforeClass
	public static void M1()
	{
		ExtentManager.extent = ExtentManager.GetExtent();
		
		
		System.setProperty("webdriver.firefox.marionette","D:\\Automation_Software\\Selenium Jars\\geckodriver.exe");  
	    driver = new FirefoxDriver();
	}
	
	@Test
	public void checkHome()
	{
		try
		{
		driver.get("http://www.qavalidation.com/");
		
		//test = extent.startTest("OpenUT", "Verify HomePage");//earlier version
		ExtentManager.test= ExtentManager.extent.createTest("QAVsite", "Verify HomePage");//   .createTest("QAVsite", "Verify HomePage");
		
		if(driver.getTitle().contains("QA manual"))
		{
			//test.log(LogStatus.PASS, driver.getTitle() +" contain "+"QA & Validation" );//earlier version
			//test.log(Status.PASS, driver.getTitle() +" contain "+"QA & Validation");
			//or
			ExtentManager.test.pass(driver.getTitle() +" contain "+"QA manual");
		    //test.log(Status.INFO, "Snapshot" +  test.addScreenCaptureFromPath("./1.jpg"));
		}
		else
			//test.log(LogStatus.FAIL, driver.getTitle() +" doesn't contain "+"QA & Validation" );//earlier version
			ExtentManager.test.log(Status.FAIL, driver.getTitle() +" doesn't contain "+"QA manual" );
		}
		catch(Exception e)
		{
			ExtentManager.test.log(Status.ERROR, e.getMessage());
		}
	}
	
	@Test
	public void checkFail(){
		ExtentManager.test = ExtentManager.extent.createTest("Testing how fail works");
		//test.log(Status.INFO, "fail check started");
		ExtentManager.test.fail("Test fail");
	}
		
	@AfterClass
	public static void tear()
	{
		//extent.endTest(test);//earlier version
		ExtentManager.extent.flush();
		//extent.close();
		driver.quit();
	}
}
