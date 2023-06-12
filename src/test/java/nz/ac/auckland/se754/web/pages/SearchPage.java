package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ArrayList;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.CLASS_NAME, using ="search-input")
    private WebElement searchKey;
    @FindBy(how=How.ID, using ="message")
    private WebElement message;

    @FindBy(how=How.ID, using="searchbtn")
    private WebElement searchbtn;


    public void insertSearchInput(String keyword){
        this.searchKey.sendKeys(keyword);
    }

    public String getMessage(){
        return this.message.getText();
    }

    public void clickSearchBtn(){
        searchbtn.click();
    }


    //filter category

    @FindBy(how=How.ID, using="CategoryP")
    private WebElement ProgrammingBtn;
    @FindBy(how=How.ID, using="CategoryS")
    private WebElement SystemsBtn;
    @FindBy(how=How.ID, using="CategoryR")
    private WebElement RoboticsBtn;
    @FindBy(how=How.ID, using="Category")
    private WebElement BootCampBtn;

    @FindBy(how=How.ID, using="productsContainer")
    private WebElement productsContainer;
    @FindBy(how=How.CLASS_NAME, using="product")
    private List<WebElement> courseItems;


        public void clickcategoryBtn(String btnName) {
            switch (btnName) {
                case "programming":
                    ProgrammingBtn.click();
                    break;
                case "Systems":
                    SystemsBtn.click();
                    break;
                case "Robotics":
                    RoboticsBtn.click();
                    break;
                case "BootCamp":
                    BootCampBtn.click();
                    break;
                default:
                    System.out.println("no find");
                    break;
            }
        }

    public int getContainerNum() {
        return courseItems.size();
    }


    //sort features
    @FindBy(how=How.ID, using="sortBtn")
    private WebElement sortBtn;
    @FindBy(how=How.CLASS_NAME, using="courseName")
    private List<WebElement> courseName;

    public void clickSortBtn(){
        sortBtn.click();
    }

public List<String> getOrderCoursesName(){
    List<String> courseNamesList = new ArrayList<>();
    for (WebElement c : courseName) {
        String courseName = c.getText();
        courseNamesList.add(courseName);
    }
    return courseNamesList;

}


}

