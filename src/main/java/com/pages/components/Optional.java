package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Optional extends com.pages.components.BasePage {

    @FindBy(css = "form > div > div.row")
    private WebElement optionalFields;

    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    private WebElement nextButton;

    public Optional(){
        super();
    }

    public void clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->optionalFields.isDisplayed());
    }
}
