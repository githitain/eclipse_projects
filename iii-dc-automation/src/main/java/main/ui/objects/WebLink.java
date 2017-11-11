package main.ui.objects;

import main.ui.finders.WebObjectFinder;
import main.ui.pages.WebObjectsContainer;
import main.utils.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebLink extends WebObject {

    public WebLink(WebObjectsContainer<?> parent, WebObjectFinder<WebElement> finder, String friendlyName) {
        super(parent, finder, friendlyName);
    }

    public WebLink(WebObjectsContainer<?> parent, By findBy, String friendlyName) {
        super(parent, findBy, friendlyName);
    }

    public void click(int secondsToWait) {
        click();
        StaticWait.forSeconds(secondsToWait);
    }
}
