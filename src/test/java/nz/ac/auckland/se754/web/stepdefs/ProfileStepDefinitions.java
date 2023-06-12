package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.ProfilePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileStepDefinitions {
    private WebDriver driver;
    private ProfilePage profilePage;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.profilePage = new ProfilePage(driver);
    }

    @AfterStep
    public void afterEachStep() {
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

    @Given("I visit my profile page with id {int}")
    public void i_visit_my_profile_page_with_id(Integer id) {
        driver.get("http://localhost:8080/profile/".concat(Integer.toString(id)));
    }

    @When("I change the visibility of a profile section")
    public void i_change_the_visibility_of_a_profile_section() {
        profilePage.checkProfileSectionTwo();
    }

    @When("I press the save button for profile")
    public void i_press_the_save_button_for_profile() {
        profilePage.clickSave();
    }

    @Then("the visibility of the profile sections should save")
    public void the_visibility_of_the_profile_sections_should_save() {
        assertTrue(profilePage.getMessage().contains("Profile Information Updated!"));
    }

    @When("I change the visibility of my profile")
    public void i_change_the_visibility_of_my_profile() {
        profilePage.checkProfileVisibility();
    }

    @When("I save the profile visibility")
    public void i_save_the_profile_visibility() {
        profilePage.clickSaveVisibility();
    }

    @Then("the overall visibility of my profile should be saved")
    public void the_overall_visibility_of_my_profile_should_be_saved() {
        assertTrue(profilePage.getMessage().contains("Profile Information Updated!"));
    }


}
