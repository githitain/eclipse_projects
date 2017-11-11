package DC_Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import test.scenarios.testExtensions.DCBasicSuite;


@CucumberOptions(features="classpath:DC_features/Evalution.Fea",
				 glue={"classpath:/DC_StepDefinations"},
				format={"pretty","html:target/Destination", "json:target/cucumber.json"}/*,
				tags = { "@Passed"} */
				//dryRun=true
				)

public class EvalutionFeaRunner extends AbstractTestNGCucumberTests
{
	
	static	
	{
	 System.out.println("In DC_Evalution_TestRunner Runner file");
	}
}
