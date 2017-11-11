package test.ui.popups;

import main.data.BibItem;
import main.data.ItemStatus;
import main.ui.objects.WebLink;
import main.ui.objects.WebObject;
import main.ui.pages.WebPage;
import main.utils.StringHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.ui.objects.EncoreWebCheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * The Items popup is appeared after clicking on 'see all' link from any search result. It shows all bib record locations.
 */
public class ItemsPopup extends WebObject {

    private static By popupLocator = By.cssSelector(".bibHoldingsWrapper[style*='display: block']");


    public ItemsPopup(WebPage page) {
        super(page, popupLocator, "Items Popup");
    }

    public WebLink getCloseLink() {
        return new WebLink(this, By.linkText("close"), "Close Link");
    }

    public List<WebElement> getAllRows() {
        By rowLocator = By.cssSelector("div[class$='ItemsSection'][style*='display: block'] tr:not(:first-child)");
        return this.getNativeElement().findElements(rowLocator);
    }

    public EncoreWebCheckBox getOnlyShowAvailableCheckbox() {
        return new EncoreWebCheckBox(this, By.cssSelector(".availCheckboxLink[style*='display: inline-block']"), "Only Show Available Checkbox");
    }

    public List<BibItem> getBibItems() {
        List<BibItem> bibItems = new ArrayList<>();

        for(WebElement row : getAllRows()){
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            BibItem bibItem = new BibItem();
            bibItem.setLocation(StringHelper.normalizeSpaces(cells.get(0).getText()));
            bibItem.setCallNo(StringHelper.normalizeSpaces(cells.get(1).getText()));
            String status = StringHelper.normalizeSpaces(cells.get(2).getText());
            bibItem.setStatus(ItemStatus.valueOf(status.replace(" ", "_")));
            bibItems.add(bibItem);
        }
        return bibItems;
    }
}