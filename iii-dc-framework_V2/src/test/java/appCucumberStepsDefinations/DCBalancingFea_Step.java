package appCucumberStepsDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.main.Main;

import app.test.scenarios.mainExecutor;
import app.test.scenarios.testExtensions.DCBasicSuite;
import appTestRunner.DCSuites;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import test.scenarios.LoginEncoreSuite;


public class DCBalancingFea_Step extends mainExecutor
{ 
	  
  
   @Given("^Balancing User is on DC Home Page$") 
   public void goToDC()
   { 
	 
	   System.out.println("Given - Open Browser"); 
   }
	
   	
   @When("^Subject User is logged in into DC and currently is under Evaluation mode$") 
   public void DCBalancingTest1() throws Exception
   {
	   System.out.println("Before getsession-1");
	  getSession().getDCLoginPage().DClogin();
	  System.out.println("Before getsession-2");
	  getSession().getDCLoginPage().DClogout();
	   System.out.println("DCBalancingFea_Step-2-WHen - User is logined");
	
    } 
	
   @Then("^Subject User has verified$") 
   public void DCBalancingTest2() throws Exception 
   {
	   System.out.println("Before getsession-1");
		  getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  getSession().getDCLoginPage().DClogout();
		   System.out.println("DCBalancingFea_Step-2-WHen - User is logined");
   } 
   
   
   @When("^Location report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCBalancingTest3() throws Exception
   {
	   
	   System.out.println("Before getsession-1");
		  getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  getSession().getDCLoginPage().DClogout();
		   System.out.println("DCBalancingFea_Step-2-WHen - User is logined");
	  
	   System.out.println("WHen - User is logined");
	   System.out.println("DCBalancingFea_Step-4--when- Location report User is logged in into DC and currently is under Evaluation mode");

    } 
   

	
   @Then("^Location report has verified$") 
   public void DCBalancingTest4() throws Exception 
   {
	   		System.out.println("Before getsession-1");
		  getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  getSession().getDCLoginPage().DClogout();
		   System.out.println("DCBalancingFea_Step-2-WHen - User is logined");

	   Thread.sleep(3000);
   } 
   
   @Then("^Balancing User is close the application$") 
   public void wclose() throws Exception 
   {
	   MEclose();
	   
	   System.out.println("DCBalancingFea_Step-6--than- Balancing User is close the application$");


   } 
  }
