package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.AchievementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class achievementStepDefinitions {
    private WebDriver driver;
    private AchievementsPage achievementsPage;

    @Before
    public void setup(){
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.achievementsPage = new AchievementsPage(this.driver);
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

    @Given("I visit the achievements page with id {int}")
    public void i_visit_the_achievements_page(int id) {
        driver.get("http://localhost:8080/".concat(Integer.toString(id)).concat("/achievements"));
    }

    @When("the correct achievements page is loaded")
    public void the_achievements_page_is_loaded() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/123456/achievements";
        assertEquals(expectedURL, actualURL);
    }

    @Then("I can see all achievements")
    public void i_can_see_all_achievements() {
        List<WebElement> actualAchievements = achievementsPage.getAchievementsList();
        List<String> actualAchievementNames = new ArrayList<String>();
        for (WebElement element : actualAchievements){
            actualAchievementNames.add(element.getText());
        }
        List<String> expectedAchievementNames = new ArrayList<String>();
        expectedAchievementNames.add("Finished 1st Learning Module");
        expectedAchievementNames.add("Finished 1st Practice Module");

        assertTrue(expectedAchievementNames.containsAll(actualAchievementNames));
    }

    @And("I can see the state of the achievement")
    public void i_can_see_the_state_of_the_achievement() {
        List<WebElement> actualAchievements = achievementsPage.getAchievementStateList();
        List<String> actualAchievementState = new ArrayList<String>();
        for (WebElement element : actualAchievements){
            actualAchievementState.add(element.getText());
        }

        List<String> expectedAchievementState = new ArrayList<String>();
        expectedAchievementState.add("false");
        expectedAchievementState.add("false");
        assertTrue(expectedAchievementState.containsAll(actualAchievementState));
    }

    @Given("I am on the achievements page with id {int}")
    public void i_am_on_the_achievements_page_with_id(int id) {
        driver.get("http://localhost:8080/".concat(Integer.toString(id)).concat("/achievements2"));
    }
    @When("I achieve an achievement")
    public void i_achieve_an_achievement() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/123456/achievements2";
        assertEquals(expectedURL, actualURL);
    }
    @Then("I can see the state of the achievement change")
    public void i_can_see_the_state_of_the_achievement_change() {
        List<WebElement> actualAchievements = achievementsPage.getAchievementStateList();
        List<String> actualAchievementState = new ArrayList<String>();
        for (WebElement element : actualAchievements){
            actualAchievementState.add(element.getText());
        }

        List<String> expectedAchievementState = new ArrayList<String>();
        expectedAchievementState.add("false");
        expectedAchievementState.add("true");
        assertTrue(expectedAchievementState.containsAll(actualAchievementState));
    }

    @When("I click the view Unachieved achievements button")
    public void i_click_the_view_unachieved_achievements_button() {
        achievementsPage.getViewUnachievedButton().click();
    }
    @Then("I can see the achievements that I haven't achieved yet")
    public void i_can_see_the_achievements_that_i_haven_t_achieved_yet() {
        List<WebElement> actualAchievements = achievementsPage.getAchievementStateList();
        List<String> actualAchievementState = new ArrayList<String>();
        for (WebElement element : actualAchievements){
            actualAchievementState.add(element.getText());
        }

        List<String> expectedAchievementState = new ArrayList<String>();
        expectedAchievementState.add("false");
        assertTrue(expectedAchievementState.containsAll(actualAchievementState));
    }

    @When("I click the view Achieved achievements button")
    public void i_click_the_view_achieved_achievements_button() {
        achievementsPage.getViewAchievedButton().click();
    }
    @Then("I can see the achievements that I have achieved")
    public void i_can_see_the_achievements_that_i_have_achieved() {
        List<WebElement> actualAchievements = achievementsPage.getAchievementStateList();
        List<String> actualAchievementState = new ArrayList<String>();
        for (WebElement element : actualAchievements){
            actualAchievementState.add(element.getText());
        }

        List<String> expectedAchievementState = new ArrayList<String>();
        expectedAchievementState.add("true");
        assertTrue(expectedAchievementState.containsAll(actualAchievementState));
    }

}
