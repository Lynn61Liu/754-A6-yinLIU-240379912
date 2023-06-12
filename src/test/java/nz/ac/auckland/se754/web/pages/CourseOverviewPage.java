package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CourseOverviewPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "courseName")
    private WebElement courseName;

    @FindBy(how = How.ID, using = "courseCategory")
    private WebElement courseCategory;

    @FindBy(how = How.ID, using = "courseFormat")
    private WebElement courseFormat;

    @FindBy(how = How.ID, using = "courseTopic")
    private WebElement courseTopic;

    @FindBy(how = How.ID, using = "courseDescription")
    private WebElement courseDescription;

    @FindBy(how = How.ID, using = "difficultyRating")
    private WebElement courseDifficulty;

    @FindBy(how = How.ID, using = "timeEstimate")
    private WebElement courseTime;

    @FindBy(how = How.NAME, using = "learnModule")
    private List<WebElement> learnList;

    @FindBy(how = How.NAME, using = "practiceModule")
    private List<WebElement> practiceList;

    @FindBy(how = How.NAME, using = "courseSyllabus")
    private List<WebElement> courseSyllabus;

    @FindBy(how = How.ID, using = "enrolButton")
    private WebElement enrolButton;

    @FindBy(how = How.ID, using = "enrolledCourseMessage")
    private WebElement enrolledCourseMessage;

    @FindBy(how = How.ID, using = "completed_0")
    private WebElement completed_0;

    @FindBy(how = How.ID, using = "completed_1")
    private WebElement completed_1;

    @FindBy(how = How.ID, using = "completed_2")
    private WebElement completed_2;


    public CourseOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNavButton(String id) {
        return driver.findElement(org.openqa.selenium.By.id(id));
    }


    public List<WebElement> getPracticeList() {
        return practiceList;
    }

    public WebElement getCompleted_0() {
        return completed_0;
    }

    public WebElement getCompleted_1() {
        return completed_1;
    }

    public WebElement getCompleted_2() {
        return completed_2;
    }

    public List<WebElement> getLearnList() {
        return learnList;
    }

    public WebElement getCourseTime() {
        return courseTime;
    }

    public WebElement getCourseDifficulty() {
        return courseDifficulty;
    }

    public WebElement getCourseDescription() {
        return courseDescription;
    }

    public WebElement getCourseTopic() {
        return courseTopic;
    }

    public WebElement getCourseFormat() {
        return courseFormat;
    }

    public WebElement getCourseCategory() {
        return courseCategory;
    }

    public WebElement getCourseName() {
        return courseName;
    }

    public List<WebElement> getCourseSyllabus() {
        return courseSyllabus;
    }

    public WebElement getEnrolButton() {
        return enrolButton;
    }

    public WebElement getEnrolledCourseMessage() {
        return enrolledCourseMessage;
    }
}
