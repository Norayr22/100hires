package com.test.base;

import com.driver.DriverFactory;
import com.pages.HomePage;
import com.pages.JobsPage;
import com.pages.LoginPage;
import com.pages.NewJobPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.faker.FakeData.*;

public class BaseTest {

    private WebDriver driver;

    protected HomePage homePage;
    protected JobsPage jobsPage;
    protected NewJobPage newJobPage;
    protected String jobTitle;
    protected String internalJobTitle;
    protected String email;
    protected String stage;
    protected int minSalary;
    protected int maxSalary;
    protected int minHour;
    protected int maxHour;
    protected String currency;
    protected int id;

    @BeforeTest
    public void setup() {
        driver = DriverFactory.get().getDriver();
        homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        jobsPage = new JobsPage();
        newJobPage = new NewJobPage();

        // PRECONDITION
        loginPage.goTo();
        Assert.assertTrue(loginPage.isDisplayed());
        loginPage.login("norayr@mailinator.com", "test1234");
        Assert.assertTrue(homePage.isDisplayed());
        Assert.assertTrue(homePage.getSideBar().isDisplayed());
    }

    @BeforeMethod
    public void prepareDataForTest() {
        jobTitle = randomJobTitle();
        internalJobTitle = jobTitle + " for " + randomName();
        email = randomEmail();
        stage = randomStage();
        minSalary = randomNumbers(50000, 100000);
        maxSalary = randomNumbers(105000, 150000);
        minHour = randomNumbers(25, 35);
        maxHour = randomNumbers(40, 60);
        currency = randomCurrency();
        id = randomNumbers(10, 100);
    }

    @AfterTest
    public void quitDriver() {
        DriverFactory.get().quitDriver(driver);
    }
}
