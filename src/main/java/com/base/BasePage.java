package com.pages.components;

import com.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    public BasePage() {
        driver = DriverFactory.get().getDriver();
        this.wait = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
