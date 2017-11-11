package appCucumberStepsDefinations;

import org.testng.annotations.Test;
import appTestRunner.DCSuites;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import test.scenarios.LoginEncoreSuite;


public class DCBalancingFea_Step extends DCSuites 
{ 

  
   @Given("^Balancing User is on DC Home Page$") 
   public void goToDC()
   { 
	   System.out.println("Given - Open Browser"); 
   }
	
   	
   @When("^Subject User is logged in into DC and currently is under Evaluation mode$") 
   public void DCBalancingTest1()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Subject User has verified$") 
   public void DCBalancingTest2() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);
   } 
   
   
   @When("^Location report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCBalancingTest3()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Location report has verified$") 
   public void DCBalancingTest4() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);
   } 
   
}
