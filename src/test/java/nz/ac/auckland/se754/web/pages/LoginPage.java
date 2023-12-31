package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using ="name")
    private WebElement userName;

    @FindBy(how=How.ID, using="password")
    private WebElement password;

    @FindBy(how=How.ID, using="submitbtn")
    private WebElement submitButton;

    @FindBy(how=How.ID, using="message")
    private WebElement message;

    public void insertUserName(String userName){
        this.userName.sendKeys(userName);
    }

    public void insertPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        this.submitButton.click();
    }

    public String getMessage(){
        return this.message.getText();
    }

    @FindBy(how=How.ID, using ="FAQLink")
    private WebElement FAQLink;


    public void clickFQA(){
        FAQLink.click();
    }


    @FindBy(how=How.ID, using ="search")
    private WebElement searchInput;
    @FindBy(how=How.ID, using ="searchBtn")
    private WebElement searchBtn;

    public void insertSearchInput(String keyword){
        this.searchInput.sendKeys(keyword);
    }




    public void clickSearchBtn(){
        searchBtn.click();
    }




}

