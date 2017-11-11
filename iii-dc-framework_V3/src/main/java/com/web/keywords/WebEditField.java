package com.web.keywords;

import main.uii.UiAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilites.LogStatuses;
import com.utilites.Logger;
import com.web.ui.pages.WebObjectsContainer;

public class WebEditField extends WebObject {

	public WebEditField(WebObjectsContainer<?> parentObject, By findBy, String friendlyName) {
		super(parentObject, findBy, friendlyName);
	}

	public WebEditField(WebObjectsContainer<?> parentObject, WebObjectFinder<WebElement> finder, String friendlyName) {
		super(parentObject, finder, friendlyName);
	}
	
	public void setText(String text) {
		Logger.write(LogStatuses.INFO, String.format("Entering '%1s' text to '%2s'", text, friendlyName));

		sendKeys(text, true, true);
	}

	public void setText(String text, boolean clean) {
		Logger.write(LogStatuses.INFO, String.format("Entering '%1s' text to '%2s'", text, friendlyName));
		sendKeys(text, clean, true);
	}

	public void setText(String text, boolean clean, boolean clickOnElement) {
		Logger.write(LogStatuses.INFO, String.format("Entering '%1s' text to '%2s'", text, friendlyName));
		sendKeys(text, clean, clickOnElement);
	}

	protected void sendKeys(String text, boolean clean, boolean clickOnElement) {
		isExist(true);

		UiAction<Void> typeTextAction = new UiAction<Void>() {

			@Override
			public Void action() {
				if (clean) {
					getNativeElement().clear();
				}
				if (clickOnElement) {
					getNativeElement().click();
				}
				getNativeElement().sendKeys(text);
				try {
					getParentPage().waitForPageLoading(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		};
		
		typeTextAction.execute();
		try {
			getParentPage().waitForPageLoading(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValue() {
		return getNativeElement().getAttribute("value");
	}
}
