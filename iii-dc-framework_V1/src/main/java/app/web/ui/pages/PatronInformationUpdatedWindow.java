package app.web.ui.pages;

import org.openqa.selenium.By;

import com.sessions.BrowserSession;
import com.web.keywords.WebLink;
import com.web.ui.pages.WebPage;

public class PatronInformationUpdatedWindow extends WebPage 
{

    public PatronInformationUpdatedWindow(BrowserSession session) {
        super(session, "Patron Information Updated Window");
    }

    public WebLink getCloseWindowLink() {
        return new WebLink(this, By.linkText("Close Window"), "Close Window Text");
    }
}
