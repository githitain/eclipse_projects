package testCuucmber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import test.scenarios.testExtensions.DCBasicSuite;

@CucumberOptions(features="D:\\Hit_Worksapce2\\iii-dc-automation\\src\\test\\java\\testCuucmber",
				//glue={"D:/Hit_Workspace/DC_Main_Automation/src/test/java/testCuucmber"},
				format={"pretty","html:target/Destination", "json:target/cucumber.json"}/*,
				tags = { "@Passed"} */
				//dryRun=true
				)

public class DCTestRunner extends AbstractTestNGCucumberTests
{
	
	static	
	{
	 System.out.println("In DC_Evalution_TestRunner Runner file");
	}
}
