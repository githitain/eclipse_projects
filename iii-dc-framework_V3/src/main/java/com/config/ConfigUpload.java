package com.config;

/*import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;*/

import com.file.handling.exlReader;
import com.file.handling.proReader;
//import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.utilites.LogStatuses;
import com.utilites.Logger;

/*import java.net.URL; 
import java.net.URLClassLoader;
import java.util.List;*/

public class ConfigUpload 
{
	public static String snapshotmode;
	public static String FailedScreenshotPath;
	public static String PassedScreenshotPath;
	
	public ConfigUpload() throws Exception 
	{

		Logger.write(LogStatuses.INFO, "############# Loading Config and one time loaded Resources #############");
		
		proReader pr = new proReader();
		Logger.write(LogStatuses.INFO, "############# configuration files is loaded");
		
		exlReader el = new exlReader();
		Logger.write(LogStatuses.INFO, "############# Object Repository files is loaded");

	
		snapshotmode=proReader.getString("snapshotmodeStatus");
		Logger.write(LogStatuses.INFO, "############# Screen shot = " + snapshotmode);
		
		FailedScreenshotPath=proReader.getString("FailedScreenshot");
		Logger.write(LogStatuses.INFO, "############# FailedScreenshot Path = " + FailedScreenshotPath);
		
		PassedScreenshotPath=proReader.getString("PassedScreenshot");
		Logger.write(LogStatuses.INFO, "############# PassedScreenshot Path = " + PassedScreenshotPath);
	
	}
	
	
	/*public static void main(String[] args) throws Exception 
	 {
			ConfigUpload upload = new ConfigUpload();
			
			System.out.println("1-Load testNg File----------------------------------------------------------------------------------");
			TestListenerAdapter tla = new TestListenerAdapter();
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("Z1testng.xml");//path to xml..
			//suites.add("c:/tests/testng2.xml");
			testng.setTestSuites(suites);
			System.out.println("2-Run testNg File-----------------------------------------------------------------------------------");
			testng.run();
			System.out.println("End-Execution of  testNg File-----------------------------------------------------------------------------------");

	 }*/

}
