package app.test.scenarios;

//import org.testng.internal.MethodHelper;

import com.file.handling.exlReader;
import com.file.handling.proReader;

import com.setting.TestSettings;
//import com.test.suite.CommonSuite;

import app.sessions.DCWebSession;
import app.test.scenarios.testExtensions.DCBasicSuite;

public class mainExecutor extends DCBasicSuite
{
	
	String s1="Launch mainExecutor called to open browser";
	String s2="ab";
	String s3="abs";
	
		proReader pr = new proReader();
		exlReader el = new exlReader();
	
	public  DCWebSession SE;

	//CommonSuite Bs = new CommonSuite();
	/*DCBasicSuite Ds = new DCBasicSuite();
	//TestSettings ts = new TestSettings();
	LoginDCSuite dc1 = new LoginDCSuite();*/
	
	public  mainExecutor()
	{
		System.out.println(s1);
		beforeMethod();
		beforeTest();
		TestSettings ts = new TestSettings();
		
	}
	
	
	public mainExecutor(String s1)
	{
		System.out.println(s1);
		//CommonSuite Bs = new CommonSuite();
		//Bs.beforeMethod();
		//DCBasicSuite Ds = new DCBasicSuite();
		beforeTest();
		//TestSettings ts = new TestSettings();
		
		
	}
	
	public mainExecutor(String s1, String s2) throws Exception
	{
		
		/*mainExecutor.getSession().getDCLoginPage().DClogin();
		mainExecutor.getSession().getDCLoginPage().DClogout();*/
		System.out.println(s1);
		System.out.println(s2);
		LoginDCSuite dc1 = new LoginDCSuite();
		dc1.login1();
	}
	
	public mainExecutor(String s1,String s2,String s3)
	{
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		//Bs.close();
	}
	
	public void MEopen()
	{
		System.out.println(s1);
		//CommonSuite Bs = new CommonSuite();
		//Bs.beforeMethod();
	}
	
	public void MEsession()
	{
		//Bs.beforeMethod();
		DCBasicSuite Ds = new DCBasicSuite();
		Ds.beforeTest();
		TestSettings ts = new TestSettings();
		
	}
	
	
	
	
	
	
	public void MERun() throws Exception
	{
		new mainExecutor(s1,s2);
	}
	
	public void MEclose()
	{
		/*new mainExecutor(s1,s2,s3);
		
		System.out.println(s1);*/
		//CommonSuite Bs = new CommonSuite();
		//Bs.close();
		webclose();
		
		
	}
	

	
	
/*	public void MESesion()
	{
		System.out.println(s1);
		//CommonSuite Bs = new CommonSuite();
		Bs.beforeMethod();
		DCBasicSuite Ds = new DCBasicSuite();
		Ds.beforeTest();
		TestSettings ts = new TestSettings();
		
	}*/
	
	
	public static void main (String args[]) throws Exception
	{
		mainExecutor m1 = new mainExecutor("s1");
		mainExecutor m2 = new mainExecutor("S1","S2");
		mainExecutor m3 = new mainExecutor("S1","S2","S3");
		
	
		
	/*	m1.main();
		//Step-2-DCBasicSuite-beforeTest

		DCBasicSuite Ds = new DCBasicSuite();
		Ds.beforeTest();
		TestSettings ts = new TestSettings();
		
	//	DCWebSession dw = new DCWebSession();
		//dw.getBrowser();
		
		LoginDCSuite dc1 = new LoginDCSuite();
		dc1.login1();
		
		m1.main("This is done");*/
}

	
}
