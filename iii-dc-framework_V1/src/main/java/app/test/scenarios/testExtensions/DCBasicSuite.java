package app.test.scenarios.testExtensions;
import org.testng.annotations.BeforeMethod;

import com.file.handling.exlReader;
import com.file.handling.proReader;
import com.setting.TestSettings;
import com.test.suite.CommonSuite;

import app.sessions.DCWebSession;


public class DCBasicSuite extends CommonSuite
{

	
	private static final ThreadLocal<DCWebSession> threadLocalSession = new ThreadLocal<DCWebSession>();

	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest()
	{
		System.out.println("Step-2-DCBasicSuite-beforeTest");
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