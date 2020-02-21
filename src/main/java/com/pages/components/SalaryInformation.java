package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SalaryInformation extends com.pages.components.BasePage {

    @FindBy(id = "job-salary_min")
    private WebElement minJobSalaryField;

    @FindBy(id = "job-salary_max")
    private WebElement maxJobSalaryField;

    @FindBy(xpath = "//div[text() = ' USD ']")
    private WebElement currencyDopDown;

    @FindBy(xpath = "//div[@class = 'form-group field-job-salary_type']//div[@class = 'select-autocomplete']")
    private WebElement datePeriodDopDown;

    @FindBy(id = "job-hours_per_week_min")
    private WebElement minJobHoursField;

    @FindBy(id = "job-hours_per_week_max")
    private WebElement maxJobHoursField;

    @FindBy(xpath = "//div[text() = ' USD ']//..//input[@placeholder = 'Search']")
    private WebElement currencySearchField;

    @FindBy(xpath = "//div[@class = 'form-group field-job-salary_type']//div[@class = 'select-autocomplete']//..//li")
    private List<WebElement> datePeriodOptions;

    @FindBy(xpath = "//div[text() = ' USD ']//..//li")
    private List<WebElement> currencies;

    public SalaryInformation(){
        super();
    }

    public void enterSalaryInformation(String minSalary, String maxSalary, String currency, String minHours, String maxHours){
        minJobSalaryField.sendKeys(minSalary);
        maxJobSalaryField.sendKeys(maxSalary);
        currencyDopDown.click();
        currencySearchField.sendKeys(currency);
        currencies.get(0).click();
        datePeriodDopDown.click();
        datePeriodOptions.get(0).click();
        minJobHoursField.sendKeys(minHours);
        maxJobHoursField.sendKeys(maxHours);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->minJobSalaryField.isDisplayed());
    }
}
