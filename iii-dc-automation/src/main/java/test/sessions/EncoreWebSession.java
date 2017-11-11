package test.sessions;

import main.sessions.BrowserSession;
import test.ui.pages.*;
import test.ui.pages.AdvancedSearchPage;
import test.ui.pages.RecordInfoPage;
import main.sessions.Project;
import test.data.EncoreUserAccount;
import test.ui.pages.LoginPage;
import test.ui.pages.MyAccountPage;
import test.ui.popups.LogoutConfirmationPopup;

public class EncoreWebSession extends BrowserSession
{
    public EncoreWebSession()
    {
        super(Project.ENCORE);
    }

    public void login(EncoreUserAccount user)
    {

    	getSearchPage().getTopMenu().getLoginLink().click();

        //LoginPage loginPage = getLoginPage();
        /*loginPage.getNameField().setText(user.getName());
        loginPage.getBarcodeField().setText(user.getBarcode());
        loginPage.getPINField().setText(user.getPin());
        loginPage.getSubmitButton().click();*/
        
    }

    @Override
    public void logout() 
    {
        getSearchPage().getTopMenu().getLogoutLink().click();
        getLogoutConfirmationPopup().getYesButton().click();
    }

    public EncoreMainPage getEncoreMainPage()
    {
        return new EncoreMainPage(this);
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
}