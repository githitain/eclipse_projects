package appCucumberStepsDefinations;

import com.main.mainExecutor;

/*import app.test.scenarios.testExtensions.DCBasicSuite;
import appTestRunner.DCSuites;*/
/*import cucumber.api.Scenario;
import cucumber.api.java.After;*/
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
	  
	  try
	   {
		   getSession().sendKeys("DC", "username_inputbox", "dc", "username");
		   getSession().sendKeys("DC", "password_inputbox", "dc", "password");
		   getSession().performClick("DC", "submit_btn");
		   
		   getSession().PassedScreenshot("Subject User has verified");
		   
	   }
	   catch (Exception e) 
		{
		   	getSession().FailedScreenshot("Subject User has verified");
			e.printStackTrace();
			getSession().close();
			throw e;
		}

	  
	   
    } 
	
   @Then("^Subject User has verified$") 
   public void DCBalancingTest2() throws Exception 
   {
	   getSession().getDCLoginPage().verifyTextONLogin("Welcome");

	   
   }
   
   @When("^Location report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCBalancingTest3() throws Exception
   {
	   
	   	
		  //getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  //getSession().getDCLoginPage().DClogout();

	
    } 
   

	
   @Then("^Location report has verified$") 
   public void DCBalancingTest4() throws Exception 
   {
	   		System.out.println("Before getsession-1");
		  //getSession().getDCLoginPage().DClogin();
		  System.out.println("Before getsession-2");
		  //getSession().getDCLoginPage().DClogout();
		   System.out.println("DCBalancingFea_Step-2-WHen - User is logined");

	   Thread.sleep(3000);
   } 
   
   @Then("^Balancing User is close the application$") 
   public void wclose() throws Exception 
   {
	   getSession().performClick("DC", "signOut_link");
	   closeDriver();
	   
	   System.out.println("DCBalancingFea_Step-6--than- Balancing User is close the application$");


   } 
  }
