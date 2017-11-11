package Z3.threading;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenB2 
{
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();


	  @BeforeTest
	  public void setUp() throws Exception 
	  {
		 
		  System.setProperty("webdriver.chrome.driver", "D:\\Automation_Software\\Selenium Jars\\chromedriver.exe");
		driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
	    baseUrl = "http://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testGoogle() throws Exception 
	  {
		  Thread.sleep(6000);
		    driver.get(baseUrl);
		   
	  }
	  @AfterTest
	  public void tearDown() throws Exception
	  {
	    driver.quit();
	    
	   }
}
