package com.web.ui.objects;

import org.openqa.selenium.By;

import com.web.keywords.WebCheckBox;
import com.web.keywords.WebObject;
import com.web.ui.pages.WebObjectsContainer;


public class EncoreWebCheckBox extends WebCheckBox {

    public EncoreWebCheckBox(WebObjectsContainer<?> parent, By findBy, String friendlyName) {
        super(parent, findBy, friendlyName);
    }

    @Override
    public boolean isChecked() {
        String checkedMarker = "checkboxChecked";
        WebObject img = this.getChildWebObject(By.cssSelector("img"), "Checkbox Image");
        return img.getAttribute("id").contains(checkedMarker);
    }

    @Override
    public void check() {
        if (isChecked()) {
            return;
        }
        click();
    }

    @Override
    public void uncheck() {
        if (!isChecked()) {
            return;
        }
        click();
    }
}
