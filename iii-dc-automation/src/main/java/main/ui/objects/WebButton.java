package main.ui.objects;

import org.openqa.selenium.By;
import main.ui.finders.WebElementFinder;
import main.ui.pages.WebObjectsContainer;

public class WebButton extends WebObject 
{

	public WebButton(WebObjectsContainer<?> parentObject, By findBy, String friendlyName) {
		super(parentObject, findBy, friendlyName);
	}

	public WebButton(WebObjectsContainer<?> parentObject, WebElementFinder finder, String friendlyName) {
		super(parentObject, finder, friendlyName);
	}

	public boolean isEnabled() {
		return getNativeElement().findElement(By.xpath("./parent::div[contains(@id, 'SierraButton')]" +
				"|./parent::div[contains(@id, 'NavigableButton')]")).getAttribute("class").contains("enabled");
	}
}
