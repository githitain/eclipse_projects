package appCucumberStepsDefinations;

import java.util.List;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sessions.BrowserSession;
import com.web.ui.pages.WebPage;

import app.sessions.DCWebSession;
import app.test.scenarios.LoginDCSuite;
import app.test.scenarios.testExtensions.DCBasicSuite;
import app.web.ui.pages.DCLoginPage;
import appTestRunner.DCSuites;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DCMaintenanceFea_Step extends DCSuites
{ 
  
@Given("^Maintenance User is on DC Home Page$") 
   public void goToDC()
   { 
	   System.out.println("Given - Open Browser"); 
	  
   }
	
		
   @When("^Weeding User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin1()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Weeding User has verified$") 
   public void Logout1() throws InterruptedException 
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
}
