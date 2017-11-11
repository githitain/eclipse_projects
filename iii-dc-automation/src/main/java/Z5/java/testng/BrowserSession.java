package Z5.java.testng;

//public abstract class BrowserSession
public  class BrowserSession
{
	private Project project;
	
	public BrowserSession(Project project) 
	{
		this();
		this.project = project;
		
		System.out.println("Step-5-BrowserSession parametrized Constructor- Under BrowserSession" +  this.project);
		System.out.println("BrowserSession" + project);
	}

	public BrowserSession() 
	{
		project = Project.SIERRA;
		
		System.out.println("Step-6-BrowserSession default Constructor- Under BrowserSession" +  this.project);
		System.out.println("BrowserSession" + project);
	}
	
	public void navigate(String url)
	{
		System.out.println("Naviate");
		//Logger.write(LogStatuses.INFO, "Navigating " + url);
		//browser.getDriver().get(url);
	}
}
