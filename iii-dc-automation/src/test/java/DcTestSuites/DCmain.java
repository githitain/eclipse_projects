package DcTestSuites;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import main.file.handling.exlReader;
import main.file.handling.proReader;
import test.scenarios.testExtensions.DCBasicSuite;

public class DCmain //extends DCBasicSuite 
{

	//DCBasicSuite dc = new DCBasicSuite();
	
	public static void main(String[] args) 
		{
		
			
			 ClassLoader cl = ClassLoader.getSystemClassLoader();
			 URL[] urls = ((URLClassLoader)cl).getURLs(); 
			 for(URL url: urls)
			 { 
				 System.out.println(url.getFile()); 
			 }
			 
			 
			 	proReader pr = new proReader();
				System.out.println("constrcutor for proReader has been load");

				exlReader el = new exlReader();
				
				System.out.println("constrcutor for exlReader has been load");
			 
				System.out.println("1-Load MainSuites File----------------------------------------------------------------------------------");
				TestListenerAdapter tla = new TestListenerAdapter();
				TestNG testng = new TestNG();
				List<String> suites = Lists.newArrayList();
				//suites.add("D:/Hit_Worksapce2/iii-dc-automation/Resources/testng_DCepm.xml");//path to xml..
				suites.add("Resources/DC_Suites/DCMainSuites.xml");//path to xml..
				//suites.add("c:/tests/testng2.xml");
				testng.setTestSuites(suites);
				System.out.println("2-Run MainSuites File-----------------------------------------------------------------------------------");
				testng.run();

//				suites.add("Resources/testng_rest.xml");
//				testng.run();
				System.out.println("End-Execution of  MainSuites File-----------------------------------------------------------------------------------");
		
				//dcb.afterMethod(null);
				
		    }
	
}
