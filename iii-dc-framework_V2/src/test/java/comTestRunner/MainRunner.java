package comTestRunner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import java.net.URL; 
import java.net.URLClassLoader;
import java.util.List;

public class MainRunner 
{
	public static void main(String[] args) 
	 {
		 
		/* ClassLoader cl = ClassLoader.getSystemClassLoader();
		 URL[] urls = ((URLClassLoader)cl).getURLs(); 
		 for(URL url: urls)
		 { 
			 System.out.println(url.getFile()); 
		 }*/

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

	 }

}
