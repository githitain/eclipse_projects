package Z5.java.testng;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

import main.utils.LogStatuses;
import main.utils.Logger;

public class BasicSuite 
{

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method)
	{
		
		System.out.println("Step-3-BeforeMethod- Under BasicSuite");
		TestRunSuffix.refresh();
		System.out.println("Step-3-BeforeMethod- Under BasicSuite after TestRunSuffix");
		System.out.println("Starting test " + method.getName());
		Logger.write(LogStatuses.INFO, "Starting test " + method.getName());
		/*TestRunSuffix.refresh();
		System.out.println("BasicSuite-beforeMethod-03");
		Logger.write(LogStatuses.INFO, "########################################################################");
		Logger.write(LogStatuses.INFO, "Starting test " + method.getName());*/
		
	}
}
