package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Evaluation extends com.pages.components.BasePage {

    @FindBy(xpath = "//a[text() = 'Add']")
    private WebElement addSkillButton;

    @FindBy(xpath = "(//div//textarea)[last()]")
    private WebElement skillTextField;

    @FindBy(className = "foxy-question-scorecard-options__option")
    private List<WebElement> skillsCount;

    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    private WebElement nextButton;

    public Evaluation() {
        super();
    }

    public void addSomeSkill(String skill) {
        wait.until(ExpectedConditions.elementToBeClickable(addSkillButton));
        addSkillButton.click();
        skillTextField.sendKeys(skill);
    }

    public int getSkillCount(){
        return skillsCount.size();
    }

    public void clickOnNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d -> nextButton.isDisplayed());
    }
}
