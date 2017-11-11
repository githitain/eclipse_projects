package com.web.ui.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.utilites.RandomGenerator;
import com.web.keywords.WebObject;
import com.web.ui.pages.WebObjectsContainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WebSelect extends WebObject 
{

    private Select nativeSelect;

    public WebSelect(WebObjectsContainer<?> parent, By findBy, String friendlyName) {
        super(parent, findBy, friendlyName);
        nativeSelect = new Select(this.getNativeElement());
    }

    public void select(String text) {
        nativeSelect.selectByVisibleText(text);
    }

    public List<String> getAvailableItems() {
        return nativeSelect.getOptions().stream().
                map(select -> select.getText()).collect(Collectors.toList());
    }

    public String getSelectedValue() {
        return nativeSelect.getFirstSelectedOption().getText();
    }

    public String selectRandom(){
        List<String> options = getAvailableItems();
        int randomValue = RandomGenerator.getRandomInt(0,options.size()-1);
        select(options.get(randomValue));
        return getSelectedValue();
    }

    public String selectRandomExcept(String stringValue){
        return selectRandomExcept(new String[] {stringValue});
    }

    public String selectRandomExcept(String[] exceptStrings){
        List<String> options = getAvailableItems();
        options.removeAll(Arrays.asList(exceptStrings));
        int randomValue = RandomGenerator.getRandomInt(0,options.size()-1);
        select(options.get(randomValue));
        return getSelectedValue();
    }

}
