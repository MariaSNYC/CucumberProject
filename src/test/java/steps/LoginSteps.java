package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {
    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        initializePageObjects();
    }

    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("the user leaves the username field empty")
    public void the_user_leaves_the_username_field_empty() {

    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        click(loginPage.loginButton);
    }
    @Then("the error message about the username should be displayed")
    public void the_error_message_about_the_username_should_be_displayed() {
        String actualMessage=loginPage.errorMessage.getText();
        Assert.assertEquals("Username cannot be empty",actualMessage);
        loginPage.errorMessage.isDisplayed();
    }

    @When("the user enters a valid username")
    public void the_user_enters_a_valid_username() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
    }

    @When("the user leaves the password field empty")
    public void the_user_leaves_the_password_field_empty() {

    }

    @Then("the error message about the password should be displayed")
    public void the_error_message_about_the_password_should_be_displayed() {
        String actualMessage=loginPage.errorMessage.getText();
        Assert.assertEquals("Password is Empty",actualMessage);
        loginPage.errorMessage.isDisplayed();
    }
    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        sendText("admin", loginPage.usernameField);
        sendText("Hum@h", loginPage.passwordField);
    }

    @Then("the error message about invalid credentials should be displayed")
    public void the_error_message_about_invalid_credentials_should_be_displayed() {
        String actualMessage=loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials",actualMessage);
        loginPage.errorMessage.isDisplayed();
    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @Then("user is navigated to dashboard page")
    public void user_is_navigated_to_dashboard_page() {
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());

    }



}
