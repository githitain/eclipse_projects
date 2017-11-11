package com.dc.mainTest;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

class mainParllerThread  implements Runnable 
{
	   private Thread t;
	   private String fileName;
	   
	   mainParllerThread ( String fileName) 
	   {
	      this.fileName = fileName;
	      System.out.println("File name is " +  fileName );
	   }
	   
	   public void run() 
	   {
	      System.out.println("Running " +  fileName );
	      try 
	      {
 	  
	  		List<String> suites = Lists.newArrayList();
	  		TestNG testng = new TestNG();
	  		suites.add(this.fileName);//path to xml..
	  		testng.setTestSuites(suites);
	  		testng.run();
	  		Thread.sleep(10);
	      }
	      catch (InterruptedException e) 
	      {
	         System.out.println("File " +  fileName + " interrupted.");
	      }
	      System.out.println("Thread " +  fileName + " exiting.");
	   }
	   
	   public void start () 
	   {
	      System.out.println("Starting " +  fileName );
	      if (t == null) {
	         t = new Thread (this, fileName);
	         t.start ();
	      }
	   }
	

	   public static void main(String args[])
	   {
		   mainParllerThread R1 = new mainParllerThread("Resources/testng_Thread1.xml");
		  
	      R1.start();
	      
	      mainParllerThread R2 = new mainParllerThread("Resources/testng_Thread2.xml");
	      R2.start();
	   }
	   
}