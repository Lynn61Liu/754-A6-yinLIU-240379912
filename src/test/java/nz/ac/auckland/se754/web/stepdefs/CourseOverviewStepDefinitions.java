package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.CourseOverviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CourseOverviewStepDefinitions {
    private WebDriver driver;
    private CourseOverviewPage page;

    @Before
    public void setup() {
        this.driver = SharedDriver.getSharedDriverInstance().getDriver();
        this.page = new CourseOverviewPage(driver);
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

    @Given("I visit the course overview page with id {int}")
    public void iVisitTheCourseOverviewPageWithId(int id) {
        driver.get("http://localhost:8080/course/".concat(Integer.toString(id)).concat("/overview"));
    }

    @Then("the correct course overview page is loaded")
    public void theCourseOverviewPageIsDisplayed() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080/course/123456789/overview";
        assertEquals(expectedURL, actualURL);
    }

    @And("the course name is displayed correctly")
    public void theCourseNameIsDisplayedCorrectly() {
        String actualName = page.getCourseName().getText();
        String expectedName = "Intro to Java";
        assertEquals(expectedName, actualName);
    }

    @And("the course category is displayed correctly")
    public void theCourseCategoryIsDisplayedCorrectly() {
        String actualCategory = page.getCourseCategory().getText();
        String expectedCategory = "Java";
        assertEquals(expectedCategory, actualCategory);
    }

    @And("the course description is displayed correctly")
    public void theCourseDescriptionIsDisplayedCorrectly() {
        String actualDescription = page.getCourseDescription().getText();
        String expectedDescription = "This course explains the basic and fundamentals of Java, an object oriented programming " +
                "language. This includes the history of Java, and how to get started on reading some beginner examples.";
        assertEquals(expectedDescription, actualDescription);
    }

    @And("the course format is displayed correctly")
    public void theCourseFormatIsDisplayedCorrectly() {
        String actualFormat = page.getCourseFormat().getText();
        String expectedFormat = "Text";
        assertEquals(expectedFormat, actualFormat);
    }

    @And("the course topic is displayed correctly")
    public void theCourseTopicIsDisplayedCorrectly() {
        String actualTopic = page.getCourseTopic().getText();
        String expectedTopic = "Java Basics";
        assertEquals(expectedTopic, actualTopic);
    }

    @And("all learning modules for the course are displayed correctly")
    public void allLearningModulesForTheCourseAreDisplayedCorrectly() {
        List<WebElement> actualLearningModules = page.getLearnList();
        List<String> actualLearningModuleNames = new ArrayList<String>();

        for (WebElement element : actualLearningModules) {
            actualLearningModuleNames.add(element.getText());
        }

        List<String> expectedLearningModuleNames = new ArrayList<String>();
        expectedLearningModuleNames.add("History of Java");
        expectedLearningModuleNames.add("Java Basic Syntax");
        expectedLearningModuleNames.add("Java Object Theory");

        assertTrue(expectedLearningModuleNames.containsAll(actualLearningModuleNames));
    }

    @And("all practice modules for the course are displayed correctly")
    public void allPracticeModulesForTheCourseAreDisplayedCorrectly() {
        List<WebElement> actualPracticeModules = page.getPracticeList();
        List<String> actualPracticeModuleNames = new ArrayList<String>();

        for (WebElement element : actualPracticeModules) {
            actualPracticeModuleNames.add(element.getText());
        }

        List<String> expectedPracticeModuleNames = new ArrayList<String>();
        expectedPracticeModuleNames.add("Java Facts - 06/07/2023");
        expectedPracticeModuleNames.add("Java Object and Class Practice - 08/07/2023");
        expectedPracticeModuleNames.add("Java Syntax Quiz - 17/07/2023");

        assertTrue(expectedPracticeModuleNames.containsAll(actualPracticeModuleNames));
    }

    @And("the estimated time of the course is displayed correctly")
    public void theEstimatedTimeOfTheCourseIsDisplayedCorrectly() {
        int expectedCourseTime = 115;
        WebElement timeEstimateElement = page.getCourseTime();
        int actualCourseTime = Integer.parseInt(timeEstimateElement.getText());
        assertEquals(expectedCourseTime, actualCourseTime);
    }

    @And("the difficulty rating of the course is displayed correctly")
    public void theDifficultyRatingOfTheCourseIsDisplayedCorrectly() {
        int expectedCourseDifficulty = 2;
        WebElement difficultyElement = page.getCourseDifficulty();
        int actualCourseDifficulty = Integer.parseInt(difficultyElement.getText());
        assertEquals(expectedCourseDifficulty, actualCourseDifficulty);
    }

    @Then("the course syllabus is present")
    public void theCourseSyllabusIsPresent() {
        List<WebElement> courseSyllabus = page.getCourseSyllabus();
        boolean isNotEmpty = courseSyllabus.size() > 0;
        assertTrue(isNotEmpty);
    }

    @And("the course syllabus is ordered correctly")
    public void theCourseSyllabusIsOrderedCorrectly() {
        List<WebElement> courseSyllabus = page.getCourseSyllabus();

        List<String> expectedModuleNames = new ArrayList<String>();
        expectedModuleNames.add("Learning: History of Java");
        expectedModuleNames.add("Practice: Java Facts");
        expectedModuleNames.add("Learning: Java Basic Syntax");
        expectedModuleNames.add("Practice: Java Syntax Quiz");
        expectedModuleNames.add("Learning: Java Object Theory");
        expectedModuleNames.add("Practice: Java Object and Class Practice");

        boolean sameSize = courseSyllabus.size() == expectedModuleNames.size();
        assertTrue(sameSize);

        for (int i = 0; i < courseSyllabus.size(); i++) {
            String actualName = courseSyllabus.get(i).getText();
            String expectedName = expectedModuleNames.get(i);
            assertEquals(expectedName, actualName);
        }
    }

    @And("I click on the enrol in course button")
    public void iClickOnTheEnrolInCourseButton() {
        page.getEnrolButton().click();
    }

    @Then("the course is added to my enrolled courses")
    public void theCourseIsAddedToMyEnrolledCourses() {
        WebElement successMessage = page.getEnrolledCourseMessage();
        assertTrue(successMessage.isDisplayed());
    }

    @And("I click the {string} course overview")
    public void userClicksIntoCourseOverview(String courseName) {
        driver.findElement(By.id("navigateToCourseOverview")).click();
    }

    @Then("the practice list is displayed in order of dates")
    public void thePracticeListIsDisplayedInOrderOfDates() {
        List<WebElement> practiceList = page.getPracticeList();
        List<String> practiceListNames = new ArrayList<String>();

        for (WebElement element : practiceList) {
            practiceListNames.add(element.getText());
        }

        List<String> expectedPracticeListNames = new ArrayList<String>();
        expectedPracticeListNames.add("Java Facts - 06/07/2023");
        expectedPracticeListNames.add("Java Object and Class Practice - 08/07/2023");
        expectedPracticeListNames.add("Java Syntax Quiz - 17/07/2023");

        System.out.println(practiceListNames);
        assertEquals(expectedPracticeListNames, practiceListNames);
    }

    @Then("the course progress is displayed correctly")
    public void theCourseProgressIsDisplayedCorrectly() {
        WebElement completed0 = page.getCompleted_0();
        WebElement completed1 = page.getCompleted_1();
        WebElement completed2 = page.getCompleted_2();
        assertEquals("completed", completed0.getText());
        assertEquals("completed", completed1.getText());
        assertEquals("completed", completed2.getText());
    }


    @When("I click on the navigate {string}")
    public void i_click_on_the_navigate(String button) {
        page.getNavButton(button).click();
    }
    @Then("the correct learning module page is loaded with the correct {string}")
    public void the_correct_learning_module_page_is_loaded_with_the_correct(String link) {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://localhost:8080" + link;
        assertEquals(expectedURL, actualURL);
    }
}

