package app.sessions;

//import org.openqa.selenium.By;

import com.sessions.BrowserSession;
import com.sessions.Project;


import app.web.ui.pages.*;

public class DCWebSession extends BrowserSession
{
    public DCWebSession()
    {
    	
        super(Project.DC);
        System.out.println("Step-4-DCWebSession-DCWebSession");
    }


   
    
    public DcMainPage getDcMainPage() throws Exception
    {
        return new DcMainPage(this);
    }
    
    public DCLoginPage getDCLoginPage()
    {
        System.out.println("Step-9-DCWebSession-DCLoginPage");
        
        return new DCLoginPage(this);
    }

   

    public LoginPage getLoginPage() {
        return new LoginPage(this);
    }

  /*  public LogoutConfirmationPopup getLogoutConfirmationPopup() {
        return new LogoutConfirmationPopup(getEncoreMainPage());
    }*/

    public ModifyPatronInformationWindow getModifyPatronInformationWindow() {
        return new ModifyPatronInformationWindow(this);
    }

    public PatronInformationUpdatedWindow getPatronInformationUpdatedWindow() {
        return new PatronInformationUpdatedWindow(this);
    }

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
}