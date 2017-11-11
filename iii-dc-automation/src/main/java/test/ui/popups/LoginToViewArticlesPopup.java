package test.ui.popups;

import main.ui.objects.WebButton;
import main.ui.objects.WebLink;
import main.ui.objects.WebObject;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

public class LoginToViewArticlesPopup extends WebObject {

    private static By popupLocator = By.id("articlesLoginAlert");

    public LoginToViewArticlesPopup(WebPage page) {
        super(page, popupLocator, "'Please log in to view articles' Popup");
    }

    public WebLink getLink() {
        return new WebLink(this, By.id("loginToSeeEDSLinkComponent"), "'Please log in to view articles' link");
    }

    public WebButton getCloseIcon() {
        return new WebButton(this, By.id("closeArticlesLoginAlert"), "Close (X) Icon");
    }
}
