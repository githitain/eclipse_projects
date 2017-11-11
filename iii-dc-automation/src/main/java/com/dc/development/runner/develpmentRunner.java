package com.dc.development.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="classpath:features/developmentFeatures",
										glue={"classpath:com/dc/development/stepdefinations"},
										format={"pretty","html:target/Destination", "json:target/cucumber.json"}/*,
										tags = { "@Passed"} */
										//dryRun=true
									)


public class develpmentRunner extends AbstractTestNGCucumberTests
{

}
