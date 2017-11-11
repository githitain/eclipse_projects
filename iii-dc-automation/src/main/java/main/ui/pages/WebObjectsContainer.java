package main.ui.pages;

import main.ui.objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import main.config.TestSettings;
import main.exceptions.TestException;
import main.ui.finders.WebElementFinder;
import main.ui.finders.WebObjectFinder;
//import test.ui.objects.labelled.LabelledCombobox;
//import test.ui.objects.labelled.LabelledDateField;
//import test.ui.objects.labelled.LabelledObject;
//import test.ui.objects.labelled.LabelledWebEditField;
import main.utils.StringHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;


public abstract class WebObjectsContainer<T extends SearchContext> 
{

	private final WebObjectFinder<T> finder;
	private final WebDriver driver;
	private final WebObjectsContainer<?> parent;
	protected String friendlyName;

	protected WebObjectsContainer(WebDriver driver, WebObjectFinder<T> finder, String friendlyName) {
		this.driver = driver;
		this.finder = finder;
		this.parent = null;
		this.friendlyName = friendlyName;
	}

	protected WebObjectsContainer(WebObjectsContainer<?> parent, WebObjectFinder<T> finder, String friendlyName) {
		this.driver = parent.getWebDriver();
		this.finder = finder;
		this.parent = parent;
		this.friendlyName = friendlyName;
	}

	public WebObjectsContainer<?> getParent() {
		return parent;
	}

	public WebObjectFinder<T> getFinder() {
		return finder;
	}

	//TODO: make protected
	public T getNativeElement() {
		return finder.findObject();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public abstract WebPage getParentPage();

	public void setFriendlyName(String newName) {
		this.friendlyName = newName;
	}

	public String getFriendlyName() {
		return this.friendlyName;
	}

	public WebObject getChildWebObject(By findBy, String friendlyName) {
		return new WebObject(this, findBy, friendlyName);
	}

	public WebObject getChildHtmlStringWebObject() {
		return getChildWebObject(By.xpath(".//div[@class='htmlString']"), "Child Object with @class='htmlString'");
	}

	public WebObject getChildContainsHtmlStringWebObject() {
		return getChildWebObject(By.xpath(".//div[contains(@class, 'htmlString')]"), "Child Object with @class contains 'htmlString'");
	}

	protected WebButton getChildWebButton(By findBy, String friendlyName) {
		return new WebButton(this, findBy, friendlyName);
	}

	public WebEditField getChildWebEditField(By findBy, String friendlyName) {
		return new WebEditField(this, findBy, friendlyName);
	}

	protected WebImage getChildWebImage(By findBy, String friendlyName) {
		return new WebImage(this, findBy, friendlyName);
	}

	public WebButton getChildWebButtonByText(String exactText) {
		final String defaultButtonLocator = ".//div[contains(@class, 'SierraButton') or contains(@class, 'JButton')]";

		return new WebButton(WebObjectsContainer.this, new WebElementFinder() {

			@Override
			public WebElement findObject() {
				List<WebElement> buttons = WebObjectsContainer.this.getNativeElement().findElements(By.xpath(defaultButtonLocator));
				for (WebElement button : buttons) {
					if (StringHelper.normalizeSpaces(button.getText()).equals(exactText)) {
						return button.findElement(By.xpath(".//div[contains(@class, 'htmlString')]"));
					}
				}

				throw new TestException(exactText + " button hasn't been found");
			}
		}, exactText + " Button");
	}

	public WebObjectsCollection findChildren(By by) {
		return findChildren(by, TestSettings.Current.getWaitElementTimeout());
	}

	public WebObjectsCollection findChildren(By by, int searchTimeout) {
		getWebDriver().manage().timeouts().implicitlyWait(searchTimeout, TimeUnit.SECONDS);

		try {
			WebObjectsCollection objects = new WebObjectsCollection();

			for (WebElement element : this.getNativeElement().findElements(by)) {
				objects.add(new WebObject(this, new WebElementFinder() {

					@Override
					public WebElement findObject() {
						return element;
					}

				}, "Child of " + friendlyName));
			}

			return objects;
		}
		finally {
			getWebDriver().manage().timeouts().implicitlyWait(TestSettings.Current.getWaitElementTimeout(), TimeUnit.SECONDS);
		}
	}

	public WebObject getChildWebObjectByText(By locator, String exactText) {
		return getChildWebObjectByText(locator, null, exactText);
	}

	public WebObject getChildWebObjectByText(By locator, By innerObjectLocator, String exactText) {
		return getChildWebObjectByText(locator, innerObjectLocator, exactText, false);
	}

	public WebObject getChildWebObjectByText(By locator, By innerObjectLocator, String expectedObjectText, boolean useSubString) {

		return new WebObject(WebObjectsContainer.this, new WebElementFinder() {

			@Override
			public WebElement findObject() {
				List<WebElement> objects = WebObjectsContainer.this.getNativeElement().findElements(locator);
				for (WebElement object : objects) {
					if (StringHelper.normalizeSpaces(object.getText()).equals(expectedObjectText)) {
						return (innerObjectLocator == null) ? object : object.findElement(innerObjectLocator);
					}
				}

				if (useSubString) {
					//Try to find the object by substring
					for (WebElement object : objects) {
						if (StringHelper.normalizeSpaces(object.getText()).contains(expectedObjectText)) {
							return (innerObjectLocator == null) ? object : object.findElement(innerObjectLocator);
						}
					}
				}

				throw new TestException(expectedObjectText + " object hasn't been found");

			}
		}, expectedObjectText + " web object");
	}

	public WebEditField getInputFieldByLabel(String label) {
		String[] words = label.split(" ");
		String labelXpath = "//div[@class='htmlString'";
		for(String word : words) {
			labelXpath += String.format(" and contains(text(), '%s')", word);
		}
		labelXpath += "]";
		String xpath = labelXpath + "/ancestor::div[contains(@id, 'SWVarFieldEditorPanel')]//textarea";
		xpath += "|";
		xpath += labelXpath + "/ancestor::div[contains(@id, 'JPanel')][1]/div[contains(@id, 'SWAutoSelectTextField')]/input";
		return new WebEditField(getParentPage(), By.xpath(xpath), label + " field");
	}
}