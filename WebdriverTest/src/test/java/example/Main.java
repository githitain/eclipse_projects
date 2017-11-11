package example;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Main 
{
	public static void main (String [] args) 
	{
		
		System.out.println("1-Load testNg File");
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("testng.xml");//path to xml..
		//suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		System.out.println("2-Run testNg File");
		testng.run();
		System.out.println("End-Execution of  testNg File");

	}
	
}
