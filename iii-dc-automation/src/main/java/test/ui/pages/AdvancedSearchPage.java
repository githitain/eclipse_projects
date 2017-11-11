package test.ui.pages;

import main.sessions.BrowserSession;
import main.ui.objects.*;
import main.ui.pages.WebPage;
import org.openqa.selenium.By;
import test.ui.objects.AdvancedSearchObjects.AdvancedSearchEntity;
import test.ui.objects.WebSelect;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchPage extends WebPage{
    public AdvancedSearchPage(BrowserSession session) {
        super(session, "Advanced search page");
    }

    public WebObject getResultQuery(){
        return new WebObject(this, By.id("queryString"), "Result query string");
    }

    public WebLink getResetSearch(){
        return new WebLink(this, By.id("resetLinkSubmitComponent"), "Reset search link");
    }

    public WebButton getSearchButton(){
        return new WebButton (this, By.id("searchSubmit"), "Search button");
    }

    public List<WebSelect> getLocationSelects(){
        List<WebSelect> result = new ArrayList<WebSelect>();
        this.findChildren(By.xpath("//select[contains(@id,'limitValue')]")).forEach(itemFound -> result.add(
                new WebSelect(this, By.id(itemFound.getAttribute("id")), "Location select"))
        );
        return result;
    }

    public WebCheckBox getEBSCOCheckbox(String checkboxName){
        return new WebCheckBox(this,
                By.xpath(String.format("//div[@class='advanced-eds-option' and contains(.,'%s')]//input", checkboxName)),
                "EDS checkbox");
    }

    public WebObjectsCollection getRemoveLocationLink(){
        return this.findChildren(By.xpath("//a[contains(@id,'removeLimitLinkSubmitComponent')]"));
    }

    public WebButton getAddLocationButton(){
        return new WebButton(this, By.id("addLimitImageAnyComponent"), "Add location button");
    }

    public WebSelect getFirstFilter(){
        return new WebSelect(this, By.id("searchType_0"), "First filter select");
    }

    public WebEditField getFirstInput(){
        return new WebEditField(this, By.id("searchTerm_0"), "First filter select");
    }

    public WebObject getErrorField(){
        return new WebObject(this, By.className("error"), "Error field");
    }

    public void addAdvancedSearchBoolean(AdvancedSearchEntity.AdvancedSearchBoolean advSearchBool){
        this.findChildren(By.xpath(String.format("//div[@class='addQueryInput']//a[contains(text(),'%s')]",
                advSearchBool.toString()))).get(0).click();
    }

    public List<WebLink> getRemoveStatementLinks(){
        WebObjectsCollection filters = this.findChildren(By.xpath("//a[contains(@id,'removeRowLinkSubmitComponent')]"));
        List<WebLink> result = new ArrayList<WebLink>();
        filters.stream().forEach(filter-> result.add(new WebLink(this,
                By.id(filter.getAttribute("id")),"Advanced search filter")));
        return result;
    }

    public List<WebSelect> getFilters(){
        this.waitForPageLoading();
        WebObjectsCollection filters = this.findChildren(By.xpath("//select[contains(@id,'searchType')]"));
        List<WebSelect> result = new ArrayList<WebSelect>();
        filters.stream().forEach(filter-> result.add(new WebSelect(this,
                By.id(filter.getAttribute("id")),"Advanced search filter")));
        return result;
    }

    public List<WebEditField> getSearchInputs(){
        WebObjectsCollection filters = this.findChildren(By.xpath("//input[contains(@id,'searchTerm')]"));
        List<WebEditField> result = new ArrayList<WebEditField>();
        filters.stream().forEach(filter-> result.add(new WebEditField(this,
                By.id(filter.getAttribute("id")),"Advanced search filter")));
        return result;
    }
}

