package com.pages;

import com.pages.components.BasePage;
import com.pages.components.SideBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private SideBar sideBar;

    @FindBy(xpath = "//div[@class = 'sidebar-menu__user-title-row sidebar-menu__user-title-row_name']")
    private WebElement username;

    public HomePage(){
        super();
        this.sideBar = PageFactory.initElements(driver,SideBar.class);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> username.isDisplayed());
    }

    public SideBar getSideBar(){
        return sideBar;
    }
}
