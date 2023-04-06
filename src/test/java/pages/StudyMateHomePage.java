package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StudyMateHomePage {

    public StudyMateHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button)[2]")
    public List<WebElement> threeDotsBtn;


    @FindBy(xpath = "(//ul)[2]/li[2]")
    public WebElement deleteGroupBtn;

    @FindBy(xpath = "(//div/button)[7]")
    public WebElement cancelBtn;

    @FindBy(xpath = "(//div/button)[8]")
    public WebElement deleteBtn;

    @FindBy(xpath = "//p[.='pagination.show']/../p[2]")
    public WebElement pagination;

    public int getTotalGroups(){
        String totalResultStr = pagination.getText();
        String totalNumberStr = totalResultStr.substring(totalResultStr.indexOf(" ")+1);
        int totalNumberInt = Integer.parseInt(totalNumberStr.trim());
        return totalNumberInt;
    }
}

