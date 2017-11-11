package com.utilites;

import com.utilites.LogStatuses;

public class StaticWait 
{
	public static void forMilliseconds(int milliseconds) 
	{
		try 
		{
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException e) 
		{
			Logger.write(LogStatuses.ERR, String.format("Error waiting '%1s' milliseconds", milliseconds), e);
		}
	}

	public static void forSeconds(int seconds) 
	{
		forMilliseconds(seconds * 1000);
	}	
}