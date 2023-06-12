package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.SearchPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class filterCategoryDefinitions {
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

    @ParameterType("\"([^\"]*)\"")
    public String category(String category) {
        return category;
    }
    @ParameterType("(\\d+)")
    public int num(String num) {
        return Integer.parseInt(num);
    }
    @Given("I visit the search page")
    public void I_visit_the_search_page() {
        driver.get("http://localhost:8080/search");
    }

    @When("I click on the {string} button")
    public void I_click_on_the_category_button(String category) {
     page.clickcategoryBtn(category);
    }
    @Then("I should see {int} filter courses in search page")
    public void i_should_see_filter_courses_in_category_page(int num) {

        assertEquals(num, page.getContainerNum());
    }



}
