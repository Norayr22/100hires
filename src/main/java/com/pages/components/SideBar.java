package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SideBar extends com.pages.components.BasePage {

    @FindBy(xpath = "//span[text() = 'Jobs']")
    private WebElement jobsMenu;

    @FindBy(className = "sidebar-menu__item-text")
    private List<WebElement> sideBarMenues;

    public SideBar(){
        super();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> sideBarMenues.size()>5);
    }

    public void clickOnJobsMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(jobsMenu));
        actions.moveToElement(jobsMenu).click().build().perform();
    }
}
