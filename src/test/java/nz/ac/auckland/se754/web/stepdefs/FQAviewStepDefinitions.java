package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import nz.ac.auckland.se754.web.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FQAviewStepDefinitions {
    private WebDriver driver;
    private LoginPage page;

    @Before
    public void setup(){
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        page = new LoginPage(this.driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        if (System.getenv().getOrDefault("headless", "false").equals("false")) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        // driver.close();
    }

    @Given("I navigate to the login page")
    public void i_navigate_the_login_page() {
        driver.get("http://localhost:8080/login");
    }


    @When("I click the Help\\/FAQ links in page foot")
    public void i_click_the_help_faq_links_in_page_foot() {
        // Write code here that turns the phrase above into concrete actions
        page.clickFQA();
    }



    @Then("I should see FAQ page")
    public void i_should_see_FAQ_page() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/FQA", currentUrl);

    }


}
