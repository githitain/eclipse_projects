package main.ui.objects;

import org.openqa.selenium.By;
import main.ui.pages.WebObjectsContainer;

public class WebImage extends WebObject {

	public WebImage(WebObjectsContainer<?> parentObject, By findBy, String friendlyName) {
		super(parentObject, findBy, friendlyName);
	}
}	
