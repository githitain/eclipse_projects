package test.ui.popups;

import main.ui.objects.WebButton;
import main.ui.objects.WebObject;
import main.ui.pages.WebObjectsContainer;
import org.openqa.selenium.By;

public class SearchErrorPopup extends WebObject 
{
    public SearchErrorPopup(WebObjectsContainer<?> parent, By by) {
        super(parent, by, "You must enter a value popup");
    }

    public String getErrorText(){
        return new WebObject(this,By.className("missingList"), "Error text").getText();
    }

    public WebButton getOkButton(){
        return new WebButton(this, By.id("alertOKButton"), "OK button");
    }

    //It's not a part of search error popup, but i don't think it should be in SearchPage
    public WebObject getOverlay(){
        return new WebObject(this.getParent(), By.xpath("//div[@class='dijitDialogUnderlayWrapper']"), "Error overlay");
    }

}
