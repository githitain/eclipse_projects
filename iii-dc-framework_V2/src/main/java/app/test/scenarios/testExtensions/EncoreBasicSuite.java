package app.test.scenarios.testExtensions;
import org.testng.annotations.BeforeMethod;

import com.setting.TestSettings;
import com.test.suite.CommonSuite;

import app.sessions.EncoreWebSession;

public abstract class EncoreBasicSuite extends CommonSuite
{

	private static final ThreadLocal<EncoreWebSession> threadLocalSession = new ThreadLocal<EncoreWebSession>();
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest()
	{
		threadLocalSession.set(new EncoreWebSession());
		threadLocalSession.get().navigate(TestSettings.Current.getEncoreWebURL());
		System.out.println("EncoreBasicSuite class - step - 01");
	}

	protected EncoreWebSession getSession()
	{
		return threadLocalSession.get();
	}
}