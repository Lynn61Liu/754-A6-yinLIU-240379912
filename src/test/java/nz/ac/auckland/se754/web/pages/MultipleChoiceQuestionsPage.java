package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MultipleChoiceQuestionsPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "progress")
    private WebElement progress;

    @FindBy(how = How.ID, using = "question1")
    private WebElement booleanIsTheSameAsString;

    @FindBy(how = How.ID, using = "question2")
    private WebElement exampleOfACharacter;

    @FindBy(how = How.ID, using = "answer_1_0")
    private WebElement istrue;

    @FindBy(how = How.ID, using = "answer_1_1")
    private WebElement isfalse;

    @FindBy(how = How.ID, using = "answer_2_0")
    private WebElement a;

    @FindBy(how = How.ID, using = "answer_2_1")
    private WebElement abc;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submit;

    @FindBy(how = How.ID, using = "correctness_1_0")
    private WebElement correctness_1_0;

    @FindBy(how = How.ID, using = "correctness_1_1")
    private WebElement correctness_1_1;

    @FindBy(how = How.ID, using = "correctness_2_0")
    private WebElement correctness_2_0;

    @FindBy(how = How.ID, using = "correctness_2_1")
    private WebElement correctness_2_1;

    public MultipleChoiceQuestionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getBooleanIsTheSameAsString() {
        return booleanIsTheSameAsString;
    }

    public WebElement getExampleOfACharacter() {
        return exampleOfACharacter;
    }

    public WebElement getIstrue() {
        return istrue;
    }

    public WebElement getIsfalse() {
        return isfalse;
    }

    public WebElement getA() {
        return a;
    }

    public WebElement getAbc() {
        return abc;
    }

    public WebElement getCorrectness_1_0() {
        return correctness_1_0;
    }

    public WebElement getCorrectness_1_1() {
        return correctness_1_1;
    }

    public WebElement getCorrectness_2_0() {
        return correctness_2_0;
    }

    public WebElement getCorrectness_2_1() {
        return correctness_2_1;
    }


    public void clickIsTrue() {
        this.istrue.click();
    }

    public void clickIsFalse() {
        this.isfalse.click();
    }

    public void clickA() {
        this.a.click();
    }

    public void clickAbc() {
        this.abc.click();
    }

    public void clickSubmit() {
        this.submit.click();
    }

    public WebElement getProgress() {
        return progress;
    }
}
