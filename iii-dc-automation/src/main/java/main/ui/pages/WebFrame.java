package main.ui.pages;

import main.sessions.BrowserSession;

public class WebFrame extends WebPage
{
    protected WebFrame(BrowserSession session, String name, String searchForNameOrId) {
        super(session, name);
        getSession().getBrowser().getDriver().switchTo().defaultContent();
        getSession().getBrowser().getDriver().switchTo().frame(searchForNameOrId);
    }
}


