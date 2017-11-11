package app.web.ui.pages;

import com.sessions.BrowserSession;
//import com.web.ui.objects.TopMenu;
import com.web.ui.pages.WebPage;

public class DcMainPage extends WebPage
{
    public DcMainPage(BrowserSession session)
    {
        super(session, "Main Page");
        session.getBrowser().getDriver().switchTo().defaultContent();
        this.waitForPageLoading();
    }

    /*public TopMenu getTopMenu(){
        return new TopMenu(this);
    }*/
}
