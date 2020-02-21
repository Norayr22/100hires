package com.pages;

import com.pages.components.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobsPage extends BasePage {

    @FindBy(linkText = "Add job")
    private WebElement addJobBtn;

    public JobsPage(){
        super();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d -> addJobBtn.isDisplayed());
    }

    public void addNewJob() {
        wait.until(ExpectedConditions.elementToBeClickable(addJobBtn));
        actions.moveToElement(addJobBtn).click().build().perform();
    }
}
