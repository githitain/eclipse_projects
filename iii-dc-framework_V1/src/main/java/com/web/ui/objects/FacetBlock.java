package com.web.ui.objects;

import org.openqa.selenium.By;

import com.web.keywords.WebImage;
import com.web.keywords.WebLink;
import com.web.keywords.WebObject;
import com.web.keywords.WebObjectsCollection;
import com.web.ui.pages.WebObjectsContainer;


public class FacetBlock extends WebObject{

    public FacetBlock(WebObjectsContainer<?> parent, String facetName) {
        super(parent, getFacetLocator(facetName), facetName + " FacetBlock");
    }

    public WebLink getLink(String linkName) {
        return new FacetWebLink(By.linkText(linkName), linkName);
    }

    private static By getFacetLocator(String facetName){
        return By.xpath(String.format(".//span[contains (text(), '%s')]//ancestor::div[@class = 'facetType']", facetName));
    }

    public String getTextByLink(String linkName){
        return new WebObject(this, By.xpath(String.format(".//p[contains(.,'%s') and contains(@id,'facetClassComponent')]", linkName)),
                linkName + " facet").getText();
    }

    public WebImage getExpandCollapseImg(){
        return new WebImage(this, By.xpath(".//img[contains(@id,'toggle1')]"), "Expand collapse image");
    }

    public WebObjectsCollection getFacetComponentList(){
        return this.findChildren(By.xpath(".//p"));
    }

    public WebObject getLoader() {
        return new WebObject(getParent(), By.cssSelector("span.loading"), "Loader");
    }

    public class FacetWebLink extends WebLink {
        FacetWebLink(By findBy, String linkName) {
            super(FacetBlock.this, findBy, linkName + " Link");
        }

        @Override
        public void click() {
            super.click();
            getLoader().isExist();
            getLoader().waitUntilDisappear();
        }
    }
}
