package app.test.scenarios;

import org.testng.internal.MethodHelper;

import com.sessions.BrowserSession;
import com.sessions.ProxyFactory;
import com.setting.TestSettings;
import com.test.suite.CommonSuite;

import app.sessions.DCWebSession;
import app.test.scenarios.testExtensions.DCBasicSuite;
import net.lightbody.bmp.BrowserMobProxy;

import java.lang.reflect.Method;

public class main 
{
	CommonSuite Bs = new CommonSuite();
	public void run()
	{
		
		//Bs.beforeMethod(null);
	}
	
	
	public static void main (String args[]) throws Exception
	{
		main m1 = new main();
		
		m1.run();
		//Step-7-BasicSuite-beforeMethod
		/*BasicSuite Bs = new BasicSuite();
		Bs.beforeMethod();
		*/
	
		
		//BrowserSession bs = new BrowserSession();
		//Step-2-DCBasicSuite-beforeTest
		DCBasicSuite Ds = new DCBasicSuite();
		Ds.beforeTest();
		
		TestSettings ts = new TestSettings();
		
		BrowserSession bs1 = new BrowserSession();
		
		
		
		
		//Ds.beforeTest();
		
		//Step-5-BrowserSession-BrowserSession
		
		/*TestSettings ts = new TestSettings();
		ProxyFactory ps= new ProxyFactory();
		*/
		
		//Step-4-DCWebSession-DCWebSession
		DCWebSession dw = new DCWebSession();
		dw.getBrowser();
		
		
		//Step-1-LoginDCSuite-login1
		LoginDCSuite dc1 = new LoginDCSuite();
		
		dc1.login1();
		
		//Step-3-DCBasicSuite-getSession
		Ds.getSession();
		
		//Step-8-BasicSuite-afterMethod
		//Bs.afterMethod();

}

	
}
