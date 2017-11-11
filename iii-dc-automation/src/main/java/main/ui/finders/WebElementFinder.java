package main.ui.finders;

import org.openqa.selenium.WebElement;

public abstract class WebElementFinder extends WebObjectFinder<WebElement> 
{
	public WebElementFinder(Object... params) 
	{
		super(params);
	}
}
