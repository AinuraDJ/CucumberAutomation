package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StudyMateLoginPage {

    public StudyMateLoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "email")
    public WebElement emailInputBox;

    @FindBy(name = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//form/button[2]")
    public WebElement loginButton;

    @FindBy(id = "mui-component-select-language")
    public WebElement languageDropdown;

    @FindBy(xpath = "//ul/li")
    public List<WebElement> languageOptions;

    @FindBy(xpath = "//ul/li[2]")
    public WebElement languageEnglish;

    @FindBy(xpath = "//form/button[1]")
    public WebElement forgotPassword;

    @FindBy(xpath = "//div/h2")
    public WebElement loginText;

    public void login(String email, String password) {
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
