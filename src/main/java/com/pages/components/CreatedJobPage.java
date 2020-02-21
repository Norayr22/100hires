package com.pages.components;

import com.pages.components.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatedJobPage extends BasePage {

    @FindBy(xpath = "//button[@class = 'job-block-management__status__btn']")
    private WebElement jobStatus;

    @FindBy(className = "job-pipeline__container")
    private WebElement pipelineContainer;

    @FindBy(xpath = "(//li[@class = 'job-header-info__item'])[2]")
    private WebElement jobInfo;

    @FindBy(xpath = "//div[@class = 'sub-header']/h1")
    private WebElement jobTitle;

    public CreatedJobPage(){
        super();
    }

    public String getCreatedJobStatus(){
        return jobStatus.getText();
    }

    public String getJobInfo(){
        return jobInfo.getText();
    }

    public String getJobTitle(){
        return jobTitle.getText();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->pipelineContainer.isDisplayed());
    }
}
