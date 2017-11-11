package testCuucmber;

import org.testng.annotations.Test;

import cucumber.api.java.en.When;
import test.scenarios.testExtensions.DCBasicSuite;

public class testClass  extends DCBasicSuite 
{
	 //@When("^I perofrm login with vaild info$") 
		 @Test(groups = {"smoke", "test"})
	 @When("^I perofrm login with vaild info$") 
		    public void login1() throws Exception
		    {
			 	getSession().getDCLoginPage().DClogin();
		 
		    }
}
