package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.SettingsPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsStepDefinitions {
    private WebDriver driver;
    private SettingsPage settingsPage;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        settingsPage = new SettingsPage(this.driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        if (System.getenv().getOrDefault("headless", "false").equals("false")) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        SharedDriver.getSharedDriverInstance().quitAndResetDriver();
    }

    @Given("I am in the Settings page with id {int}")
    public void i_am_in_the_settings_page(Integer id) {
        driver.get("http://localhost:8080/settings/".concat(Integer.toString(id)));
    }

    @When("I change a user setting")
    public void i_change_a_user_setting() {
        settingsPage.clickCheckBox();
    }

    @When("I press the save button")
    public void i_press_the_save_button() {
        settingsPage.clickSave();
    }

    @Then("the settings should save")
    public void the_settings_should_save() {
        assertTrue(settingsPage.getMessage().contains("Settings saved!"));
    }
}
