package test.ui.pages;

import main.sessions.BrowserSession;
import main.ui.pages.WebPage;
import test.ui.objects.TopMenu;

public class EncoreMainPage extends WebPage 
{
    public EncoreMainPage(BrowserSession session)
    {
        super(session, "Main Page");
        session.getBrowser().getDriver().switchTo().defaultContent();
        this.waitForPageLoading();
    }

    public TopMenu getTopMenu(){
        return new TopMenu(this);
    }
}