package Z3.threading;

public class extendThread extends Thread
{  
	
	public void run1()
	{  
		System.out.println("thread is running...2");  
	}  

	public void run()
	{  
		System.out.println("thread is running...1");  
	}
	
	
		
	public static void main(String args[])
	{  
		extendThread t1=new extendThread();  
			t1.start();
	 }  

}
