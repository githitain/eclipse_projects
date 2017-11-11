package Z5.java.testng;

import org.testng.annotations.BeforeMethod;

import main.config.TestSettings;

public abstract class EncoreBasicSuite extends BasicSuite
{
	private static final ThreadLocal<EncoreWebSession> threadLocalSession = new ThreadLocal<EncoreWebSession>();
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest()
	{
		threadLocalSession.set(new EncoreWebSession());
		System.out.println("Step-2-BeforeMethod- Under EncoreBasicSuite");
		threadLocalSession.get().navigate(TestSettings.Current.getEncoreWebURL());
		//threadLocalSession.get().navigate(TestSettings.Current.getEncoreWebURL());
		System.out.println("EncoreBasicSuite class - step - 01");
	}

}
