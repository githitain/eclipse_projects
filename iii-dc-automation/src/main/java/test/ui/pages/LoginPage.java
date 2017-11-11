package test.ui.pages;


import main.sessions.BrowserSession;
import main.ui.objects.WebButton;
import main.ui.objects.WebEditField;
import main.ui.objects.WebLink;
import main.ui.objects.WebObject;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

public class LoginPage extends WebPage 
{

    public static final String EMPTY_LOGIN_ERROR = "An internal error has occurred. Please contact the library staff for further assistance.";
    public static final String INVALID_LOGIN_ERROR = "Sorry, the information you submitted was invalid. Please try again.";

    public LoginPage(BrowserSession session) {
        super(session, "Login Page");
    }

    public WebEditField getUsernameField() {
        return new WebEditField(this, By.id("extpatid"), "Username Field");
    }

    public WebEditField getPasswordField() {
        return new WebEditField(this, By.id("extpatpw"), "Password Field");
    }

    public WebEditField getNameField() {
        return new WebEditField(this, By.id("name"), "Name Field");
    }

    public WebEditField getBarcodeField() {
        return new WebEditField(this, By.id("code"), "Barcode Field");
    }

    public WebEditField getYourLoginField() {
        return new WebEditField(this, By.id("user_name"), "Your Login/User Name Field");
    }

    public WebEditField getPINField() {
        return new WebEditField(this, By.id("pin"), "PIN Field");
    }

    public WebButton getSubmitButton() {
        return new WebButton(this, By.cssSelector(".buttonSpriteSpan2"), "Submit Button");
    }

    public WebLink getCreateAnAccountLink() {
        return new WebLink(this, By.linkText("Create an account"), "Create An Account Link");
    }

    public WebLink getForgetYourPINLink() {
        return new WebLink(this, By.linkText("Forget Your PIN?"), "Forget Your PIN Link");
    }

    public WebLink getHomeLink() {
        return new WebLink(this, By.linkText("Home"), "Home Link");
    }

    public WebObject getErrorMessage() {
        return new WebObject(this, By.id("status"), "Error Message");
    }
}
