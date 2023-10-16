package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.StudyMateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class StudyMateLoginSteps {
    WebDriver driver = Driver.getDriver();
    StudyMateLoginPage loginPage = new StudyMateLoginPage();

    @Given("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        driver.get(Config.getProperty("studyMateURL"));
        Assert.assertEquals("StudyMate",driver.getTitle());
        System.out.println("user is navigated to StudyMate login page");
    }

    @When("user enters email {string} to the email field")
    public void user_enters_email_to_the_email_field(String email) {
        loginPage.emailInput.sendKeys(email);
        System.out.println("user enters email: " + Config.getProperty("email"));
    }

    @When("user enters password {string} to the password field")
    public void user_enters_password_to_the_password_field(String password) {
        loginPage.passwordInput.sendKeys(password);
        System.out.println("user enters password: " + Config.getProperty("password"));
    }

    @Then("user performs click action on the login button")
    public void user_performs_click_action_on_the_login_button() {
        loginPage.loginButton.click();
        ApplicationFlow.pause(3000);
        System.out.println("user clicked login button");
    }

//    @Then("user should be logged to the application")
//    public void user_should_be_logged_to_the_application() {
//        String expectedUrl = "https://codewiser.studymate.us/admin/analytics";
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals("user couldn't log in", expectedUrl,currentUrl);
//        System.out.println("User successfully logged in");
//    }
//
//    @Then("user should not be logged in to the application")
//    public void user_should_not_be_logged_in_to_the_application() {
//        String expectedUrl = "https://codewiser.studymate.us/login";
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals("user could log in", expectedUrl,currentUrl);
//        System.out.println("User fail in logged in");
//    }
    @Then("user should see error message")
    public void user_should_see_error_message() {
        String expectedError = "Email is not valid!";
        String actualError = loginPage.emailNotValidError.getText();
        System.out.println("actual error text is: " + actualError);
        Assert.assertEquals("error message is not displayed", actualError,expectedError);
        System.out.println("Expected error displayed");
    }



}
