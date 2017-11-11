package com.file.handling;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class proReader 
{
	
	private static Properties configProps =new Properties();
	public static Map<String, String> messages = new HashMap<String, String>();
	


	public proReader()
	 {
		 try 
		 {
			System.out.println("Loading_Property constrcutor-1");
			loadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 

		public  void loadProperties() throws IOException
		{
			FileInputStream in = null;
			
			try
			{
				
			//FileInputStream in = new FileInputStream("src//main//java//Resources//Configuration.txt");
			 in = new FileInputStream("Resources//Configuration.txt");
			configProps.load(in);
			}catch(Exception e)
			{
				System.out.println("Please provide testData.properties" + in);
				e.printStackTrace();
			}
			
			
			System.out.println("Config is loaded successfully" + in);
			///////////////////////////////////////////////////
			Set s = new HashSet(configProps.keySet());
			
			 Iterator itr=s.iterator();
			 
			 while(itr.hasNext())
			 {
				 String key = (String)itr.next();  
				  
		         messages.put(key, configProps.getProperty(key));
		         
			 }
			
		}
		
		public static  long getInteger(String param) throws Exception 
		{
			String str = null;
			
			try
			{
				 str=messages.get(param);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println(str);
			return Long.parseLong(str);
		}
		
		
		public static  String getString(String param) throws Exception 
		{
			String str = null;
			
			try
			{
				 str=messages.get(param);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println(str);
			return str;
		}
		
	
		/*public static void main (String args []) throws Exception
		{
			load_Property ob=new load_Property();
			String str=messages.get("@vi");
			String str1=messages.get("@v2");
			String str2=messages.get("@v3");
			String str3=messages.get("@vii");
			
			//getTime("time");
			//getBrowser("browser");
			System.out.println(str);
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3);
		}*/
		
}


