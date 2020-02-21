package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Workflow extends com.pages.components.BasePage {

    @FindBy(xpath = "//input[@placeholder = 'Add pipeline stage']")
    private WebElement pipelineStageField;

    @FindBy(css = ".stage-form__add > div > div > div")
    private WebElement addCustomeStageBtn;

    @FindBy(xpath = "//a[text() ='Next']")
    private WebElement nextButton;

    public Workflow(){
        super();
    }

    public void enterPipelineStage(String pipelineStage){
        pipelineStageField.click();
        pipelineStageField.sendKeys(pipelineStage);
        wait.until(ExpectedConditions.elementToBeClickable(addCustomeStageBtn));
        addCustomeStageBtn.click();
    }

    public void clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->pipelineStageField.isDisplayed());
    }
}
