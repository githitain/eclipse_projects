package test.ui.objects.AdvancedSearchObjects;

import main.ui.objects.WebLink;
import main.ui.objects.WebObject;
import main.ui.pages.WebObjectsContainer;
import org.openqa.selenium.By;

public class CurrentRefinementsBlock extends WebObject
{

    public CurrentRefinementsBlock(WebObjectsContainer<?> parent) 
    {
        super(parent, By.id("currentRefinementWrapper"), "Current refinements block");
    }

    public WebLink getClearAllLink() 
    {
        return new WebLink(this, By.id("returnToBrowseResultsLinkComponent"), "Clear all Link");
    }

    public WebLink getXOfFacet(String facetName){
        return new WebLink(this, By.xpath(
                String.format(".//div[contains(@id,'selectedRefinementIdComponent') and contains(.,'%s')]//img", facetName)),
                facetName + " facet remove link");
    }
}
