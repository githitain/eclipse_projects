package test.ui.popups;

import main.ui.objects.*;
import main.ui.pages.WebPage;
import main.utils.RandomGenerator;
import org.openqa.selenium.By;
import test.ui.objects.WebSelect;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class RequestItPopup extends WebObject{
    public RequestItPopup(WebPage page, By locator){
        super(page, locator, "Request it popup");
    }

    public WebSelect getDestination(DeliveryMethod method){
        return new WebSelect(this, By.xpath(String.format(".//div[@id='%sSelectArea']//select[contains(@id,'LocationSelectionComponent')]",
                method.toString().toLowerCase())),"Destination for requested item");
    }

    public WebObject getDeadlineCheckbox(){
        return new WebObject(this, By.xpath(".//input[@id='deadlineForMaterialCheckboxComponent']"),"Deadline checkbox");
    }

    public WebEditField getInstructions(){
        return new WebEditField(this, By.id("instructionTextAreaComponent"), "Instructions field" );
    }

    public WebSelect getMonthSelect(){
        return new WebSelect (this, By.id("monthSelectComponent"),"Month selector");
    }

    public WebSelect getDaySelect(){
        return new WebSelect(this, By.id("daySelectComponent"),"Day selector");
    }

    public WebSelect getYearSelect(){
        return new WebSelect(this, By.id("yearSelectComponent"),"Year selector");
    }

    public WebButton getSubmitButton(){
        return new WebButton(this,By.id("itemRequestSubmitComponent"), "Submit button");
    }

    public void setDeadlineDate(LocalDate date){
        getMonthSelect().select(date.getMonth().getDisplayName(TextStyle.FULL, Locale.US));
        getDaySelect().select(String.valueOf(date.getDayOfMonth()));
        getYearSelect().select(String.valueOf(date.getYear()));
    }

    public void selectDeliveryMethod(DeliveryMethod method){
         new WebObject(this, By.xpath(String.format(".//input[contains(@id,'%sRadioComponent')]",
                 method.toString())), "Radio button").click();
    }

    public String selectRandomBibItem(){
        WebObjectsCollection itemRows = this.findChildren(By.xpath("//radiogroup[@id='itemsRadioGroupComponent']//tr"),5);
        if(itemRows.isEmpty()){
            return "";
        }
        WebObject itemRow = itemRows.get(RandomGenerator.getRandomInt(0,itemRows.size()-1));
        itemRow.findChildren(By.xpath(".//input")).stream().findFirst().orElse(null).click();
        return itemRow.findChildren(By.xpath(".//td[2]")).stream().findFirst().orElse(null).getText();
    }

    public void submitRequest(RequestInstance request){
        selectRandomBibItem();
        selectDeliveryMethod(request.method);
        if(request.destination == "")
        {
            request.destination = getDestination(request.method).selectRandom();
        }else
        {
            getDestination(request.method).select(request.destination);
        }
        getDeadlineCheckbox().click();
        setDeadlineDate(request.deadline);
        getInstructions().setText(request.instructions);
        getSubmitButton().click();
    }

    public static class RequestInstance {
        public static RequestInstance defaultRequestInstance = new RequestInstance();

        public DeliveryMethod method;
        public String destination;
        public LocalDate deadline;
        public String instructions;

        private RequestInstance(){
            int value = RandomGenerator.getRandomInt(1,Integer.MAX_VALUE);
            method = value % 2 == 0 ? DeliveryMethod.Mail : DeliveryMethod.PickUp;
            destination = "";
            deadline = LocalDate.now();
            instructions = String.format("Random instructions %s",value);
        }

        // if by 2018 year it is not used - delete it
        public RequestInstance(DeliveryMethod method, String destination,
                               LocalDate deadline, String instructions){
            this.method = method;
            this.destination = destination;
            this.deadline = deadline;
            this.instructions = instructions;
        }
    }

    public enum DeliveryMethod{
        PickUp("pickUp"),
        Mail("mail");

        String val;

        DeliveryMethod(String value){
            val=value;
        }

        @Override
        public String toString(){
            return val;
        }
    }

}


