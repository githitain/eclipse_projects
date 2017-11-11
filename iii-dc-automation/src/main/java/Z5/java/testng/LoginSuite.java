package Z5.java.testng;

import org.testng.annotations.Test;

public class LoginSuite extends EncoreBasicSuite 
{

	@Test()
    public void login()
    {
		
		System.out.println("Step-1-Test- Under LoginSuite");

        /*getSession().login(EncoreUserAccounts.Default.getUser());

        String username = getSession().getSearchPage().getTopMenu().getMyAccountLink().getText();

        Assert.assertEquals(username, EncoreUserAccounts.Default.getName(), "The username is incorrect");*/
    }
}
