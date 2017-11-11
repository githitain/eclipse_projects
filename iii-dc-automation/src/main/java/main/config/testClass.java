package main.config;

import java.io.IOException;
import java.io.InputStream;

public class testClass 
{
	public static void main(String args[]) throws IOException
	{
		String propertyFile = ((propertyFile = System.getenv("PROPERTY_FILE")) != null) ?
				propertyFile : "test.properties";
				
				//InputStream input = getClass().getClassLoader().getResourceAsStream(propertyFile);
	}
}
