package appCucumberStepsDefinations;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import app.test.scenarios.mainExecutor;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DCMaintenanceFea_Step extends mainExecutor
{ 
	
@Given("^Maintenance User is on DC Home Page$") 
   public void goToDC()
   { 
	 		System.out.println("DCMaintenanceFea_Step-1-WHen - Maintenance User is on DC Home Page");
			System.setProperty("webdriver.chrome.driver", "D:\\Automation_Software\\Selenium Jars\\chromedriver.exe");
			System.setProperty("webdriver.firefox.marionette","D:\\Automation_Software\\Selenium Jars\\geckodriver.exe");

			
	  
   }
	
		
   @When("^Weeding User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin1()
   {
	   System.out.println("Before getsession-1");
		  getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  getSession().getDCLoginPage().DClogout();
	   System.out.println("DCMaintenanceFea_Step-2-WHen - Weeding User is logged in into DC and currently is under Evaluation mode");
	   
    } 
	
   @Then("^Weeding User has verified$") 
   public void Logout1() throws InterruptedException 
   {
	   System.out.println("Before getsession-1");
		  getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  getSession().getDCLoginPage().DClogout();
	   System.out.println("DCMaintenanceFea_Step-3-than- Weeding User has verified");
	   Thread.sleep(3000);

   } 
   
   @Then("^Maintenance User is close the application$") 
   public void close() 
   {
	   MEclose();
	   System.out.println("DCMaintenanceFea_Step-4-than- Maintenance User is close the application");
	  
   } 
   
   @After("@browser")
   public void tearDown(Scenario scenario) 
   {
	
   }
   
}
