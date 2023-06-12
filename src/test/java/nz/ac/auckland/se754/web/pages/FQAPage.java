package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FQAPage {

    public FQAPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using ="btn_1")
    private WebElement btn1;

    @FindBy(how=How.ID, using="btn_2")
    private WebElement btn2;

    @FindBy(how=How.ID, using="btn_3")
    private WebElement btn3;

    @FindBy(how=How.ID, using="text_1")
    private WebElement text1;
    @FindBy(how=How.ID, using="text_2")
    private WebElement text2;
    @FindBy(how=How.ID, using="text_3")
    private WebElement text3;


    public void clickBtn(String btnName) {
        switch (btnName) {
            case "btn_1":
                btn1.click();
                break;
            case "btn_2":
                btn2.click();
                break;
            case "btn_3":
                btn3.click();
                break;
            default:
                System.out.println("no find");
                break;
        }
    }


        public String textDisplay(String textID) {
            String displayValue = "";

            switch (textID) {
                case "text_1":
                    displayValue = text1.getCssValue("display");
                    break;
                case "text_2":
                    displayValue = text2.getCssValue("display");
                    break;
                case "text_3":
                    displayValue = text3.getCssValue("display");
                    break;
                default:
                    System.out.println("no find");
                    break;
            }

            return displayValue;
        }



}

