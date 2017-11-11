package test.ui.pages;

import main.sessions.BrowserSession;
import main.ui.objects.WebButton;
import main.ui.objects.WebEditField;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

public class ModifyPatronInformationWindow extends WebPage{

    public ModifyPatronInformationWindow(BrowserSession session) {
        super(session, "Modify Patron Information Window");
    }

    public WebEditField getAliasNicknameField() {
        return new WebEditField(this, By.id("user_name"), "Alias/Nickname Field");
    }

    public WebEditField getAddressField() {
        return new WebEditField(this, By.name("addr1a"), "Address Field");
    }

    public WebEditField getCityField() {
        return new WebEditField(this, By.name("addr1b"), "City Field");
    }

    public WebEditField getStateField() {
        return new WebEditField(this, By.name("addr1c"), "State Field");
    }

    public WebEditField getZipCodeField() {
        return new WebEditField(this, By.name("addr1d"), "ZIP Code Field");
    }

    public WebEditField getEmailAddressField() {
        return new WebEditField(this, By.id("email"), "Email Address Field");
    }

    public WebButton getSubmitButton() {
        return new WebButton(this, By.xpath("//span[text() = 'Submit']"), "Submit Button");
    }

    private WebButton getCancelButton() {
        return new WebButton(this, By.xpath("//span[text() = 'Cancel']"), "Cancel Button");
    }
}