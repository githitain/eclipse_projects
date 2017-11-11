package test.ui.pages;

import main.sessions.BrowserSession;
import main.ui.finders.WebObjectFinder;
import main.ui.objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecordInfoPage extends EncoreMainPage{

    public RecordInfoPage(BrowserSession session) {
        super(session);
    }

    public WebLink getBackToResultsLink(){
        return new WebLink(this,By.id("backToResultsLinkComponent"),"Back to results link");
    }

    public WebButton getRequestItButton(){
        return new WebButton(this,By.id("genericLink"),"Request button");
    }

    public WebButton getBookItButton(){
        return new WebButton(this, By.id("webpacLink"),"Book it button");
    }

    public WebCheckBox getOnlyShowAvailableCheckbox(){
        return new WebCheckBox(this, By.id("checkboxImageComponent"),"Only available items checkbox");
    }

    public List<WebObject> getAdditionalActions(){
        return this.findChildren(By.xpath("//div[@class='addtlActions']//ul"));
    }

    public List<String> getDetailByName(RecordInfoPage.DetailsValues name){
        List<String> tempResult = getDetailRows().stream().
                filter(element->element.getDetailName().getText().contains(name.toString())).
                map(element->element.getDetailValue().getText()).collect(Collectors.toList());
        List<String> result = new ArrayList<String>();
        for (String str: tempResult) {
            String[] arr = str.split("\n");
            result.addAll(Arrays.asList(arr));
        }
        return result.stream().map(str -> str.replaceAll("[.]$","")).collect(Collectors.toList());
    }

    public List<DetailRow> getDetailRows(){
        List<DetailRow> list = new ArrayList<DetailRow>();
        WebObjectsCollection objCollection = this.findChildren(By.xpath("//table[@id='bibInfoDetails']//tr"));
        objCollection.forEach(object -> list.add(new DetailRow(object.getFinder(),"Detail row for record info page")));
        return list;
    }

    public List<ItemsTable> getItemsRows(){
        List<ItemsTable> list = new ArrayList<ItemsTable>();
        //IE can't see class for some reason
        WebObjectsCollection objCollection = this.findChildren(By.xpath("//div[contains(@id,'allavailitems')]//table//tr[position()>1]"));
        objCollection.forEach(object->list.add(new ItemsTable(object.getFinder(),"Item row for record info page")));
        return list;
    }

    public MainInfoContainer getMainInfoContainer(){
        return new MainInfoContainer(By.className("dpBibTitle"));
    }

    public class DetailRow extends WebObject{

        DetailRow(WebObjectFinder<WebElement> finder, String name){
            super(RecordInfoPage.this, finder, name);
        }

        public WebObject getDetailName(){
            return new WebObject(DetailRow.this, By.xpath(".//td[@class='bibInfoLabel']"), "Detail name");
        }

        public WebObject getDetailValue(){
            return new WebObject(DetailRow.this, By.xpath(".//td[@class='bibInfoData']"), "Detail value");
        }
    }

    //todo Should be reworked to get value by column name
    public class ItemsTable extends WebObject{

        ItemsTable(WebObjectFinder<WebElement> finder, String name){
            super(RecordInfoPage.this, finder, name);
        }

        public WebObject getItemLocationLabel(){
            return new WebObject(ItemsTable.this, By.xpath("./td[1]"), "Location info");
        }

        public WebObject getItemCallNumberLabel(){
            return new WebObject(ItemsTable.this, By.xpath("./td[3]"), "Item call number info");
        }

        public WebObject getNoteLabel(){
            return new WebObject(ItemsTable.this, By.xpath("./td[4]"), "Note label");
        }

        public WebObject getStatusLabel(){
            return new WebObject(ItemsTable.this, By.xpath("./td[5]"), "Status label");
        }
    }

    public class MainInfoContainer extends WebObject{
        MainInfoContainer(By by){
            super(RecordInfoPage.this,by,"Main information container");
        }

        public WebObject getBibRecordTitle(){
            return new WebObject(this, By.id("bibTitle"), "Title of bib record");
        }

        public WebLink getAuthorLink(){
            return new WebLink(this, By.id("authorDisplayLinkComponent"), "Author link");
        }

        public WebObject getRecordDetailValue(){
            return new WebObject(this, By.id("recordDetailValue"), "Detail of bib record");
        }

        public WebObject getVaialabilitySummaryArea(){
            return new WebObject(this, By.id("availabilitySummaryArea"), "Summary of bib record");
        }
    }

    public enum DetailsValues{
        CallSharp("Call #"),
        PhysDescription("Phys. Description"),
        Note("Note"),
        Contents("Contents"),
        Summary("Summary"),
        Subject("Subject"),
        AltAuthor("Alt Author"),
        AltTitle("Alt Title"),
        ISBN("ISBN"),
        Performer("Performer"),
        Genre("Genre"),
        MusicSharp("Music #"),
        Series("Series");


        private String name;
        private DetailsValues(String valueName){
            name = valueName;
        }

        @Override
        public String toString(){
            return name;
        }
    }
}
