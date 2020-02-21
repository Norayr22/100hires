package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Options extends com.pages.components.BasePage {

    @FindBy(xpath = "//div[text()= ' Resume/CV ']//..//ul[@class = 'foxy-dropdown-list foxy-dropdown-list_left']//li")
    private List<WebElement> options;

    public Options(){
        super();
    }

    public void clickOnOption(String option){
        for (WebElement opt:options) {
            if(opt.getText().trim().equals(option)){
                wait.until(ExpectedConditions.elementToBeClickable(opt));
                opt.click();
                break;
            }
        }
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->options.size() == 3);
    }
}
