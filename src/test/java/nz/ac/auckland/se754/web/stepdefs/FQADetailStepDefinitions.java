package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.FQAPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FQADetailStepDefinitions {
    private WebDriver driver;
    private FQAPage page;

    @Before
    public void setup(){
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        page = new FQAPage(this.driver);
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
    public String buttonID(String buttonID) {
        return buttonID;
    }

    @ParameterType("text_\\d+")
    public String textID(String textID) {
        return textID;
    }
    @Given("I see a list of question titles on the Help\\/FAQ page")
    public void i_see_a_list_of_question_titles_on_the_help_faq_page() {
        driver.get("http://localhost:8080/FQA");
    }

    @When("I click the {string} of one Question")
    public void I_click_the_button_of_one_Question(String buttonID) {
     page.clickBtn(buttonID);
    }


    @Then("this {string} text style is {string}")
    public void this_TextID_style_is_answerDisplayStyle(String TextID ,String answerDisplayStyle) {
        String displayValue = page.textDisplay(TextID);
       assertEquals(answerDisplayStyle, displayValue);
    }


}
