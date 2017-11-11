package test.ui.popups;
import main.ui.objects.WebButton;
import main.ui.objects.WebObject;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

public class LogoutConfirmationPopup extends WebObject{

    private static By popupLocator = By.cssSelector(".logoutDialog");

    public LogoutConfirmationPopup(WebPage page) {
        super(page, popupLocator, "Logout Confirmation Popup");
    }

    public WebButton getYesButton() {
        return new WebButton(this, By.id("logoutButtonComponent"), "Yes Button");
    }

    public WebButton getNoButton() {
        return new WebButton(this, By.id("cancelButtonComponent"), "No Button" );
    }

    public String getPopupText() {
        return new WebObject(this, By.cssSelector("h3"), "Popup Text").getText();
    }
}
