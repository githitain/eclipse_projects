package test.ui.popups;

import main.ui.objects.WebLink;
import main.ui.objects.WebObject;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

/**
 * The common class for all popups opened after clicking on "more" link from any facet. It allows to see all available selections.
 */
public class MorePopup extends WebObject {

    private static By popupLocator = By.id("moreOverlayPopup");

    public MorePopup(WebPage page, String name) {
        super(page, popupLocator, name + " Popup");
    }

    public WebLink getCloseLink() {
        return new WebLink(this, By.linkText("close"), "Close Link");
    }

    public WebLink getItemLink(String linkName) {
        return new WebLink(this, By.linkText(linkName), linkName + " Link");
    }

    public String getPopupName() {
        return new WebObject(this, By.cssSelector(".overlayHeader.sectionHeader"), "Popup Name").getText();
    }
}
