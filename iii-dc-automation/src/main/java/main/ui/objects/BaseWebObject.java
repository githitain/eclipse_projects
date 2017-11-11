package main.ui.objects;

import main.ui.pages.WebPage;
import org.openqa.selenium.Point;


public interface BaseWebObject 
{
    WebPage getParentPage();

    boolean isExist();

    boolean isExist(boolean throwIfNotExist);

    boolean isExist(int waitTimeout);

    boolean isExist(int waitTimeout, boolean throwIfNotExist);

    boolean waitUntilDisappear();

    boolean waitUntilDisappear(boolean throwIfNotDisappear);

    boolean waitUntilDisappear(int timeout, boolean throwIfNotDisappear);

    void clickIfExist();

    void clickIfExist(int timeout);

    void click();

    void click(boolean logEnabled);

    void click(boolean logEnabled, boolean waitForPageLoading);

    void click(int x, int y);

    void click(int x, int y, boolean logEnabled);

    void click(int x, int y, boolean logEnabled, boolean waitForPageLoading);

    void rightClick();

    void doubleClick();

    void doubleClick(boolean logEnabled);

    void doubleClick(int x, int y);

    void dragAndDropTo(WebObject targetObject);

    String getText();

    String getText(boolean normalizeSpaces);

    String getText(boolean normalizeSpaces, boolean printText);

    String getAttribute(String attributeName);

    String getAttribute(String attributeName, boolean normalizeSpaces);

    String getInnerHtml();

    String getOuterHtml();

    String getClassAttribute();

    Point getLocation();

    boolean isEnabled();
}
