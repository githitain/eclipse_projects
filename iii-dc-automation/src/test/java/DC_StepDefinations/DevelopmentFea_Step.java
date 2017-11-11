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
//import test.scenarios.LoginDCSuite;
//import test.scenarios.testExtensions.DCBasicSuite;

public class DevelopmentFea_Step extends DCSuites
{ 
	@BeforeTest
	public static void setUp() 
	{
		System.out.println("This is Cucumber before method to open the instance");
	}
	
	@AfterTest
	public static void tearDown() 
	{
		System.out.println("This is Cucumber After method to open the instance");
	}
  
  
   @Given("^Development User is on DC Home Page$") 
   public void goToDC()
   { 
	   System.out.println("Given - Open Browser"); 
	  
   }
	
		
   @When("^Fund report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin1()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Fund report User has verified$") 
   public void Logout1() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
   @When("^Budget Projection User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin2()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Budget Projection User has verified$") 
   public void Logout2() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
   @When("^Order Titles User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin3()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Order Titles User has verified$") 
   public void Logout3() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
   @When("^Holdings report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin4()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Holdings report User has verified$") 
   public void Logout4() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
}
