package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterStepDefinitions {
    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        registerPage = new RegisterPage(this.driver);
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

    @Given("I visit the register page")
    public void i_visit_the_register_page() {
        driver.get("http://localhost:8080/register");
    }

    @When("I enter {string} as the email field")
    public void i_enter_as_the_email_field(String string) {
        registerPage.insertEmail(string);
    }

    @When("I enter {string} as the username field")
    public void i_enter_as_the_username_field(String string) {
        registerPage.insertUserName(string);
    }

    @When("I enter {string} as the password field")
    public void i_enter_as_the_password_field(String string) {
        registerPage.insertPassword(string);
    }

    @When("I press the register button")
    public void i_press_the_register_button() {
        registerPage.clickRegister();
    }

    @Then("I should receive a message indicating I have created an account")
    public void i_should_receive_a_message_indicating_i_have_created_an_account() {
        assertTrue(registerPage.getSuccessMessage().contains("You have created an account!"));
    }

    @Then("I should receive a message indicating the email is taken")
    public void i_should_receive_a_message_indicating_the_email_is_taken() {
        assertTrue(registerPage.getFailMessage().contains("This email is taken!"));
    }

    @Then("I should receive a message indicating the username is taken")
    public void i_should_receive_a_message_indicating_the_username_is_taken() {
        assertTrue(registerPage.getFailMessage().contains("This username is taken!"));
    }
}
