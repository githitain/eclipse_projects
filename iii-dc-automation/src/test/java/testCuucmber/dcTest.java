package testCuucmber;

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

public class dcTest extends DCBasicSuite 
{ 
   //WebDriver driver;
	
   
   /*@Given("^I am on the DC page$") 
   public void goToDC()
   { 
	   System.out.println("Open Browser"); 
	   System.setProperty("webdriver.chrome.driver", "D:\\Automation_Software\\Selenium Jars\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.navigate().to("http://dc-autonoida.iii.com/iii/dc-noida/login/auth/"); 
   } */
	
	@Test(groups = {"smoke", "test"})
    public void login1() throws Exception
    {
	 	System.out.println("Open the Browser instance");
 
    }

	//@Test(groups = {"smoke", "test"})
   @When("^I perofrm login with vaild info$") 
   @Test(groups = {"smoke", "test"})
   public void DCLogin()
   {
	   System.out.println("TestCase is open");
//	   driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("dcadmin");  
//	   driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("noidaadmin");  
//	   driver.findElement(By.xpath(".//*[@id='submit']")).click();  
	   
	   getSession().getDCLoginPage().DClogin();
      


   } 
	
   @Then("^I perofrm logout$") 
   public void QuitApplication() throws InterruptedException 
   {
	   getSession().getDCLoginPage().DClogout();
	   Thread.sleep(3000);
//	   driver.close(); 
   } 
   
}
