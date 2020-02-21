package com.test;

import com.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.faker.FakeData.*;

public class RemoteVacancyTest extends BaseTest {
    /**
     * TITLE: Create Remote Job test
     * PRECONDITION: The user is already logged in
     * STEPS TO REPRODUCE:
     * 1. Click on Job section from menu
     * 2. Click on 'Add' button for creating new job
     * 3. Enter job title
     * 4. Enter job location
     * 5. Enter some note
     * 6. Click on remote CheckBox
     * 7. Click on 'Next' button
     * 8. Choose CVOption(the data can be changed by dataProvider)
     * 9  Click on 'Next' button
     * 10.Invite team member
     * 11.Click on 'Next' button
     * 12.Add some evaluation skills
     * 13 Click on 'Next' button
     * 14.Enter some pipeline stage
     * 15.Click on 'Next' button
     * 16.Enter internal job information
     * 17.Enter salary information
     * 18.Click on 'Next' button
     * 19.Choose visibility of job(the data can be changed by dataProvider)
     * 20.Click on 'Save' button
     * EXPECTED RESULT:
     * Created job should have the same internal job title which we have provided on step 16"
     * Created job should have the job info 'Remote'
     * Created job should have the provided visibility which we have provided on step 19")
     */

    @Test(dataProvider = "testData")

    public void createRemoteVacancyTest(String CVOption, String jobVisibility) throws InterruptedException {
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
        newJobPage.getDetails().clickRemoteCheckBox();
        Assert.assertTrue(newJobPage.getDetails().remoteCheckBoxChecked());

        //STEP 7
        newJobPage.getDetails().clickOnNextButton();
        Assert.assertTrue(newJobPage.getApplication().isDisplayed());

        //STEP 8
        newJobPage.getApplication().clickOnCVOption();
        Assert.assertTrue(newJobPage.getOptions().isDisplayed());
        newJobPage.getOptions().clickOnOption(CVOption);
        Assert.assertTrue(newJobPage.getApplication().isUpdateMessageDisplayed());

        //STEP 9
        newJobPage.getApplication().clickOnNextButton();
        Assert.assertTrue(newJobPage.getTeam().isDisplayed());

        //STEP 10
        newJobPage.getTeam().inviteTeamMember(email);
        Assert.assertTrue(newJobPage.getInvitedEmail().isDisplayed());
        Assert.assertEquals(newJobPage.getInvitedEmail().invitedEmailAddress(), email, "the emails are not matching");

        //STEP 11
        newJobPage.getTeam().clickOnNextButton();
        Assert.assertTrue(newJobPage.getEvaluation().isDisplayed());

        //STEP 12
        int skillCount = newJobPage.getEvaluation().getSkillCount();
        newJobPage.getEvaluation().addSomeSkill(randomSkill());
        int newSkillCount = newJobPage.getEvaluation().getSkillCount();
        Assert.assertTrue(newSkillCount > skillCount);

        //STEP 13
        newJobPage.getEvaluation().clickOnNextButton();
        Assert.assertTrue(newJobPage.getWorkflow().isDisplayed());

        //STEP 14
        newJobPage.getWorkflow().enterPipelineStage(stage);

        //STEP 15
        newJobPage.getWorkflow().clickOnNextButton();
        Assert.assertTrue(newJobPage.getOptional().isDisplayed());
        Assert.assertTrue(newJobPage.getInternalJobInformation().isDisplayed());
        Assert.assertTrue(newJobPage.getSalaryInfromation().isDisplayed());

        //STEP 16
        newJobPage.getInternalJobInformation().enterInternalJobInformation(internalJobTitle, id + "");

        //STEP 17
        newJobPage.getSalaryInfromation().enterSalaryInformation(minSalary + "", maxSalary + "", currency, minHour + "", maxHour + "");

        //STEP 18
        newJobPage.getOptional().clickOnNextButton();
        Assert.assertTrue(newJobPage.getPublish().isDisplayed());

        //STEP 19
        newJobPage.getPublish().chooseVisibility(jobVisibility);
        Assert.assertTrue(newJobPage.getPublish().updateMessageDisplayed());

        //STEP 20
        newJobPage.getPublish().clickOnSaveButton();
        Assert.assertTrue(newJobPage.getCreatedJobPage().isDisplayed());

        //EXPECTED RESULT
        Assert.assertEquals(newJobPage.getCreatedJobPage().getJobTitle(), internalJobTitle);
        Assert.assertEquals(newJobPage.getCreatedJobPage().getCreatedJobStatus(), jobVisibility);
        Assert.assertEquals(newJobPage.getCreatedJobPage().getJobInfo(), "Remote");
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
                {"Hidden", "Draft"},
                {"Required", "Public"},
                {"Hidden", "Archived"}
        };
    }
}
