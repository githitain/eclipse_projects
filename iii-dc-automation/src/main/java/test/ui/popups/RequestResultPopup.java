package test.ui.popups;

import main.ui.objects.WebButton;
import main.ui.objects.WebObject;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;

public class RequestResultPopup extends WebObject{
    public RequestResultPopup(WebPage page, By locator){
        super(page, locator, "Request result popup");
    }

    public String getSuccessFeedbackText(){
        return new WebObject(this, By.xpath(".//div[contains(@class,'feedbackMessage')]"),"Success message").getText();
    }

    public WebButton getOkButton(){
        return new WebButton(this, By.xpath(".//a[contains(@class,'primaryAction cancel')]"), "Ok button");
    }
}


