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
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class sortAlpStepDefinitions {
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

    @Given("I navigate to the search page")
    public void I_navigate_to_the_search_page() {
        driver.get("http://localhost:8080/search");
    }

    @When("I click on the sort button")
    public void I_click_on_the_sort_button() {
     page.clickSortBtn();
    }
    @Then("I should see courses order alphabetically")
    public void i_should_see_courses_order_alphabetically() {
        List<String> courseItems = new ArrayList<>();
        courseItems.add("Full Stack Java Developer");
        courseItems.add("Introduction To Computational Robotics");
        courseItems.add("Operating Systems Design");
        courseItems.add("Python Fundamentals");
        courseItems.add("The Complete Java Development Bootcamp");

        assertEquals(courseItems,page.getOrderCoursesName());


    }



}
