package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="checkBox")
    private WebElement settingsCheckBox;

    @FindBy(how=How.ID, using="saveBtn")
    private WebElement saveButton;

    @FindBy(how=How.ID, using="statusMsg")
    private WebElement statusMessage;

    @FindBy(how=How.ID, using="viewAnalyticsButton")
    private WebElement viewAnalytics;

    public void clickViewAnalytics(){this.viewAnalytics.click();}
    public void clickCheckBox(){
        this.settingsCheckBox.click();
    }

    public void clickSave(){
        this.saveButton.click();
    }

    public String getMessage(){
        return this.statusMessage.getText();
    }

}

