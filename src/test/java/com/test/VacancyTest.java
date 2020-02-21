package com.test;

import com.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.faker.FakeData.*;

public class VacancyTest extends BaseTest {
    /**
     * TITLE: Create Job test
     * PRECONDITION: The user is already logged in
     * STEPS TO REPRODUCE:
     * 1. Click on Job section from menu
     * 2. Click on 'Add' button for creating new job
     * 3. Enter job title
     * 4. Enter job location
     * 5. Enter some note
     * 6. Click on 'Next' button
     * 7. Choose CVOption(the data can be changed by dataProvider)
     * 8  Click on 'Next' button
     * 9.Invite team member
     * 10.Click on 'Next' button
     * 11.Add some evaluation skills
     * 12 Click on 'Next' button
     * 13.Enter some pipeline stage
     * 14.Click on 'Next' button
     * 15.Enter internal job information
     * 16.Enter salary information
     * 17.Click on 'Next' button
     * 18.Choose visibility of job(the data can be changed by dataProvider)
     * 19.Click on 'Save' button
     * EXPECTED RESULT:
     * Created job should have the same internal job title which we have provided on step 16
     * Created job should not have the job info 'Remote'
     * Created job should have the provided visibility which we have provided on step 19")
     */

    @Test(dataProvider = "testData")

    public void createVacancyTest(String CVOption, String jobVisibility) throws InterruptedException {
        //STEP 1
        homePage.getSideBar().clickOnJobsMenu();
        Assert.assertTrue(jobsPage.isDisplayed());

        //STEP 2
        jobsPage.addNewJob();
        Assert.assertTrue(newJobPage.isDisplayed());
        Assert.assertTrue(newJobPage.getDetails().isDisplayed());

        //STEP 3
        newJobPage.getDetails().enterJobTitle(jobTitle);

        //STEP 4
        newJobPage.getDetails().enterJobLocation(randomCountry());
        Assert.assertTrue(newJobPage.getSearchSuggestion().isDisplayed());
        newJobPage.getSearchSuggestion().clickSuggestionByIndex();

        //STEP 5
        newJobPage.getDetails().enterSomeNote(randomText());

        //STEP 6
        newJobPage.getDetails().clickOnNextButton();
        Assert.assertTrue(newJobPage.getApplication().isDisplayed());

        //STEP 7
        newJobPage.getApplication().clickOnCVOption();
        Assert.assertTrue(newJobPage.getOptions().isDisplayed());
        newJobPage.getOptions().clickOnOption(CVOption);
        Assert.assertTrue(newJobPage.getApplication().isUpdateMessageDisplayed());

        //STEP 8
        newJobPage.getApplication().clickOnNextButton();
        Assert.assertTrue(newJobPage.getTeam().isDisplayed());

        //STEP 9
        newJobPage.getTeam().inviteTeamMember(email);
        Assert.assertTrue(newJobPage.getInvitedEmail().isDisplayed());
        Assert.assertEquals(newJobPage.getInvitedEmail().invitedEmailAddress(), email, "the emails are not matching");

        //STEP 10
        newJobPage.getTeam().clickOnNextButton();
        Assert.assertTrue(newJobPage.getEvaluation().isDisplayed());

        //STEP 11
        int skillCount = newJobPage.getEvaluation().getSkillCount();
        newJobPage.getEvaluation().addSomeSkill(randomSkill());
        int newSkillCount = newJobPage.getEvaluation().getSkillCount();
        Assert.assertTrue(newSkillCount > skillCount);

        //STEP 12
        newJobPage.getEvaluation().clickOnNextButton();
        Assert.assertTrue(newJobPage.getWorkflow().isDisplayed());

        //STEP 13
        newJobPage.getWorkflow().enterPipelineStage(stage);

        //STEP 14
        newJobPage.getWorkflow().clickOnNextButton();
        Assert.assertTrue(newJobPage.getOptional().isDisplayed());
        Assert.assertTrue(newJobPage.getInternalJobInformation().isDisplayed());
        Assert.assertTrue(newJobPage.getSalaryInfromation().isDisplayed());

        //STEP 15
        newJobPage.getInternalJobInformation().enterInternalJobInformation(internalJobTitle, id + "");

        //STEP 16
        newJobPage.getSalaryInfromation().enterSalaryInformation(minSalary + "", maxSalary + "", currency, minHour + "", maxHour + "");

        //STEP 17
        newJobPage.getOptional().clickOnNextButton();
        Assert.assertTrue(newJobPage.getPublish().isDisplayed());

        //STEP 18
        newJobPage.getPublish().chooseVisibility(jobVisibility);
        Assert.assertTrue(newJobPage.getPublish().updateMessageDisplayed());

        //STEP 19
        newJobPage.getPublish().clickOnSaveButton();
        Assert.assertTrue(newJobPage.getCreatedJobPage().isDisplayed());

        //EXPECTED RESULT
        Assert.assertEquals(newJobPage.getCreatedJobPage().getJobTitle(), internalJobTitle);
        Assert.assertEquals(newJobPage.getCreatedJobPage().getCreatedJobStatus(), jobVisibility);
        Assert.assertNotEquals(newJobPage.getCreatedJobPage().getJobInfo(), "Remote");
    }

    /**
     * The tests will run with provided Data, for checking the behaviour of app,
     * this options.
     * The first option is for choosing CVOption
     * The second option for visibility of created vacancy.
     */
    @DataProvider
    public Object[][] testData() {

        return new Object[][]{
                {"Hidden", "Archived"},
                {"Required", "Draft"},
                {"Hidden", "Public"}
        };
    }
}
