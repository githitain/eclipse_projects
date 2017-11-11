/*package com.web.ui.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.web.keywords.WebLink;
import com.web.keywords.WebObjectFinder;
import com.web.ui.pages.WebObjectsContainer;
import com.web.ui.pages.WebPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

*//**
 * The class contains all methods to interact with Encore Top Menu, e.g. My Cart or Language links
 *//*
public class TopMenu extends WebObjectsContainer<SearchContext>{

    private final WebObjectsContainer<?> parentObject;

    public TopMenu(WebObjectsContainer<?> parent) 
    {
        super(parent, new WebObjectFinder<SearchContext>() {
            @Override
            public SearchContext findObject() {
                return parent.getNativeElement();
            }
        }, "Top Menu");
        parentObject = parent;
    }

    @Override
    public WebPage getParentPage() {
        return parentObject.getParentPage();
    }

    public MyCartWebLink getMyCartLink() {
        return new MyCartWebLink(this, By.id("bookCartLinkComponent_0"), "My Cart Link");
    }

    public WebLink getLoginLink() {
        return new WebLink(this, By.id("userLoginLinkComponent"), "Login Link");
    }

    public WebLink getMyAccountLink() {
        return new WebLink(this, By.id("patronAccountExternalLinkComponent_0"), "My Account Link");
    }

    public WebLink getLogoutLink() {
        return new WebLink(this, By.id("patronLogoutLinkComponent"), "Logout Link");
    }

    public class MyCartWebLink extends WebLink {
        public MyCartWebLink(WebObjectsContainer<?> parent, WebObjectFinder<WebElement> finder, String friendlyName) {
            super(parent, finder, friendlyName);
        }

        MyCartWebLink(WebObjectsContainer<?> parent, By findBy, String friendlyName) {
            super(parent, findBy, friendlyName);
        }

        public String getItemsCount(){
            String linkText = getText();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(linkText);
            m.find();
            return m.group(0);
        }
    }
}
*/