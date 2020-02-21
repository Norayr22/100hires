package com.pages.components;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Details extends com.pages.components.BasePage {

    @FindBy(id = "job-title")
    private WebElement jobTitleField;

    @FindBy(xpath = "//input[@name = 'job_location[full_address]']")
    private WebElement jobLocationField;

    @FindBy(id = "job-remote")
    private WebElement remoteJobCheckBox;

    @FindBy(xpath = "//div[@class = 'note-editable']")
    private WebElement notesField;

    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    private WebElement nextButton;

    public Details(){
        super();
    }

    public void enterJobTitle(String jobTitle){
        jobTitleField.sendKeys(jobTitle);
    }

    public void enterJobLocation(String jobLocation){
        jobLocationField.clear();
        for (char ch : jobLocation.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS);
            jobLocationField.sendKeys(ch + "");
        }
    }

    public void clickRemoteCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(remoteJobCheckBox));
        remoteJobCheckBox.click();
    }

    public boolean remoteCheckBoxChecked(){
        return remoteJobCheckBox.isSelected();
    }

    public void enterSomeNote(String note){
        notesField.clear();
        notesField.sendKeys(note);
    }

    public void clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->notesField.isDisplayed());
    }
}
