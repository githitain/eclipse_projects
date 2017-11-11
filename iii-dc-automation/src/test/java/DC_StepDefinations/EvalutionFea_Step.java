package DC_StepDefinations;

import java.util.List;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.scenarios.LoginDCSuite;
import test.scenarios.testExtensions.DCBasicSuite;

public class EvalutionFea_Step extends LoginDCSuite 
{ 
	
	
  
	
   @Given("^Evalution User is on DC Home Page$") 
   public void goToDC()
   { 
	   System.out.println("Given - Open Browser"); 
	  
   }
	
		
   @When("^Bib Level report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin1()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Bib Level report User has verified$") 
   public void Logout1() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
   @When("^Call Number Range User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin2()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Call Number Range User has verified$") 
   public void Logout2() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
   @When("^Format report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin3()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Format report User has verified$") 
   public void Logout3() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
   @When("^Funds report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin4()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Funds report User has verified$") 
   public void Logout4() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);
   } 
   
   
   @When("^Language report User is logged in into DC and currently is under Evaluation mode$") 
   public void DCLogin5()
   {
	   System.out.println("WHen - User is logined");
	   getSession().getDCLoginPage().DClogin();
    } 
	
   @Then("^Language report User has verified$") 
   public void Logout5() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);

   } 
   
   
}
