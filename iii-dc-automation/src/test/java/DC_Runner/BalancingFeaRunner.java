package DC_Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import test.scenarios.testExtensions.DCBasicSuite;

@CucumberOptions(features="classpath:DC_features",
				 glue={"classpath:DC_StepDefinations"},
				format={"pretty","html:target/Destination", "json:target/cucumber.json"}/*,
				tags = { "@Passed"} */
				//dryRun=true
				)

public class BalancingFeaRunner extends AbstractTestNGCucumberTests
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
}
