package test.ui.pages;

import main.sessions.BrowserSession;
import main.ui.objects.WebLink;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

public class PatronInformationUpdatedWindow extends WebPage 
{

    public PatronInformationUpdatedWindow(BrowserSession session) {
        super(session, "Patron Information Updated Window");
    }

    public WebLink getCloseWindowLink() {
        return new WebLink(this, By.linkText("Close Window"), "Close Window Text");
    }
}
