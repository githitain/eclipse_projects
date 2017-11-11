package com.main;

//import org.testng.internal.MethodHelper;

/*import com.file.handling.exlReader;
import com.file.handling.proReader;*/

import com.setting.TestSettings;
//import com.test.suite.CommonSuite;

//import app.sessions.DCWebSession;
import app.test.scenarios.testExtensions.DCBasicSuite;

public class mainExecutor extends DCBasicSuite
{
	
	String s1="Launch mainExecutor called to open browser";
	String s2="ab";
	String s3="abs";
	
	
	
	public  mainExecutor()
	{
		System.out.println(s1);
		beforeMethod();
		beforeTest();
		TestSettings ts = new TestSettings();
		
	}
		
	public void get()
	{
		new mainExecutor();
	}
	
	public void closeDriver() throws Exception
	{
		webclose();
	}
	
	
	public static void main (String args[]) throws Exception
	{
		
	}

	
}
