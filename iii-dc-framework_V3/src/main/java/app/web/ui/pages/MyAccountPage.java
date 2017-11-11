package app.web.ui.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.sessions.BrowserSession;
import com.utilites.StringHelper;
import com.web.keywords.WebButton;
import com.web.keywords.WebLink;
import com.web.keywords.WebObject;
import com.web.keywords.WebObjectFinder;
import com.web.keywords.WebObjectsCollection;
import com.web.ui.objects.EncoreWebCheckBox;
import com.web.ui.objects.WebSelect;
import com.web.ui.pages.WebFrame;
import com.web.ui.pages.WebObjectsContainer;

import app.web.ui.pages.EncoreMainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// This page contains frames, you should switch to iFrame before continue work
public class MyAccountPage extends EncoreMainPage {

    public MyAccountPage(BrowserSession session) throws Exception {
        super(session);
    }

    public String getUserName() {
        return new WebObject(this, By.cssSelector(".accountSummaryColumn>h2"), "Username Label").getText();
    }

    public String getHomeLibrary() {
        String homeLibrary = new WebObject(this, By.cssSelector(".accountSummaryColumn:nth-of-type(2)"), "Home Library Label").getText().replace("Home Library:", "");
        return StringHelper.removeNewLineCharacters(homeLibrary);
    }

    public String getEmail() {
        String email = new WebObject(this, By.cssSelector(".accountSummaryColumn:nth-of-type(3)"), "Email Label").getText().replace("Email:", "");
        return StringHelper.removeNewLineCharacters(email);
    }

    public WebButton getEditAccountButton() {
        return new WebButton(this, By.id("modInfoPopupWindowLinkComponent"), "Edit Account Button");
    }

  /*  private WebLink getEditPinLink() {
        return new WebLink(this, By.id("modPinPopupWindowLinkComponent"), "Edit Pin Link");
    }*/

    public WebLink getAccountFunctionMenu(String name){
        return new WebLink(this,
                By.xpath(String.format("//div[@class='accountFunctionsMenu']//a[contains(text(),'%s')]", name)),
                "Searched account function");
    }

    public AccountFrameWindow getAccountFrameWindow(){
        return new AccountFrameWindow(session, "AccountFrameWindow", "accountContentIframe");
    }

    public class AccountFrameWindow extends WebFrame{

        public AccountFrameWindow(BrowserSession page, String name, String searchForNameOrId) {
            super(page, name, searchForNameOrId);
        }

        public WebButton getCancelAllButton(){
            return new WebButton(this, By.className("buttonSpriteSpan2"),"Cancel all button");
        }

        public WebButton getUpdateListButton(){
            return new WebButton(this, By.name("requestUpdateHoldsSome"),"Update all button");
        }

        public WebButton getYesButton(){
            return new WebButton(this, By.xpath("//input[@name='cancelall']|//input[@name='updateholdssome']"),"Yes button");
        }

        public List<MyAccountHold> getAllHolds(){
            WebObjectsCollection collection = this.findChildren(By.xpath("//div[@class='patFuncArea']//tr[@class='patFuncEntry']"), 5);
            if(!collection.isEmpty()){
                return collection.stream().map(element-> new MyAccountHold(this,element.getFinder(),
                        "Another My account hold")).collect(Collectors.toList());
            }
            return new ArrayList<MyAccountHold>();
        }

        public MyAccountHold getHold(String containsText){
            Wait<?> waiter = new FluentWait<Object>(this)
                    .withTimeout(30, TimeUnit.SECONDS)
                    .pollingEvery(5000, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);
            waiter.until(page ->
            {
                this.getWebDriver().navigate().refresh();
                return getAccountFrameWindow().getAllHolds().stream().anyMatch(hold -> hold.getText().contains(containsText)) ? true : false;
            });
            return getAccountFrameWindow().getAllHolds().stream().filter(hold ->
                    hold.getText().contains(containsText)).findFirst().orElse(null);
        }
    }

    public class MyAccountHold extends WebObject{

        public MyAccountHold(WebObjectsContainer<?> parent, WebObjectFinder<WebElement> finder, String friendlyName) {
            super(parent, finder, friendlyName);
        }

        public WebLink getTitleLink(){
            return new WebLink(this, By.xpath(".//td[@class='patFuncTitle']//a"), "Title for record row");
        }

        public WebLink getRatingLink(){
            return new WebLink(this, By.xpath(".//td[@class='patFuncRating']//a"), "Rating for record row");
        }

        public WebObject getStatusLabel(){
            return new WebObject (this, By.xpath(".//td[@class='patFuncStatus']"), "Status for record row");
        }

        public WebSelect getLocationSelect(){
            return new WebSelect (this, By.xpath(".//td[@class='patFuncPickup']//select"), "Pickup location for record row");
        }

        public WebObject getCancelIfNotFilledLabel(){
            return new WebObject(this, By.xpath(".//td[@class='patFuncCancel']"), "Cancel date for record row");
        }

        public EncoreWebCheckBox getCancelCheckbox(){
            return new EncoreWebCheckBox(this, By.xpath(".//input[contains(@id,'cancel')]"), "Cancel checkbox");
        }

        public EncoreWebCheckBox getFreezeCheckbox(){
            return new EncoreWebCheckBox(this, By.xpath(".//input[contains(@id,'freeze')]"), "Freeze checkbox");
        }

    }

    public enum MyAccountMenuItems{
        Holds("Holds"),
        ReadingHistory ("Reading History"),
        PreferredSearches("Preferred Searches"),
        MyLists("My Lists"),
        Checkouts("Checkouts"),
        FinesAndFees("Fines/Fees"),
        ILL("ILL"),
        Messages("Messages"),
        Programs("Programs"),
        Bookings("Bookings"),
        ArticleReachRequests("ArticleReach Requests"),
        RSSFeed("RSS Feed"),
        LibraryEvents("Library Events"),
        MyEbooks("My EBooks"),
        MyResearchPro("My ResearchPro");

        private String value;
        private MyAccountMenuItems(String name){
            value=name;
        }

        @Override
        public String toString(){
            return value;
        }
    }
}

