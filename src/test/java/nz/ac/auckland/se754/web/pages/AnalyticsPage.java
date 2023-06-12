package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AnalyticsPage {
    @FindBy(how= How.NAME, using="learningModule")
    private List<WebElement> learningModules;
    @FindBy(how= How.NAME, using="learningModuleProgress")
    private List<WebElement> learningModulesProgress;
    @FindBy(how= How.NAME, using="practiceModule")
    private List<WebElement> practiceModules;
    @FindBy(how= How.NAME, using="practiceModuleProgress")
    private List<WebElement> practiceModulesProgress;
    @FindBy(how=How.ID, using="progressBar")
    private WebElement progressBar;
    public AnalyticsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getProgressBar(){return progressBar;}
    public List<WebElement> getLearningModules(){return learningModules;}
    public List<WebElement> getLearningModulesProgress(){return  learningModulesProgress;}
    public List<WebElement> getPracticeModules(){return practiceModules;}
    public List<WebElement> getPracticeModulesProgress(){return practiceModulesProgress;}
}
