package app.web.ui.pages;

import com.sessions.BrowserSession;
import com.web.ui.objects.TopMenu;
import com.web.ui.pages.WebPage;

public class EncoreMainPage extends WebPage 
{
    public EncoreMainPage(BrowserSession session) throws Exception
    {
        super(session, "Main Page");
        session.getBrowser().getDriver().switchTo().defaultContent();
        this.waitForPageLoading();
    }

    public TopMenu getTopMenu(){
        return new TopMenu(this);
    }
}