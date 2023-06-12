package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.AnalyticsPage;
import nz.ac.auckland.se754.web.pages.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalyticsStepDefinitions {

    private WebDriver driver;
    private AnalyticsPage analyticsPage;
    private SettingsPage settingsPage;

    @Before
    public void setup(){
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.settingsPage = new SettingsPage(this.driver);
        this.analyticsPage = new AnalyticsPage(this.driver);
    }

    @AfterStep
    public void afterEachStep(){
        // to make the test at human speed
        if (System.getenv().getOrDefault("headless", "false").equals("false")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        SharedDriver.getSharedDriverInstance().quitAndResetDriver();
    }
    @Given("I am a user on the application")
    public void i_am_a_user_on_the_application() {
        driver.get("http://localhost:8080/settings");
    }
    @When("I click the navigation page button")
    public void i_click_the_navigation_page_button() {
        settingsPage.clickViewAnalytics();
    }
    @Then("I should be redirected to the analytics page")
    public void i_should_be_redirected_to_the_analytics_page() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/analytics";
        assertEquals(expectedURL,actualURL);
    }

    @Given("I am on the analytics page")
    public void i_am_on_the_analytics_page() {
        driver.get("http://localhost:8080/analytics");
    }
    @When("The analytics page is loaded")
    public void the_analytics_page_is_loaded() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/analytics";
        assertEquals(expectedURL,actualURL);
    }
    @Then("I should be able to see my progress on the analytics page")
    public void i_should_be_able_to_see_my_progress_on_the_analytics_page() {
        List<WebElement> actualLearning = analyticsPage.getLearningModules();
        List<WebElement> actualLearningProgress = analyticsPage.getLearningModulesProgress();
        List<WebElement> actualPractice = analyticsPage.getPracticeModules();
        List<WebElement> actualPracticeProgress = analyticsPage.getPracticeModulesProgress();
        List<String> actualLearningList = new ArrayList<String>();
        List<String> actualLearningProgressList = new ArrayList<String>();
        List<String> actualPracticeList = new ArrayList<String>();
        List<String> actualPracticeProgressList = new ArrayList<String>();

        for (WebElement element : actualLearning){
            actualLearningList.add(element.getText());
        }
        for (WebElement element : actualLearningProgress){
            actualLearningProgressList.add(element.getText());
        }
        for (WebElement element : actualPractice){
            actualPracticeList.add(element.getText());
        }
        for (WebElement element : actualPracticeProgress){
            actualPracticeProgressList.add(element.getText());
        }
        List<String> expectedLearning = new ArrayList<String>();
        List<String> expectedLearningProgress = new ArrayList<String>();
        List<String> expectedPractice = new ArrayList<String>();
        List<String> expectedPracticeProgress = new ArrayList<String>();

        expectedLearning.add("Java");
        expectedLearning.add("Lists");
        expectedLearningProgress.add("true");
        expectedLearningProgress.add("true");
        expectedPractice.add("Java");
        expectedPractice.add("Lists");
        expectedPracticeProgress.add("false");
        expectedPracticeProgress.add("false");

        assertTrue(expectedLearning.containsAll(actualLearningList));
        assertTrue(expectedLearningProgress.containsAll(actualLearningProgressList));
        assertTrue(expectedPractice.containsAll(actualPracticeList));
        assertTrue(expectedPracticeProgress.containsAll(actualPracticeProgressList));
    }

    @Then("I should be able to see a progress bar for my course")
    public void i_should_be_able_to_see_a_progress_bar_for_my_course() {
        WebElement bar = analyticsPage.getProgressBar();
        assertTrue(bar.isDisplayed());
        assertTrue(bar.isEnabled());
    }

    @Then("The progress bar should show an updated visual compared to last time")
    public void the_progress_bar_should_show_an_updated_visual_compared_to_last_time() {
        WebElement bar = analyticsPage.getProgressBar();
        String actualProgress = bar.getAttribute("value");
        String expectedProgress = "0.5";
        assertTrue(expectedProgress.equals(actualProgress));
    }



}
