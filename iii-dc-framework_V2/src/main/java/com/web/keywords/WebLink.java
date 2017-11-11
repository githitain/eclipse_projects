package com.web.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilites.StaticWait;
import com.web.ui.pages.WebObjectsContainer;

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
