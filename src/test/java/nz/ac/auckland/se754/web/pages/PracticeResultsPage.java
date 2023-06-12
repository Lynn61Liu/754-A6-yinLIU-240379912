package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PracticeResultsPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using="overallResult")
    private WebElement overallResult;

    @FindBy(how = How.ID, using="percentageResult")
    private WebElement percentageResult;

    @FindBy(how= How.NAME, using ="incorrectQuestion")
    private List<WebElement> incorrectQuestions;

    @FindBy(how= How.NAME, using="questionAnswer")
    private List<WebElement> questionAnswers;

    @FindBy(how= How.ID, using="retryButton")
    private WebElement retryButton;

    public PracticeResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getOverallResult() {
        return overallResult;
    }

    public WebElement getPercentageResult() {
        return percentageResult;
    }

    public List<WebElement> getQuestionAnswers() {
        return questionAnswers;
    }

    public List<WebElement> getIncorrectQuestions() {
        return incorrectQuestions;
    }

    public WebElement getRetryButton() {
        return retryButton;
    }
}
