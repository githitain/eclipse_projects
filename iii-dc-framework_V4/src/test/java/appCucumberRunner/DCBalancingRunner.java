package appCucumberRunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/resources/appCucumberFeatures1",
				 glue={"classpath:appCucumberStepsDefinations1"},
				format={"pretty","html:target/Destination", "json:target/cucumber.json"}/*,
				tags = { "@Passed"} */
				//dryRun=true
				)

public class DCBalancingRunner extends AbstractTestNGCucumberTests
{
	
	/*@BeforeTest
	public static void setUp() 
	{
		System.out.println("This is Cucumber before method to open the instance");
	}
	
	@AfterTest
	public static void tearDown() 
	{
		System.out.println("This is Cucumber After method to open the instance");
	}*/
}
