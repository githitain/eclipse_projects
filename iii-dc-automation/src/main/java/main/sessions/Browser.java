package main.sessions;

import org.openqa.selenium.WebDriver;

public class Browser
{
    private WebDriver driver;
    private SessionProxy proxy;

    public Browser(WebDriver driver, SessionProxy proxy)
    {
        this.driver = driver;
        this.proxy = proxy;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public SessionProxy getProxy()
    {
        return proxy;
    }
}
