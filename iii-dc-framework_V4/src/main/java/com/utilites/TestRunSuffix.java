package com.utilites;

public class TestRunSuffix {
	
	private static final ThreadLocal<Long> currentTestSuffix = new ThreadLocal<>();
	
	public static synchronized Long getCurrentTestSuffix()
	{
		System.out.println("Step-6-TestRunSuffix-getCurrentTestSuffix");
		if (currentTestSuffix.get() == null)
		{
			setCurrent(RandomGenerator.getRandomNumber(10001, 99999));
		}
		
		return currentTestSuffix.get();
	}
	
	private static void setCurrent(Long value)
	{
		currentTestSuffix.set(value);
	}
	
	public static synchronized void refresh()
	{
		setCurrent(null);
	}
}
