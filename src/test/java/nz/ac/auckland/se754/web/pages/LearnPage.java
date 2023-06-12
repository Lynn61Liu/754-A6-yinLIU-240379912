package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LearnPage {
    private WebDriver driver;
    @FindBy(how = How.ID, using = "text_1")
    private WebElement text_1;

    @FindBy(how = How.ID, using = "text_2")
    private WebElement text_2;

    @FindBy(how = How.ID, using = "text_3")
    private WebElement text_3;

    @FindBy(how = How.ID, using = "image_1")
    private WebElement image_1;

    @FindBy(how = How.ID, using = "image_2")
    private WebElement image_2;

    @FindBy(how = How.ID, using = "image_3")
    private WebElement image_3;

    @FindBy(how = How.ID, using = "video_1")
    private WebElement video_1;

    public LearnPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getText_1() {
        return text_1;
    }

    public WebElement getText_2() {
        return text_2;
    }

    public WebElement getText_3() {
        return text_3;
    }

    public WebElement getImage_1() {
        return image_1;
    }

    public WebElement getImage_2() {
        return image_2;
    }

    public WebElement getImage_3() {
        return image_3;
    }

    public WebElement getVideo_1() {
        return video_1;
    }

}
