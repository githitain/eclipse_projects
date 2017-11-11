package com.dc.balancing.stepdefinations;

import java.util.List;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSF 
{ 
   WebDriver driver;
	
   
   @Given("^I am on the Google page$") 
   public void goToGoogle()
   { 
	   System.out.println("Open Browser"); 
	   System.setProperty("webdriver.chrome.driver", "D:\\Automation_Software\\Selenium Jars\\chromedriver.exe");
	   driver = new ChromeDriver();
//	   System.setProperty("webdriver.firefox.marionette","D:\\Automation_Software\\Selenium Jars\\geckodriver.exe");
//		driver= new FirefoxDriver();
      //Intiate web browser instance. driver = new FirefoxDriver();
      driver.navigate().to("https://www.Google.com/"); 
   } 
	
   @When("^I enter Search Term and click on submit button$") 
   //public void enterData(//DataTable table)
	public void enterData(DataTable table)
		   { 
	   System.out.println("Enter Data in google search");
	      //Initialize data table 
	   List<List<String>> data = table.raw();
	      System.out.println(data.get(7).get(1)); 
 
	      //Enter data
	   		//driver.findElement(By.xpath(" //a[text()='Gmail']")).click(); 
	      //driver.findElement(By.id("lst-ib")).sendKeys("selenium");
	      driver.findElement(By.id("lst-ib")).sendKeys(data.get(7).get(1));
	      driver.findElement(By.name("btnK")).click(); 
	    
   } 
	
   @Then("^Close the Application$") 
   public void QuitApplication() 
   {
	   System.out.println("Close");
	  driver.close(); 
   } 
   
   @When("^I Click on the Gmail link$") 
   public void VerifyGmail() 
   {
	   System.out.println("VerifyGmail-Functinaly");
	   driver.findElement(By.xpath("//a[text()='Gmail']")).click();  
   } 
   
   @When("^I Click on the Sign in link$") 
   public void VerifySignin() 
   {
	   System.out.println("Verify Sign-Functinaly");
	   driver.findElement(By.xpath("//a[text()='Sign in']")).click();  
   } 
   
   @When("^I Click on the Images link$") 
   public void VerifyImages() 
   {
	   System.out.println("Verify Sign-Functinaly");
	   driver.findElement(By.xpath("//a[text()='Images']")).click();  
   } 
   
}
