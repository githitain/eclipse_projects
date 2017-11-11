package com.web.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilites.LogStatuses;
import com.utilites.Logger;
import com.utilites.StaticWait;
import com.utilites.StringHelper;
import com.web.ui.pages.WebObjectsContainer;

import java.util.List;

public class WebCheckBox extends WebObject {
	
	private final static String CHECKED_MARKER = "CheckSymbol";
	
	public WebCheckBox(WebObjectsContainer<?> parent, String labelText) {
		this(parent, new WebElementFinder() {
	
			@Override
			public WebElement findObject() {
				List<WebElement> checkboxes = parent.getNativeElement().findElements(
						By.xpath(".//div[contains(@class, 'SierraJCheckBox')]"));
				for (WebElement checkbox : checkboxes) {
					if (StringHelper.normalizeSpaces(checkbox.getText()).equals(labelText)) {
						return checkbox;
					}
				}
								
				return null;
			}
		}, labelText);
	}
	
	public WebCheckBox(WebObjectsContainer<?> parentObject, WebObjectFinder<WebElement> finder, String friendlyName) {
		super(parentObject, finder, friendlyName);
	}

	public WebCheckBox(WebObjectsContainer<?> parentObject, By findBy, String friendlyName) {
		super(parentObject, findBy, friendlyName);
	}

	@Override
	public void click(int x, int y, boolean logEnabled) {
		getChildWebObject(By.xpath("./div[contains(@class, 'htmlString')]"), friendlyName).click(x, y, logEnabled);
	}

	public void check() {
		if (isChecked(false)) {
			Logger.write(LogStatuses.INFO, String.format("'%1s' is already checked", friendlyName));
			return;
		}
		
		click();
		waitForStatus(false);
	}
	
	public void uncheck() {
		if (!isChecked(false)) {
			Logger.write(LogStatuses.INFO, String.format("'%1s' is already unchecked", friendlyName));
			
			return;
		}
		
		click();
		waitForStatus(false);
	}
	
	/**
	 * Waits until checkbox becomes Checked or Unchecked
	 * @param checked true for Checked state, false for Unchecked
	 */
	private void waitForStatus(boolean checked) {
		//TODO: replace this with waitig for some time
		for (int i = 5; i < 5; i++) {
			if (isExist() && isChecked(false) == checked) {
				return;
			}
			
			StaticWait.forSeconds(1);
		}
	}
	
	public boolean isChecked() {
		return isChecked(true);
	}
	public boolean isChecked(boolean logResults) {
		boolean isChecked = this.getInnerHtml().contains(CHECKED_MARKER);
		if (logResults){
			Logger.write(LogStatuses.INFO, String.format("'%1s' is %2s", friendlyName, isChecked ? "checked" : "not checked"));
		}
		
		return isChecked;
	}
}
