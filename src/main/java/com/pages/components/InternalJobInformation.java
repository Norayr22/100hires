package com.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InternalJobInformation extends com.pages.components.BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Select department')]")
    private WebElement selectDepartmentDopDown;

    @FindBy(xpath = "//div[contains(text(), 'Select department')]//..//li")
    private List<WebElement> departmentOptions;

    @FindBy(xpath = "//div[contains(text(), 'Select employment')]")
    private WebElement selectEmploymentTypeDopDown;

    @FindBy(xpath = "//div[contains(text(), 'Select employment')]//..//li")
    private List<WebElement> employmentTypeOptions;

    @FindBy(xpath = "//div[contains(text(), 'Select category')]")
    private WebElement selectCategoryDopDown;

    @FindBy(xpath = "//div[contains(text(), 'Select category')]//..//li")
    private List<WebElement> categoryOptions;

    @FindBy(xpath = "//div[contains(text(), 'Select required education')]")
    private WebElement selectRequiredEducationDopDown;

    @FindBy(xpath = "//div[contains(text(), 'Select required education')]//..//li ")
    private List<WebElement> requiredEducationOptions;

    @FindBy(xpath = "//div[contains(text(), 'Select required experience')]")
    private WebElement selectRequiredExperienceDopDown;

    @FindBy(xpath = "//div[contains(text(), 'Select required experience')]//..//li")
    private List<WebElement> requiredExperienceOptions;

    @FindBy(id = "job-internal_job_id")
    private WebElement internalJobIdField;

    @FindBy(id = "job-internal_title")
    private WebElement internalJobTitle;


    public InternalJobInformation() {
        super();
    }

    public void enterInternalJobInformation(String jobTitle, String id) {
        internalJobTitle.sendKeys(jobTitle);
        selectDepartmentDopDown.click();
        departmentOptions.get(1).click();
        internalJobIdField.sendKeys(id);
        selectEmploymentTypeDopDown.click();
        employmentTypeOptions.get(1).click();
        selectCategoryDopDown.click();
        categoryOptions.get(1).click();
        selectRequiredEducationDopDown.click();
        requiredEducationOptions.get(1).click();
        selectRequiredExperienceDopDown.click();
        requiredExperienceOptions.get(1).click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d -> internalJobIdField.isDisplayed());
    }
}
