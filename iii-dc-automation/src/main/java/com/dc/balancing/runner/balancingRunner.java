package com.dc.balancing.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="classpath:features",
										glue={"classpath:com/dc/balancing/stepdefinations"},
										format={"pretty","html:target/Destination", "json:target/cucumber.json"},
										tags = { "@Passed"} 
										//dryRun=true
									)

public class balancingRunner extends AbstractTestNGCucumberTests
{
	static	{
	 System.out.println("In DC_Evalution_TestRunner Runner file");
	}
}
