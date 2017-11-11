package test.ui.pages;

import main.sessions.BrowserSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.ui.objects.BibRecordObject;
import java.util.ArrayList;
import java.util.List;

public class MyCartPage extends EncoreMainPage{

    public MyCartPage(BrowserSession session) {
        super(session);
    }

    public List<BibRecordObject> getAllBibRecords(){
        this.waitForPageLoading();
        By by = By.xpath("//div[contains(@id,'resultRecord')]");
        List<WebElement> list = this.getNativeElement().findElements(by);
        List<BibRecordObject> bibRecords = new ArrayList<>();
        list.forEach(item -> bibRecords.add(new BibRecordObject(this, By.id(item.getAttribute("id")),"One of the bib records from My Cart")));
        return bibRecords;
    }

    public BibRecordObject getBibRecordTitle(String title) {
        BibRecordObject result = getAllBibRecords().stream().filter(element -> element.getText().contains(title)).findFirst().orElse(null);
        if(result == null) {
            return null;
        }
        return new BibRecordObject(getParentPage(),result.getFinder(),"Search results");
    }
}
