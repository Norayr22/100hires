package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvitedEmail extends com.pages.components.BasePage {

    @FindBy(css = "table:nth-child(2) span.members-table__name")
    private WebElement invitedEmailAddress;

    public InvitedEmail(){
        super();
    }

    public String invitedEmailAddress(){
        return invitedEmailAddress.getText();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->invitedEmailAddress.isDisplayed());
    }
}
