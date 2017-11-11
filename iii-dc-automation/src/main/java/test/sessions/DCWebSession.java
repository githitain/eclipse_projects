package test.sessions;

import org.openqa.selenium.By;

import main.sessions.BrowserSession;
import test.ui.pages.*;
import test.ui.pages.AdvancedSearchPage;
import test.ui.pages.RecordInfoPage;
import main.sessions.Project;
import main.sessions.WebSession;
import test.data.DCUserAccount;
import test.data.EncoreUserAccount;
import test.ui.pages.LoginPage;
import test.ui.pages.MyAccountPage;
import test.ui.popups.LogoutConfirmationPopup;

public class DCWebSession extends BrowserSession
{
    public DCWebSession()
    {
    	
        super(Project.DC);
        System.out.println("Step-4-DCWebSession-DCWebSession");
    }


    public EncoreMainPage getEncoreMainPage()
    {
        return new EncoreMainPage(this);
    }
    
    public DcMainPage getDcMainPage()
    {
        return new DcMainPage(this);
    }
    
    public DCLoginPage getDCLoginPage()
    {
        return new DCLoginPage(this);
    }

    public SearchPage getSearchPage()
    {
        return new SearchPage(this);
    }

    public AdvancedSearchPage getAdvancedSearchPage(){
        return new AdvancedSearchPage(this);
    }


    public MyAccountPage getMyAccountPage(){
        return new MyAccountPage(this);
    }

    public MyCartPage getMyCartPage(){
        return new MyCartPage(this);
    }

    public RecordInfoPage getRecordInfoPage(){
        return new RecordInfoPage(this);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(this);
    }

    public LogoutConfirmationPopup getLogoutConfirmationPopup() {
        return new LogoutConfirmationPopup(getEncoreMainPage());
    }

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