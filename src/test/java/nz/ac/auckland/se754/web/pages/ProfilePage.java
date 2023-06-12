package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="pSectionOne")
    private WebElement profileSectionOne;

    @FindBy(how=How.ID, using="pSectionTwo")
    private WebElement profileSectionTwo;

    @FindBy(how=How.ID, using="pVisCheck")
    private WebElement pVisibilityCheck;

    @FindBy(how=How.ID, using="saveBtn")
    private WebElement saveButton;

    @FindBy(how=How.ID, using="statusMsg")
    private WebElement statusMessage;

    public void checkProfileSectionOne(){
        this.profileSectionOne.click();
    }

    public void checkProfileSectionTwo(){
        this.profileSectionTwo.click();
    }

    public void checkProfileVisibility(){
        this.pVisibilityCheck.click();
    }

    public void clickSave(){
        this.saveButton.click();
    }

    public void clickSaveVisibility(){
        this.saveButton.click();
    }

    public String getMessage(){
        return this.statusMessage.getText();
    }

}