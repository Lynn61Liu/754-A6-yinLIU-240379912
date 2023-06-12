package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AchievementsPage {
    @FindBy(how= How.NAME, using ="achievement")
    private List<WebElement> achievementsList;
    @FindBy(how= How.NAME, using ="achievementStates")
    private List<WebElement> achievementStateList;
    @FindBy(how= How.ID, using ="achievementPageTitle")
    private WebElement achievementPageTitle;
    @FindBy(how= How.ID, using="viewAchievedButton")
    private WebElement viewAchievedButton;
    @FindBy(how= How.ID, using="viewUnachievedButton")
    private WebElement viewUnachievedButton;

    public AchievementsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public List<WebElement> getAchievementsList() { return achievementsList; }
    public List<WebElement> getAchievementStateList() { return achievementStateList; }

    public WebElement getAchievementPageTitle() {
        return achievementPageTitle;
    }
    public WebElement getViewAchievedButton() {
        return viewAchievedButton;
    }
    public WebElement getViewUnachievedButton() {return viewUnachievedButton;}

}
