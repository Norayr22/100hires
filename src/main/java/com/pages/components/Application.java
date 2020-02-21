package com.pages.components;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Application extends com.pages.components.BasePage {

    @FindBy(xpath = "//div[@class = 'questions-form']")
    private WebElement questionsForms;

    @FindBy(css = ".foxy-question-header_only-status > div > ul > li > div > span")
    private WebElement cvOption;

    @FindBy(xpath = "//span[text()='Resume/CV file status updated']")
    private WebElement cvStatusUpdateMessage;

    @FindBy(xpath = "//a[text() ='Next']")
    private WebElement nextButton;

    public Application() {
        super();
    }

    public void clickOnCVOption(){
        cvOption.click();
    }

    public boolean isUpdateMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(cvStatusUpdateMessage));
        return cvStatusUpdateMessage.isDisplayed();
    }

    public void clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    @Override
    public boolean isDisplayed() {
        Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
        return cvOption.isDisplayed();
    }
}
