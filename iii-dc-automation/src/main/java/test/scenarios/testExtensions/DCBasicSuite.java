package test.scenarios.testExtensions;
import main.config.TestSettings;
import main.file.handling.exlReader;
import main.file.handling.proReader;
import main.tests.execution.BasicSuite;
import test.sessions.DCWeb2Session;
import test.sessions.DCWebSession;

import org.testng.annotations.BeforeMethod;


public class DCBasicSuite extends BasicSuite
{

	
	private static final ThreadLocal<DCWebSession> threadLocalSession = new ThreadLocal<DCWebSession>();
	//private static final ThreadLocal<DCWeb2Session> threadLocalSession2 = new ThreadLocal<DCWeb2Session>();

	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest()
	{
		//private static final ThreadLocal<DCWebSession> threadLocalSession = new ThreadLocal<DCWebSession>();
		System.out.println("Step-2-DCBasicSuite-beforeTest");
		/*proReader pr = new proReader();
		System.out.println("constrcutor for proReader has been load");

		exlReader el = new exlReader();
		
		System.out.println("constrcutor for exlReader has been load");*/
		
		
		//TestSettings ts = new TestSettings();
		threadLocalSession.set(new DCWebSession());
		threadLocalSession.get().navigate(TestSettings.Current.getDCWebURL());
		System.out.println("DCBasicSuite class - step - 01");
	}

	public DCWebSession getSession()
	{
		System.out.println("Step-3-DCBasicSuite-getSession");
		return threadLocalSession.get();
	}
}