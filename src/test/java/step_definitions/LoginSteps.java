package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;


public class LoginSteps {

    WebDriver driver = Hooks.driver;

    @Given("^user is on the login page$")
    public void userIsOnTheLoginPage() {
        new Home(driver)
                        .navigateToURLHomePage();

    }
    @And("^the user clicks on the login link$")
    public void userClickOnLoginLink(){
        new Home(driver)
                        .clickLoginLink();

    }

    @When("^the user clicks on the continue button upon entering the email \"(.+?)\"$")
    public void userEntersEmailAddressAndClickOnContinueButton(String emailAddress) {
        new Home(driver).typeEmailAddress(emailAddress)
                        .clickContinueButton();
    }

    @And("^the user clicks on the login button upon entering the password \"(.+?)\"$")
    public void userEntersPasswordAndClickOnLoginButton(String password) {
        new Home(driver).typePassword(password)
                        .clickLoginButton();
    }

    @Then("^the user is successfully logged in$")
    public void userIsNavigatedToHomePage() {
        new Home(driver).validateHomePage();
    }

    @Then("^Then the user is failed to log in due to the error \"(.+?)\"$")
    public void validateUnsuccessfulLogin(String massage) {
        new Home(driver).validateUnsuccessfulByInvalidCredential(massage);
    }
}
