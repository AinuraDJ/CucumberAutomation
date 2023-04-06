package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.StudyMateHomePage;
import pages.StudyMateLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

import java.util.Random;

public class StudyMateDeleteGroup_steps {

    StudyMateLoginPage loginPage=new StudyMateLoginPage();
    StudyMateHomePage studyMateHomePage=new StudyMateHomePage();


    @Given("user is on studyMate application")
    public void user_is_on_study_mate_application() {
        Driver.getDriver().get(Config.getValue("studyMateURL"));

    }
    @When("user enters valid admin credentials {string} and {string} and clicks login")
    public void user_enters_valid_admin_credentials_and_and_clicks_login(String email, String password) {
        loginPage.emailInputBox.sendKeys(email);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.loginButton.click();
    }
    @Then("user should successfully login to studyMate application")
    public void user_should_successfully_login_to_study_mate_application() {
        String expectedUrl="https://codewise.studymate.us/login";
        String url=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,url);

    }
    @When("user navigates and clicks on three dots on the Group page")
    public void user_navigates_and_clicks_on_three_dots_on_the_group_page() {
        Flow.wait(1000);
        Random random=new Random();
        int index = random.nextInt(studyMateHomePage.threeDotsBtn.size());
        Flow.wait(500);
        studyMateHomePage.threeDotsBtn.get(index).click();
        Flow.wait(500);

    }
    @Then("user should be able to see the delete button is displayed  and enabled")
    public void user_should_be_able_to_see_the_three_dots_button_is_displayed_and_enabled() {
        studyMateHomePage.deleteGroupBtn.click();
        Assert.assertTrue(studyMateHomePage.deleteGroupBtn.isDisplayed());
        Assert.assertTrue(studyMateHomePage.deleteGroupBtn.isEnabled());

    }

    @When("Delete confirmation popped up and user sees cancel and delete buttons are displayed and enabled")
    public void delete_confirmation_popped_up_and_user_sees_cansel_and_delete_buttons_are_displayed_and_enabled() {
        Flow.wait(500);
        Random random = new Random();
        int index = random.nextInt(studyMateHomePage.threeDotsBtn.size());
        Flow.wait(500);
      //  studyMateHomePage.threeDotsBtn.get(index).click();
        Flow.wait(500);
        Assert.assertTrue(studyMateHomePage.cancelBtn.isDisplayed());
        Assert.assertTrue(studyMateHomePage.cancelBtn.isEnabled());
        studyMateHomePage.cancelBtn.click();
    }

    @Then("user clicks on Delete confirmation and should be able sees that group was successfully deleted")
    public void userClicksOnDeleteConfirmationAndShouldBeAbleSeesThatGroupWasSuccessfullyDeleted() {
        int beforeResult=studyMateHomePage.getTotalGroups();
        Random random=new Random();
        int index = random.nextInt(studyMateHomePage.threeDotsBtn.size());
        Flow.wait(2000);
        studyMateHomePage.threeDotsBtn.get(index).click();
        Flow.wait(2000);
        studyMateHomePage.deleteGroupBtn.click();
        studyMateHomePage.deleteBtn.click();
        Flow.wait(3000);
        System.out.println(studyMateHomePage.getTotalGroups());
        int afterResult=studyMateHomePage.getTotalGroups();
        Assert.assertEquals(beforeResult-1,afterResult);


    }
}
