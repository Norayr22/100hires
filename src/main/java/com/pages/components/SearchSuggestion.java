package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchSuggestion extends com.pages.components.BasePage {

    @FindBy(xpath = "//div[@class = 'pac-item']")
    private List<WebElement> suggestions;

    public SearchSuggestion() {
        super();
    }

    public void clickSuggestionByIndex() {
        wait.until(ExpectedConditions.elementToBeClickable(suggestions.get(0)));
        actions.moveToElement(suggestions.get(0)).click().build().perform();
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
        return this.wait.until(d -> this.suggestions.size() > 0);
    }
}
