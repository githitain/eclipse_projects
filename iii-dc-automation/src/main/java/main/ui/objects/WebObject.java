package main.ui.objects;

import main.sessions.Project;
import main.uii.UiAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import main.config.TestSettings;
import main.exceptions.TestException;
import main.ui.finders.WebObjectFinder;
import main.ui.pages.WebObjectsContainer;
import main.ui.pages.WebPage;
import main.utils.LogStatuses;
import main.utils.Logger;
import main.utils.StringHelper;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WebObject extends WebObjectsContainer<WebElement> implements BaseWebObject 
{

	public static final String HTML_STRING_DIV_WITH_TEXT_LOCATOR_TEMPLATE =
			"/div[contains(@class, 'htmlString') and text()[contains(normalize-space(translate(.., '" + Character.toString((char)160) + "', ' ')), normalize-space('%1$s'))]]";

	public static final String HTML_STRING_DIV_WITH_EXACT_TEXT_LOCATOR_TEMPLATE =
			"/div[contains(@class, 'htmlString') and text()[normalize-space(translate(.., '" + Character.toString((char)160) + "', ' '))=normalize-space('%1$s')]]";

	public static final String HTML_STRING_DIV_WITHOUT_TEXT_LOCATOR_TEMPLATE =
			"/div[contains(@class, 'htmlString')]";

	public static final String HTML_STRING_DIV_PLACEHOLDER = "{HTML_STRING_DIV}";

	private final WebPage page;

	@Override
	public WebPage getParentPage() {
		return page;
	}

	public WebObject(WebObjectsContainer<?> parent, WebObjectFinder<WebElement> finder, String friendlyName) {
		super(parent, finder, friendlyName);
		this.page = parent.getParentPage();
	}

	public WebObject(WebObjectsContainer<?> parent, By findBy, String friendlyName) {
		this(parent, new WebObjectFinder<WebElement>() {

			@Override
			public WebElement findObject() {
				try {
					return parent.getNativeElement().findElement(findBy);
				} catch (NoSuchElementException e) {
					if (TestSettings.getLogExceptions()) {
//						Logger.write(LogStatuses.DEBUG, String.format(
//								"NoSuchElementException exception when searching '%1s' object", friendlyName), e);
						Logger.write(LogStatuses.DEBUG, String.format(
								"NoSuchElementException exception when searching '%1s' object", friendlyName));
						parent.getParentPage().takeScreenshot();
					}
					return null;
				} catch (Exception e) {
					if (TestSettings.getLogExceptions()) {
//						Logger.write(LogStatuses.DEBUG,
//								String.format("Unexpected exception when searching '%1s' object", friendlyName), e);

						Logger.write(LogStatuses.DEBUG,
								String.format("Unexpected exception when searching '%1s' object", friendlyName));

						parent.getParentPage().takeScreenshot();
					}
					return null;
				}
			}
		}, friendlyName);
	}

	@Override
	public boolean isExist() {
		return isExist(TestSettings.Current.getWaitElementTimeout(), false);
	}

	@Override
	public boolean isExist(boolean throwIfNotExist) {
		return isExist(TestSettings.Current.getWaitElementTimeout(), throwIfNotExist);

	}

	@Override
	public boolean isExist(int waitTimeout) {
		return isExist(waitTimeout, false);
	}

	@Override
	public boolean isExist(int waitTimeout, boolean throwIfNotExist) {
		final int attemptsCount = 2;

		boolean logExceptionsStatus = TestSettings.getLogExceptions();
		if (!throwIfNotExist) {
			TestSettings.setLogExceptions(false);
		}

		int timeoutForAttempt = Math.round(waitTimeout/attemptsCount);

		getWebDriver().manage().timeouts().implicitlyWait(timeoutForAttempt, TimeUnit.SECONDS);

		UiAction<Boolean> isExistAction = new UiAction<Boolean>(2, 10, 1, false) {
			@Override
			public Boolean action() {
				return getNativeElement() != null;
			}
		};

		try {
			Date now = new Date();
			do {
				if (isExistAction.execute()) {
					return true;
				}
			} while((new Date().getTime() - now.getTime()) < waitTimeout * 1000);

			return false;

		} catch (Exception e) {
			if (throwIfNotExist) {
				throw new TestException(String.format("Element '%1s' does not exist after %2s seconds waiting",
						friendlyName, waitTimeout), e);
			}

			Logger.write(LogStatuses.DEBUG, "Exception appears: ", e);
			return false;
		} finally {
			TestSettings.setLogExceptions(logExceptionsStatus);
			getWebDriver().manage().timeouts().implicitlyWait(TestSettings.Current.getWaitElementTimeout(),
					TimeUnit.SECONDS);
		}
	}

	@Override
	public boolean waitUntilDisappear() {
		return waitUntilDisappear(true);
	}

	@Override
	public boolean waitUntilDisappear(boolean throwIfNotDisappear) {
		return waitUntilDisappear(TestSettings.Current.getWaitElementTimeout(), throwIfNotDisappear);
	}

	@Override
	public boolean waitUntilDisappear(int timeout, boolean throwIfNotDisappear) {

		Date now = new Date();
		while((new Date().getTime() - now.getTime()) < timeout * 1000) {
			if (!isExist(0)) {
				this.getParentPage().waitForPageLoading();
				return true;
			}
		}

		if (throwIfNotDisappear) {
			throw new TestException(friendlyName + " object has not been disappeared");
		}

		return false;
	}

	@Override
	public void clickIfExist() {
		clickIfExist(TestSettings.Current.getWaitElementTimeout());
	}

	@Override
	public void clickIfExist(int timeout) {
		if (isExist(timeout)) {
			click();
		} else {
			Logger.write(LogStatuses.INFO,
					String.format("Element '%1s' is not exist and will not be clicked", friendlyName));
		}
	}

	@Override
	public void click() {
		if(page.getSession().getProject().equals(Project.ENCORE)) {
			nativeClick();
		} else {
			click(true);
		}
	}

	@Override
	public void click(boolean logEnabled) {
		click(0, 0, logEnabled);
	}

	@Override
	public void click(boolean logEnabled, boolean waitForPageLoading) {
		click(0, 0, logEnabled, waitForPageLoading);
	}

	@Override
	public void click(int x, int y) {
		click(x, y, true);
	}

	@Override
	public void click(int x, int y, boolean logEnabled) {
		click(x, y, logEnabled, true);
	}

	@Override
	public void click(int x, int y, boolean logEnabled, boolean waitForPageLoading) {
		if (logEnabled) {
			Logger.write(LogStatuses.INFO, String.format("Clicking '%1s'", friendlyName));
		}

		isExist(true);

		UiAction<Void> clickAction = new UiAction<Void>() {
			@Override
			public Void action() {
				Actions actions = new Actions(getWebDriver());
				if (x == 0 & y == 0) {
					actions.moveToElement(getNativeElement()).click().build().perform();
				} else {
					actions.moveToElement(getNativeElement(), x, y).click().build().perform();
				}

				return null;
			}
		};

		clickAction.execute();
		if (waitForPageLoading) {
			getParentPage().waitForPageLoading(500);
		}
	}

	public void nativeClick() {
		Logger.write(LogStatuses.INFO, String.format("Clicking '%1s'", friendlyName));
		isExist(true);
		getNativeElement().click();
	}

	@Override
	public void rightClick() {
		Logger.write(LogStatuses.INFO, String.format("Opening context menu (by performing right mouse click) for '%1s'", friendlyName));

		isExist(true);

		UiAction<Void> clickAction = new UiAction<Void>() {
			@Override
			public Void action() {
				Actions actions = new Actions(getWebDriver());
				actions.moveToElement(getNativeElement()).contextClick().perform();
				return null;
			}
		};

		clickAction.execute();
		getParentPage().waitForPageLoading(500);
	}

	@Override
	public void doubleClick() {
		doubleClick(true);
	}

	@Override
	public void doubleClick(boolean logEnabled) {
		doubleClick(0, 0, logEnabled);
	}

	@Override
	public void doubleClick(int x, int y) {
		doubleClick(x, y, true);
	}

	private void doubleClick(int x, int y, boolean logEnabled) {
		if (logEnabled) {
			Logger.write(LogStatuses.INFO, String.format("Double-clicking '%1s'", friendlyName));
		}

		isExist(true);

		UiAction<Void> doubleClickAction = new UiAction<Void>() {
			@Override
			public Void action() {
				Actions actions = new Actions(getWebDriver());
				if (x == 0 & y == 0) {
					actions.moveToElement(getNativeElement()).doubleClick().perform();
				} else {
					actions.moveToElement(getNativeElement(), x, y).doubleClick().build().perform();
				}

				return null;
			}
		};

		doubleClickAction.execute();
		getParentPage().waitForPageLoading(500);
	}

	@Override
	public void dragAndDropTo(WebObject targetObject) {
		UiAction<Void> dragAndDropToAction = new UiAction<Void>() {
			@Override
			public Void action() {
				Actions operation = new Actions(WebObject.this.getWebDriver());
				operation.dragAndDrop(WebObject.this.getNativeElement(), targetObject.getNativeElement()).perform();
				return null;
			}
		};

		dragAndDropToAction.execute();
		getParentPage().waitForPageLoading();
	}

	public void scrollToElementVertically() {
		int y = getNativeElement().getLocation().getY();
		((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, arguments[0]);", y);
	}

	@Override
	public String getText() {
		return getText(true);
	}

	@Override
	public String getText(boolean normalizeSpaces) {
		return getText(normalizeSpaces, true);
	}

	@Override
	public String getText(boolean normalizeSpaces, boolean printText) {
		isExist(true);

		UiAction<String> getTextAction = new UiAction<String>() {

			@Override
			public String action() {
				if (getNativeElement().getTagName().toLowerCase().equals("input")) {
					return getAttribute("value");
				} else {
					return getNativeElement().getText();
				}
			}
		};

		String text = getTextAction.execute();
		String normalizedText = normalizeSpaces ? StringHelper.normalizeSpaces(text) : text;

		if (printText) {
			Logger.write(LogStatuses.INFO, String.format("'%1s' has the following text: '%2s'", friendlyName, normalizedText));
		}

		return normalizedText;
	}

	@Override
	public String getAttribute(String attributeName) {
		return getAttribute(attributeName, true);
	}

	@Override
	public String getAttribute(String attributeName, boolean normalizeSpaces) {
		isExist(true);

		UiAction<String> getAttributeAction = new UiAction<String>() {

			@Override
			public String action() {
				String attributeValue = getNativeElement().getAttribute(attributeName);
				return normalizeSpaces ? StringHelper.normalizeSpaces(attributeValue) : attributeValue;
			}
		};

		return getAttributeAction.execute();
	}

	@Override
	public String getInnerHtml() {
		return this.getAttribute("innerHTML");
	}

	@Override
	public String getOuterHtml() {
		return this.getAttribute("outerHTML");
	}

	@Override
	public String getClassAttribute() {
		return getAttribute("class");
	}

	@Override
	public Point getLocation() {
		isExist(true);

		UiAction<Point> getLocationAction = new UiAction<Point>() {

			@Override
			public Point action() {
				return getNativeElement().getLocation();
			}
		};

		return getLocationAction.execute();
	}

	public Dimension getSize() {
		isExist(true);

		UiAction<Dimension> getSizeAction = new UiAction<Dimension>() {

			@Override
			public Dimension action() {
				return getNativeElement().getSize();
			}
		};

		return getSizeAction.execute();
	}

	@Override
	public boolean isEnabled() {
		isExist(true);

		UiAction<Boolean> isEnabledAction = new UiAction<Boolean>() {

			@Override
			public Boolean action() {
				return getNativeElement().isEnabled();
			}
		};

		return isEnabledAction.execute();
	}
}