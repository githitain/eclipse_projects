package DC_StepDefinations;

import java.util.List;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DcTestSuites.DCSuites;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.scenarios.LoginDCSuite;
//import test.scenarios.LoginEncoreSuite;


public class BalancingFea_Step extends DCSuites 
{ 

  
   @Given("^Balancing User is on DC Home Page$") 
   public void goToDC()
   { 
	   System.out.println("Given - Open Browser"); 
   }
	
   @Test	
   @When("^Weeding User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin1()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Weeding User has verified$") 
   public void Logout1() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);
   } 
   
   
}
