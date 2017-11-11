package Z3.threading;

public class implementRunnable implements Runnable
{  
		public void run()
		{  
				System.out.println("thread is running...");  
		}  
		  
		public static void main(String args[])
		{  
			implementRunnable m1=new implementRunnable();  
			Thread t1 =new Thread(m1);  
			t1.start();  
		 }  
}  


