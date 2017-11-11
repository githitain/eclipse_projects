package com.dc.mainTest;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class mainParllerTestngXml 
{
	public static void main(String[] args) 
	 {
		
		TestListenerAdapter tla = new TestListenerAdapter();
		
		
		TestNG testng = new TestNG();
		
		List<String> suites = Lists.newArrayList();
		
		suites.add("Resources/testng.xml");//path to xml..
		
		suites.add("Resources/testng_rest.xml");
		
		testng.setTestSuites(suites);
		
		testng.run();
	 }
	
}
