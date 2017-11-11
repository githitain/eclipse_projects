package test.scenarios.testExtensions;
import main.config.TestSettings;
import main.tests.execution.BasicSuite;
import org.testng.annotations.BeforeMethod;
import test.sessions.EncoreWebSession;

public abstract class EncoreBasicSuite extends BasicSuite
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