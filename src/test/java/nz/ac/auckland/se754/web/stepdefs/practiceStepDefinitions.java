package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.MultipleChoiceQuestionsPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class practiceStepDefinitions {
    private WebDriver driver;

    private MultipleChoiceQuestionsPage page;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.page = new MultipleChoiceQuestionsPage(driver);
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
        SharedDriver.getSharedDriverInstance().quitAndResetDriver();
    }

    @Given("I visit the MCQ page with the id {int}")
    public void iVisitTheMCQPageWithTheId(int id) {
        driver.get("http://localhost:8080/list-mcq/".concat(Integer.toString(id)));
    }

    @When("the MCQ page loads")
    public void theMCQPageLoads() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/list-mcq/123";
        assertEquals(expectedURL, actualURL);
    }

    @Then("I should see the question boolean is the same as string")
    public void iShouldSeeTheQuestionBooleanIsTheSameAsString() {
        String actualName = page.getBooleanIsTheSameAsString().getText();
        String expectedName = "boolean is the same as string";
        assertEquals(expectedName, actualName);
    }

    @And("I should see the question what is an example of a character")
    public void iShouldSeeTheQuestionWhatIsAnExampleOfACharacter() {
        String actualName = page.getExampleOfACharacter().getText();
        String expectedName = "what is an example of a character";
        assertEquals(expectedName, actualName);
    }

    @When("I click the first answer")
    public void iClickTheFirstAnswer() {
        page.clickIsTrue();
    }

    @Then("I should see the progress bar is one out of total questions")
    public void iShouldSeeTheProgressBarIsOne() {
        String actualProgress = page.getProgress().getText();
        String expectedProgress = "Progress: 1 out of 2";
        assertEquals(expectedProgress, actualProgress);
    }

    @When("I click the second answer")
    public void iClickTheSecondAnswer() {
        page.clickIsFalse();
    }

    @Then("I should see the progress bar is two out of total questions")
    public void iShouldSeeTheProgressBarIsTwo() {
        String actualProgress = page.getProgress().getText();
        String expectedProgress = "Progress: 2 out of 2";
        assertEquals(expectedProgress, actualProgress);
    }

    @When("I click the third answer")
    public void iClickTheThirdAnswer() {
        page.clickA();
    }

    @When("I click submit")
    public void iClickSubmit() {
        page.clickSubmit();
    }

    @When("I click the fourth answer")
    public void iClickTheFourthAnswer() {
        page.clickAbc();
    }

    @Then("The second answer correctness is shown")
    public void theSecondAnswerShouldBeMarkedAsCorrect() {
        String styleAttribute = page.getCorrectness_1_1().getAttribute("style");
        assertTrue(styleAttribute.contains("inline"));
    }

    @And("The third answer correctness is shown")
    public void theThirdAnswerShouldBeMarkedAsCorrect() {
        String styleAttribute = page.getCorrectness_2_0().getAttribute("style");
        assertTrue(styleAttribute.contains("inline"));
    }

    @And("The first answer correctness is not shown")
    public void theFirstAnswerCorrectnessIsNotShown() {
        String styleAttribute = page.getCorrectness_1_0().getAttribute("style");
        assertTrue(styleAttribute.contains("none"));
    }

    @And("The fourth answer correctness is not shown")
    public void theFourthAnswerCorrectnessIsNotShown() {
        String styleAttribute = page.getCorrectness_2_1().getAttribute("style");
        assertTrue(styleAttribute.contains("none"));
    }
}
