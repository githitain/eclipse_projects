package com.web.keywords;

import org.openqa.selenium.SearchContext;

public abstract class WebObjectFinder<T extends SearchContext> 
{
	protected Object[] params;

	public WebObjectFinder(Object... params) 
	{
		this.params = params;
	}

	public abstract T findObject();
}