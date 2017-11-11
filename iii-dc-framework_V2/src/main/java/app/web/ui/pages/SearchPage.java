package app.web.ui.pages;


//import main.ui.objects.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sessions.BrowserSession;
//import com.utilites.StaticWait;
import com.web.keywords.WebButton;
import com.web.keywords.WebEditField;
import com.web.keywords.WebLink;
import com.web.keywords.WebObject;
import com.web.keywords.WebObjectsCollection;
import com.web.ui.objects.BibRecordObject;
//import com.web.ui.objects.FacetBlock;

//import test.ui.popups.*;

import java.util.ArrayList;
import java.util.List;

//Todo THIS class should be separated in several classes: EDSSearchPage, SearchPageResults, etc.
public class SearchPage extends EncoreMainPage 
{

	    public SearchPage(BrowserSession session) {
	        super(session);
	        waitForPageLoading();
	        getLoader().waitUntilDisappear();
	    }
	
	    public WebEditField getSearchField() {
	        return new WebEditField(this, By.name("searchString"), "Search Field");
	    }
	
	    public String getTextOfTotalResults(){
	        return new WebObject(this, By.cssSelector(".browseHeader.customHeader"),"Total search results").getText();
	    }
	
	    public WebButton getSearchButton() {
	        return new WebButton(this, By.name("searchImageSumbitComponent"), "Search Button");
	    }
	
	    public WebObject getLoader() {
	        return new WebObject(this, By.cssSelector("span.loading"), "Loader");
	    }
	
	    public BibRecordObject getSearchResultsByTitle(String title) {
	        BibRecordObject result = getAllResults().stream().filter(element -> element.getText().contains(title)).findFirst().orElse(null);
	        if(result == null) {
	            return null;
	        }
	        return new BibRecordObject(getParentPage(),result.getFinder(),"Search results");
	    }
	
	    public List<BibRecordObject> getAllResults(){
	        By by = By.xpath("//div[contains(@id,'resultRecord')]");
	        List<WebElement> list = this.getNativeElement().findElements(by);
	        List<BibRecordObject> resultList = new ArrayList<>();
	        list.forEach(item -> resultList.add(new BibRecordObject(getParentPage(), By.id(item.getAttribute("id")),"One of search results")));
	        return resultList;
	    }
	
	    public WebObjectsCollection getEDSResults(){
	        return this.findChildren(By.xpath("//div[contains(@class,'searchResult')]"));
	    }
	
	    public WebLink getSortingLink(String sortingValue){
	        return new WebLink(this,
	                By.xpath(String.format("//span[@class='sortSelector']//span[contains(text(),'%s')]", sortingValue)), "Sorting by link");
	    }
	
	    public WebLink getAdvancedSearchLink(){
	        return new WebLink(this, By.id("advancedSearchLinkComponent"), "Advanced search link");
	    }
	
	/*    public void sortResultsBy(SortingValues sortingValue){
	        getLoginToViewArticlesPopup().getCloseIcon().clickIfExist();
	        StaticWait.forMilliseconds(500);
	        WebObject element = getSortingLink(sortingValue.toString());
	        element.clickIfExist(5);
	    }
	
	    public enum SortingValues {
	        Relevance,Date,Title
	    }
	
	    public RequestItPopup getRequestPopup(){
	        RequestItPopup popup = new RequestItPopup(this, By.id("popInContentWrapper"));
	        this.waitForLoadingDisappearsFromBodyClass();
	        return popup;
	    }
	
	    public RequestResultPopup getRequestResultPopup(){
	        return new RequestResultPopup (this, By.id("popInDialogUpdateAnyComponent"));
	    }
	
	    public LoginToViewArticlesPopup getLoginToViewArticlesPopup() {
	        return new LoginToViewArticlesPopup(this);
	    }
	
	    public CurrentRefinementsBlock getCurrentRefinementsBlock(){
	        getLoginToViewArticlesPopup().getCloseIcon().clickIfExist();
	        StaticWait.forMilliseconds(500);
	        return new CurrentRefinementsBlock(this);
	    }
	
	   
	
	    public ItemsPopup getItemsPopup() {
	        return new ItemsPopup(this);
	    }
	
	    public MorePopup getMorePopup(String popupName) {
	        return new MorePopup(this, popupName);
	    }
	
	    public SearchErrorPopup getSearchErrorPopup(){
	        return new SearchErrorPopup(this, By.id("validationDialog"));
	    }*/
	
	    public void selectContentCategories(ContentCategories category){
	        By xpath = By.xpath(String.format(".//span[contains(@id,'currentContentCategoryInsert') and text()='%s']", category));
	        this.findChildren(xpath).get(0).click();
	    }
	
	    public enum ContentCategories{
	        Catalog("Catalog"),CatalogPlus("Catalog Plus"),Images("Images"),Articles("Articles"),EDS("EDS");
	        private String name;
	        ContentCategories(String str){
	            name = str;
	        }
	
	        public String toString(){
	            return name;
	        }
	    }
}
