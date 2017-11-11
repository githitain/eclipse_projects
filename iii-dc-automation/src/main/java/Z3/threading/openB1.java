package Z3.threading;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class openB1 
{
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();


	  @BeforeTest
	  public void setUp() throws Exception 
	  {
		 
		 System.setProperty("webdriver.firefox.marionette","D:\\Selenium jar\\Selenium-3.4.0\\geckodriver.exe");  
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.msn.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testMSN() throws Exception 
	  {
		  Thread.sleep(7000);
		    driver.get(baseUrl + "/en-in/");
	    
	  }
	  @AfterTest
	  public void tearDown() throws Exception
	  {
	    driver.quit();
	    
	   }
}
