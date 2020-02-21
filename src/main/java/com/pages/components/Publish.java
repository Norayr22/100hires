package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Publish extends com.pages.components.BasePage {

    @FindBy(xpath = "//div[@class = 'col-md-12']//button[@class ='job-block-management__status__btn']")
    private WebElement visibilityDropdown;

    @FindBy(xpath = "//div[@class = 'col-md-12']//div[@class = 'job-block-management__status__label__title']/b")
    private List<WebElement> vibilityOptions;

    @FindBy(xpath = "//a[text() = 'Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@data-notify = 'message']")
    private WebElement updateMessage;

    public Publish(){
        super();
    }

    public void chooseVisibility(String visibilityOption){
        visibilityDropdown.click();
        for (WebElement opt:vibilityOptions) {
            if(opt.getText().trim().equals(visibilityOption)){
                wait.until(ExpectedConditions.elementToBeClickable(opt));
                opt.click();
                break;
            }
        }
    }

    public boolean updateMessageDisplayed(){
        wait.until(d->updateMessage.isDisplayed());
        return updateMessage.isDisplayed();
    }

    public void clickOnSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->visibilityDropdown.isDisplayed());
    }
}
