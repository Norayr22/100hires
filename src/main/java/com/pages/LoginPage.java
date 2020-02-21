package com.pages;

import com.pages.components.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "loginform-email")
    private WebElement usernameField;

    @FindBy(id = "loginform-password")
    private WebElement passwordField;

    @FindBy(name = "login-button")
    private WebElement signInBtn;

    public LoginPage() {
        super();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> signInBtn.isDisplayed());
    }

    public void goTo() {
        driver.get("https://app.100hires.com/");
    }

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInBtn.click();
    }
}
