package DcTestSuites;



import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import com.dc.connectivity.exlReader;
import com.dc.connectivity.proReader;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import main.tests.execution.BasicSuite;
import test.scenarios.testExtensions.DCBasicSuite;

import java.net.URL; 
import java.net.URLClassLoader;
import java.util.List;

public class DCSuites extends DCBasicSuite 
{
	

	/*	System.out.println("Static block executed");
		 ClassLoader cl = ClassLoader.getSystemClassLoader();
		 URL[] urls = ((URLClassLoader)cl).getURLs(); 
		 for(URL url: urls)
		 { 
			 System.out.println(url.getFile()); 
		 }*/
		 
/*		 
		 	proReader pr = new proReader();
			//System.out.println("constrcutor for proReader has been load");

			exlReader el = new exlReader();
			
			///System.out.println("constrcutor for exlReader has been load");
*/		 

		
	@Test(groups = {"smoke", "test"})
    public void Balancing_Suite() throws Exception
    {
		System.out.println("1-Load Test Cases File-1---------------------------------------------------------------------------------");
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//suites.add("D:/Hit_Worksapce2/iii-dc-automation/Resources/testng_DCepm.xml");//path to xml..
		suites.add("Resources/DC_Suites/BalancingSuite.xml");//path to xml..
		//suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		System.out.println("2-Run Test Cases File---1--------------------------------------------------------------------------------");
		testng.run();			
//		suites.add("Resources/testng_rest.xml");
//		testng.run();
		System.out.println("End-Execution of  TestCases File---1--------------------------------------------------------------------------------");
    }
	
	/*@Test(groups = {"smoke", "test"})
    public void Development_Suites() throws Exception
    {
		System.out.println("-Load Test Cases File-2----------------------------------------------------------------------------------");
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//suites.add("D:/Hit_Worksapce2/iii-dc-automation/Resources/testng_DCepm.xml");//path to xml..
		suites.add("Resources/DC_Suites/DevelopmentSuite.xml");//path to xml..
		//suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		System.out.println("2-Run Test Cases File-2----------------------------------------------------------------------------------");
		testng.run();			
//		suites.add("Resources/testng_rest.xml");
//		testng.run();
		System.out.println("End-Execution of  TestCases File--2---------------------------------------------------------------------------------");
    }
	
	

	@Test(groups = {"smoke", "test"})
    public void Evalution_Suite() throws Exception
    {
		System.out.println("-Load Test Cases File-2----------------------------------------------------------------------------------");
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//suites.add("D:/Hit_Worksapce2/iii-dc-automation/Resources/testng_DCepm.xml");//path to xml..
		suites.add("Resources/DC_Suites/EvalutionSuite.xml");//path to xml..
		//suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		System.out.println("2-Run Test Cases File-2----------------------------------------------------------------------------------");
		testng.run();			
//		suites.add("Resources/testng_rest.xml");
//		testng.run();
		System.out.println("End-Execution of  TestCases File--2---------------------------------------------------------------------------------");
    }
	
	
	@Test(groups = {"smoke", "test"})
    public void Maintenance_Suite() throws Exception
    {
		System.out.println("-Load Test Cases File-2----------------------------------------------------------------------------------");
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//suites.add("D:/Hit_Worksapce2/iii-dc-automation/Resources/testng_DCepm.xml");//path to xml..
		suites.add("Resources/DC_Suites/MaintenanceSuite.xml");//path to xml..
		//suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		System.out.println("2-Run Test Cases File-2----------------------------------------------------------------------------------");
		testng.run();			
//		suites.add("Resources/testng_rest.xml");
//		testng.run();
		System.out.println("End-Execution of  TestCases File--2---------------------------------------------------------------------------------");
    }*/
			
	 }


