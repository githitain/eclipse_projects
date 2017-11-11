package Z5.java.testng;

public class TestRunSuffix 
{
private static final ThreadLocal<Long> currentTestSuffix = new ThreadLocal<>();
	
	public static synchronized Long getCurrentTestSuffix()
	{
		System.out.println("getCurrentTestSuffix under TestRunSuffix");
		if (currentTestSuffix.get() == null)
		{
			setCurrent(RandomGenerator.getRandomNumber(10001, 99999));
		}
		
		return currentTestSuffix.get();
	}
	private static void setCurrent(Long value)
	{
		
		currentTestSuffix.set(value);
		System.out.println("setCurrent under TestRunSuffix");
	}
	
	public static synchronized void refresh()
	{
		
		setCurrent(null);
		System.out.println("refresh under TestRunSuffix");

		
	}
}
