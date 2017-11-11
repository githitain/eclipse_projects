package app.sessions;

import com.sessions.BrowserSession;
import com.sessions.Project;

import app.web.ui.pages.*;

public class EncoreWebSession extends BrowserSession
{
    public EncoreWebSession()
    {
        super(Project.ENCORE);
    }

  /*  public void login(EncoreUserAccount user)
    {

    	getSearchPage().getTopMenu().getLoginLink().click();

        //LoginPage loginPage = getLoginPage();
        loginPage.getNameField().setText(user.getName());
        loginPage.getBarcodeField().setText(user.getBarcode());
        loginPage.getPINField().setText(user.getPin());
        loginPage.getSubmitButton().click();
        
    }*/

    @Override
    public void logout() throws Exception 
    {
        getSearchPage().getTopMenu().getLogoutLink().click();
        //getLogoutConfirmationPopup().getYesButton().click();
    }

    public EncoreMainPage getEncoreMainPage() throws Exception
    {
        return new EncoreMainPage(this);
    }

    public SearchPage getSearchPage() throws Exception
    {
        return new SearchPage(this);
    }

    public AdvancedSearchPage getAdvancedSearchPage(){
        return new AdvancedSearchPage(this);
    }


    public MyAccountPage getMyAccountPage() throws Exception{
        return new MyAccountPage(this);
    }

    public MyCartPage getMyCartPage() throws Exception{
        return new MyCartPage(this);
    }

    public RecordInfoPage getRecordInfoPage() throws Exception{
        return new RecordInfoPage(this);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(this);
    }

    /*public LogoutConfirmationPopup getLogoutConfirmationPopup() {
        return new LogoutConfirmationPopup(getEncoreMainPage());
    }*/

    public ModifyPatronInformationWindow getModifyPatronInformationWindow() {
        return new ModifyPatronInformationWindow(this);
    }

    public PatronInformationUpdatedWindow getPatronInformationUpdatedWindow() {
        return new PatronInformationUpdatedWindow(this);
    }
}