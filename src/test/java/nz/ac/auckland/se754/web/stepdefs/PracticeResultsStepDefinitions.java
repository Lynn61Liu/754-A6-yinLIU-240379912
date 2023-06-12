package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.PracticeResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeResultsStepDefinitions {
    private WebDriver driver;
    private PracticeResultsPage page;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.page = new PracticeResultsPage(driver);
    }

    @Given("I visit the results of any arbitrary practice session")
    public void iVisitTheResultsOfAPracticeSession() {
        driver.get("http://localhost:8080/practice/777/results");
    }

    @Given("I visit the results of a practice session where I got 4 out of 6 questions correct")
    public void iVisitTheResultsOfAPracticeSessionWhereIGotFourOutOfSixCorrect() {
        driver.get("http://localhost:8080/practice/777/results");
    }

    @When("the practice results page successfully loads")
    public void thePracticeResultsPageSuccessfullyLoads() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/practice/777/results";
        assertEquals(expectedURL, actualURL);
    }

    @Then("there should be a pass or fail result displayed")
    public void thereShouldBeAPassOrFailResultDisplayed() {
        WebElement overallResult = page.getOverallResult();
        assertTrue(overallResult.isDisplayed());
    }

    @Then("there should be a percentage of how many questions I answered correctly")
    public void thereShouldBeAPercentageOfHowManyQuestionsIAnsweredCorrectly() {
        WebElement percentageResult = page.getPercentageResult();
        assertTrue(percentageResult.isDisplayed());
    }

    @And("the percentage should be {double} percent")
    public void thePercentageShouldBePercent(double expectedPercent) {
        String percentageResult = page.getPercentageResult().getText();
        double actualPercentage = Double.parseDouble(percentageResult.substring(0, percentageResult.length()-1));
        assertEquals(expectedPercent, actualPercentage);
    }

    @Then("the questions I got wrong should be listed")
    public void theQuestionsIGotWrongShouldBeListed() {
        List<WebElement> incorrectQuestions = page.getIncorrectQuestions();
        List<String> incorrectQuestionStrings = new ArrayList<>();
        for (WebElement element : incorrectQuestions) {
            incorrectQuestionStrings.add(element.getText());
        }

        List<String> expectedQuestions = new ArrayList<>();
        expectedQuestions.add("A for loop can loop indefinitely");
        expectedQuestions.add("the for loop is the only way to loop");

        boolean isSizeTwo = incorrectQuestions.size() == 2;
        assertTrue(isSizeTwo);
        boolean isSameQuestions = incorrectQuestionStrings.containsAll(expectedQuestions);
        assertTrue(isSameQuestions);
    }

    @And("the answers for those questions are displayed")
    public void theAnswersForThoseQuestionsAreDisplayed() {
        List<WebElement> questionAnswers = page.getQuestionAnswers();
        boolean isSizeTwo = questionAnswers.size() == 2;
        assertTrue(isSizeTwo);

        List<Boolean> expectedAnswers = new ArrayList<Boolean>();
        expectedAnswers.add(false);
        expectedAnswers.add(false);

        for (int i = 0; i < questionAnswers.size(); i++) {
            boolean actualValue = Boolean.parseBoolean(questionAnswers.get(i).getText());
            boolean expectedValue = expectedAnswers.get(i);
            assertEquals(expectedValue, actualValue);
        }
    }

    @When("I click on the retry practice button")
    public void iClickOnTheRetryPracticeButton() {
        page.getRetryButton().click();
    }

    @Then("the page should change to the practice page")
    public void thePageShouldChangeToThePracticePage() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/practice/777";
        assertEquals(expectedURL, actualURL);
    }
}
