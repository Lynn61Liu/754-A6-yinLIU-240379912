package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.SearchPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SearchCourseStepDefinitions {
    private WebDriver driver;
    private SearchPage page;

    @Before
    public void setup(){
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        page = new SearchPage(this.driver);
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
    @ParameterType(".*")
    public String input(String value) {
        return value;
    }
    @ParameterType("(\\d+)")
    public int number(String number) {
        return Integer.parseInt(number);
    }

    @Given("I see have search bar at the search page")
    public void I_see_have_search_bar_at_the_search_page() {
        driver.get("http://localhost:8080/search");
    }


    @When("I type the {input} in the input")
    public void I_type_the_searchWorld_in_the_input(String input) {
       page.insertSearchInput(input);
    }

    @And("I click on the search button")
    public void I_click_on_the_search_button(){
       page.clickSearchBtn();
    }

    @Then("I should see search page with {int} course")
    public void I_should_see_search_page_with_num_course(int number) {
        assertEquals(number, page.getContainerNum());

    }


}
