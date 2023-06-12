package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "formEmail")
    private WebElement regEmail;

    @FindBy(how = How.ID, using = "formName")
    private WebElement regName;

    @FindBy(how = How.ID, using = "formPassword")
    private WebElement regPassword;

    @FindBy(how = How.ID, using = "formBtn")
    private WebElement regButton;

    @FindBy(how=How.ID, using="formMsg")
    private WebElement regMessage;

    @FindBy(how=How.ID, using="failMsg")
    private WebElement failMessage;

    public void insertEmail(String email) {
        this.regEmail.sendKeys(email);
    }

    public void insertUserName(String userName) {
        this.regName.sendKeys(userName);
    }

    public void insertPassword(String password) {
        this.regPassword.sendKeys(password);
    }

    public void clickRegister() {
        this.regButton.click();
    }

    public String getSuccessMessage() {
            return this.regMessage.getText();
    }

    public String getFailMessage() {
        return this.failMessage.getText();
    }
}
