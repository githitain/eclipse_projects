package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;

public class stepDefination 
{
	public  WebDriver driver;
	private String baseUrl;


	@Given("^EV User is on DC Home Page$")
	public void ev_User_is_on_DC_Home_Page() throws Throwable 
	{
		System.setProperty("webdriver.firefox.marionette","D:\\Automation_Software\\Selenium Jars\\geckodriver.exe");  
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.msn.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	    driver.get(baseUrl + "/en-in/");
	    driver.quit();
	}


}
