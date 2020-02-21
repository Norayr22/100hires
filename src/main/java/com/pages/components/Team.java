package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Team extends com.pages.components.BasePage {

    @FindBy(xpath = "//input[@placeholder ='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[text() ='Invite']")
    private WebElement inviteButton;

    @FindBy(xpath = "//a[text() ='Next']")
    private WebElement nextButton;

    public Team(){
        super();
    }

    public void inviteTeamMember(String email){
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(inviteButton));
        inviteButton.click();
    }

    public void clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->emailField.isDisplayed());
    }
}
