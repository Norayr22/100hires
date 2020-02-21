package com.pages;

import com.pages.components.*;
import com.pages.components.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewJobPage extends BasePage {

    private Details details;
    private SearchSuggestion searchSuggestion;
    private Application application;
    private Options options;
    private Team team;
    private InvitedEmail invitedEmail;
    private Evaluation evaluation;
    private Workflow workflow;
    private Optional optional;
    private SalaryInformation salaryInformationn;
    private InternalJobInformation internalJobInformation;
    private Publish publish;
    private CreatedJobPage createdJobPage;

    @FindBy(xpath = "//h1[text() = 'New job']")
    private WebElement newJobPageTitle;

    public NewJobPage() {
        super();
        this.details = PageFactory.initElements(driver, Details.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.application = PageFactory.initElements(driver, Application.class);
        this.options = PageFactory.initElements(driver, Options.class);
        this.team = PageFactory.initElements(driver, Team.class);
        this.invitedEmail = PageFactory.initElements(driver, InvitedEmail.class);
        this.evaluation = PageFactory.initElements(driver, Evaluation.class);
        this.workflow = PageFactory.initElements(driver, Workflow.class);
        this.optional = PageFactory.initElements(driver, Optional.class);
        this.salaryInformationn = PageFactory.initElements(driver, SalaryInformation.class);
        this.internalJobInformation = PageFactory.initElements(driver, InternalJobInformation.class);
        this.publish = PageFactory.initElements(driver, Publish.class);
        this.createdJobPage = PageFactory.initElements(driver, CreatedJobPage.class);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d -> newJobPageTitle.isDisplayed());
    }

    public Details getDetails() {
        return details;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public Options getOptions() {
        return options;
    }

    public Application getApplication() {
        return application;
    }

    public Team getTeam() {
        return team;
    }

    public InvitedEmail getInvitedEmail() {
        return invitedEmail;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public Optional getOptional() {
        return optional;
    }

    public SalaryInformation getSalaryInfromation() {
        return salaryInformationn;
    }

    public InternalJobInformation getInternalJobInformation() {
        return internalJobInformation;
    }

    public Publish getPublish() {
        return publish;
    }

    public CreatedJobPage getCreatedJobPage() {
        return createdJobPage;
    }
}
