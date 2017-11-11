package app.test.scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.file.handling.exlReader;
import com.file.handling.proReader;
import com.web.ui.objects.BibRecordObject;

import app.test.scenarios.testExtensions.DCBasicSuite;
import app.test.scenarios.testExtensions.EncoreBasicSuite;
import app.web.ui.pages.LoginPage;

public class LoginDCSuite extends DCBasicSuite 
{
	/*DCBasicSuite db = new DCBasicSuite();
	 
	beforeTest();*/
	
/*	public void login1() throws Exception
    {

        getSession().getDCLoginPage().DClogin();
        getSession().getDCLoginPage().DClogout();
        


        String username = getSession().getSearchPage().getTopMenu().getMyAccountLink().getText();
        Assert.assertEquals(username, EncoreUserAccounts.Default.getName(), "The username is incorrect");
    }
    
*/    proReader pr = new proReader();
			//System.out.println("constrcutor for proReader has been load");

			exlReader el = new exlReader();
			
			///System.out.println("constrcutor for exlReader has been load");
		 


	 @Test(groups = {"smoke", "test"})
	    public void login1() throws Exception
	    {
		 
		 System.out.println("Step-1-LoginDCSuite-login1");

	        getSession().getDCLoginPage().DClogin();
	        getSession().getDCLoginPage().DClogout();
	        
	    }
	 
	 	/*@Test(groups = {"smoke"})
	    public void loginWithEmptyFields()
	    {
	        getSession().getSearchPage().getTopMenu().getLoginLink().click();
	        getSession().getLoginPage().getSubmitButton().click();
	        String errorMessageText = getSession().getLoginPage().getErrorMessage().getText();

	        Assert.assertEquals(errorMessageText, LoginPage.EMPTY_LOGIN_ERROR, "Incorrect error message");
	    }
	 	
	 	@Test(groups = {"smoke"})
	    public void loginWithIncorrectName()
	    {
	        getSession().getSearchPage().getTopMenu().getLoginLink().click();

	        LoginPage loginPage = getSession().getLoginPage();
	        EncoreUserAccount user = EncoreUserAccounts.Default.getUser();
	        loginPage.getNameField().setText("Incorrect");
	        loginPage.getBarcodeField().setText(user.getBarcode());
	        loginPage.getPINField().setText(user.getPin());
	        loginPage.getSubmitButton().click();
	        String errorMessageText = getSession().getLoginPage().getErrorMessage().getText();
	        Assert.assertEquals(errorMessageText, LoginPage.INVALID_LOGIN_ERROR, "Incorrect error message");
	    }
	 	
	 	 @Test(groups = {"smoke"})
	     public void loginWithIncorrectBarcode(){
	         getSession().getSearchPage().getTopMenu().getLoginLink().click();

	         LoginPage loginPage = getSession().getLoginPage();
	         EncoreUserAccount user = EncoreUserAccounts.Default.getUser();
	         loginPage.getNameField().setText(user.getName());
	         loginPage.getBarcodeField().setText("11111");
	         loginPage.getPINField().setText(user.getPin());
	         loginPage.getSubmitButton().click();
	         String errorMessageText = getSession().getLoginPage().getErrorMessage().getText();
	         Assert.assertEquals(errorMessageText, LoginPage.INVALID_LOGIN_ERROR, "Incorrect error message");
	     }
	 	 
	 	@Test(groups = {"smoke"})
	    public void loginWithIncorrectPIN(){
	        getSession().getSearchPage().getTopMenu().getLoginLink().click();

	        LoginPage loginPage = getSession().getLoginPage();
	        EncoreUserAccount user = EncoreUserAccounts.Default.getUser();
	        loginPage.getNameField().setText(user.getName());
	        loginPage.getBarcodeField().setText(user.getBarcode());
	        loginPage.getPINField().setText("11111");
	        loginPage.getSubmitButton().click();
	        String errorMessageText = getSession().getLoginPage().getErrorMessage().getText();
	        Assert.assertEquals(errorMessageText, LoginPage.INVALID_LOGIN_ERROR, "Incorrect error message");
	    }
	 	
	 	 @Test(groups = {"smoke"})
	     public void logout(){
	         getSession().login(EncoreUserAccounts.Default.getUser());

	         getSession().getSearchPage().getTopMenu().getLogoutLink().click();
	         LogoutConfirmationPopup popup = getSession().getLogoutConfirmationPopup();

	         Assert.assertEquals(popup.getPopupText(), "Are you sure you want to log out?");
	         popup.getYesButton().click();

	         Assert.assertTrue(getSession().getSearchPage().getTopMenu().getLoginLink().isExist(), "Login link was now shown");
	     }
	 	 
	 	 @Test
	     public void cancelLogout() {
	         getSession().login(EncoreUserAccounts.Default.getUser());

	         getSession().getSearchPage().getTopMenu().getLogoutLink().click();
	         LogoutConfirmationPopup popup = getSession().getLogoutConfirmationPopup();

	         Assert.assertEquals(popup.getPopupText(), "Are you sure you want to log out?");
	         popup.getNoButton().click();

	         Assert.assertFalse(getSession().getSearchPage().getTopMenu().getLoginLink().isExist(0), "Login link is shown");

	         String username = getSession().getSearchPage().getTopMenu().getMyAccountLink().getText();
	         Assert.assertEquals(username, EncoreUserAccounts.Default.getName(), "The username is incorrect");
	     }
*/
	    
}


