package com.dc.development.stepdefinations;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dc.common.functions.cFuntion;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class developmentStepWithPageObjects 
{
	public  WebDriver driver= null;

	///Scenarios-1-------------------------------------------------------->
	@Given("^User is on DC Home Page$")
	public  void User_is_on_DC_Home_Page() throws Exception
	{
		//CommanFuntion.init_open();
		cFuntion.init_open();
	}

	@When("^User is logged in into DC and currently is under Evaluation mode$")
	public  void User_is_logged_in_into_DC_and_currently_is_under_Evaluation_mode() throws Exception
	{
		cFuntion.waitThread(2);
		System.out.println("Give UserName");
		cFuntion.sendKeysInput("DC","username_inputbox","dc","username");
		
		System.out.println("Give Password");
		cFuntion.sendKeysInput("DC","password_inputbox","dc","password");
		
		System.out.println("Click on Button");
		cFuntion.clickLink("DC","submit_btn");
		
		cFuntion.waitThread(5);
		
		System.out.println("Click on Evalution Mode");
		//cFuntion.clickLink("DC","evalutionMode_img");
	
		cFuntion.waitThread(4);
	}
	
	@Then("^User has verified that Expenditure Trends sub-category is present under Acquisitions$")
	public  void User_has_verified_that_Expenditure_Trends_subcategory_is_present_under_Acquisitions()
	{
		
		System.out.println("Verify The Expenditure elemnt");
		cFuntion.verifyElement("DC","acquistionsExpenditures_link");
		
		cFuntion.waitThread(4);
		
		System.out.println("Verify The Expenditure Trend elemnt");
		cFuntion.verifyElement("DC","acquistionsExpendituresTrand_link");
	
	}
	
	@And("^User Expands Expenditure Trends sub-category$")
	public void And_User_Expands_Expenditure_Trends_sub_category()
	{
		//cFuntion.clickLink("DC", "acquistionsExpendituresTrand_link");
	}
	
	@Then("^User Expenditure Trends sub-category should be expandable and Following reports should be present Expenditure Trends by Bib Level$")
	public  void Expenditure_Trends_subcategory_should_be_expandable_and_Following_reports_should_be_present()
	{
		
		System.out.println("Verify Report with link  Expenditure Trends by Bib Level");
		cFuntion.verifyElement("DC","ExpenditureTrendsByBibLevel_link");
		
		System.out.println("Verify Report with link  Expenditure Trends by Call Number Range");
		cFuntion.verifyElement("DC","ExpenditureTrendsByCallNubmberRange_link");
		
		System.out.println("Verify Report with link  Expenditure Trends by Format");
		cFuntion.verifyElement("DC","ExpenditureTrendsByFormat_link");
		
		System.out.println("Verify Report with link   Expenditure Trends by Funds");
		cFuntion.verifyElement("DC","ExpenditureTrendsByFunds_link");
		
	
	}
	
	///Scenarios-2-------------------------------------------------------->
	
	@And("^User Expands Expenditure Trends sub-category and click on the report Expenditure Trends by Bib Level$")
	public void And_User_Expands_Expenditure_Trends_sub_category_click_on_a_report()
	{
		
		//cFuntion.clickLink("DC", "ExpenditureTrendsByBibLevel_link");
		cFuntion.waitThread(4000);
	}
	
	
	@Then("^User verifies the Go button$")
	public  void User_verify_the_Go_button()
	{
		cFuntion.waitThread(4000);
		System.out.println("Verify Go Buttn");
		//cFuntion.verifyElement("DC","go_btn");
	}
	
	
	@And("^User clicks on Go button$")
	public  void User_clicks_on_Go_button()
	{
		cFuntion.waitThread(4000);
		System.out.println("click on Go Buttn");
		//cFuntion.clickLink("DC","go_btn");
	}
	
	@Then("^Users verifies the Report Expenditure Trends by Bib Level$")
	public  void User_verifies_the_Report_Expenditure_Trends_by_Bib_Level()
	{
		System.out.println("Verify Report");
		/*cFuntion.verifyElement("DC","fieldTotalForTimePeriod_label");
		cFuntion.verifyElement("DC","email_btn");
		cFuntion.verifyElement("DC","export_btn");*/
	}
	
	@And("^User clicks on sign out link$")
	public  void User_clicks_on_signout_link()
	{
		cFuntion.waitThread(4000);
		System.out.println("click on sign out link");
		cFuntion.clickLink("DC","signOut_link");
		
		//cFuntion.clickLink2(".//*[@id='username']");
	}
	
	@Then("^Users verifies the login page$")
	public  void User_verifies_the_login_page()
	{
		cFuntion.waitThread(4000);
		System.out.println("Verify login page");
		cFuntion.verifyElement("DC","username_inputbox");
	}
	
	@And("^User quits the browser for C60821$")
	public void User_close_browser_C60821()
	{
		cFuntion.quit_Browser();
	}
}
