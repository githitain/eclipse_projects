package test.ui.objects;

import main.ui.finders.WebObjectFinder;
import main.ui.objects.WebButton;
import main.ui.objects.WebImage;
import main.ui.objects.WebLink;
import main.ui.objects.WebObject;
import main.ui.pages.WebObjectsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BibRecordObject extends WebObject {

    public BibRecordObject(WebObjectsContainer parent, WebObjectFinder<WebElement> finder, String friendlyName) {
        super(parent,finder,friendlyName);
    }

    public BibRecordObject(WebObjectsContainer parent, By findBy, String friendlyName) {
        super(parent,findBy,friendlyName);
    }

    public WebLink getTitleLink(){
        return new WebLink(this, By.cssSelector(".title>a"),"Title Link");
    }

    public WebLink getAuthorLink(){
        return new WebLink(this,  By.xpath(".//a[contains(@id,'authorDisplayLinkComponent')]"),"Author label");
    }

    public WebObject getInfoLabel(){
        return new WebObject(this,By.className("availabilityMessage"),"Location and call number");
    }

    public WebObject getDateLabel(){
        return new WebObject(this,By.xpath(".//span[contains(@id,'searchResultPubYearInsertComponent')]"),"Publish date");
    }

    public WebObject getType() {
        return new WebObject(this, By.cssSelector("[id^='mediaTypeInsertComponent']"), "Bib Record Type");
    }

    public WebLink getSeeAllLink() {
        return new WebLink(this, By.linkText("see all"), "See All Link");
    }

    public WebButton getRequestItButton(){
        return new WebButton(this, By.xpath(".//a[contains(@id,'directLink') or contains(@id,'genericLink')]"),"Request It button");
    }

    public WebButton getBookItButton(){
        return new WebButton(this, By.xpath(".//a[contains(@id,'webpacLink')]"),"'Book it' button");
    }

    public WebImage getAddToCartIcon() {
        return new WebImage(this, By.cssSelector("[id^=addToBookcartImageAnyComponent]"), "Add To Cart Icon");
    }
}
