package test.ui.pages;

import org.testng.annotations.Test;

import main.sessions.BrowserSession;
import main.sessions.WebSession;
import main.ui.pages.WebPage;

public class DCLoginPage extends WebPage 
{
	
	public DCLoginPage(BrowserSession session) 
	{
        super(session, "DCLoginPage");
    }
	
	
	@Test 
	public void DClogin()
	 {
		 System.out.println("dc Login is started");
/*		 session.sendKeys("DC", "username_inputbox", "dc", "username");
		 session.sendKeys("DC", "password_inputbox", "dc", "password");
		 session.performClick("DC", "submit_btn");*/
		 
		 //session.sendKeys("DC", "username_inputbox", "dc", "username");
	  }

	 public void DClogout() 
	    {
		 
		 session.performClick("DC", "signOut_link");
		 //signOut_link

	    }
}
