package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;


public class LoginSteps {

    WebDriver driver = Hooks.driver;

    @Given("^user is on the login page and click on Login Link$")
    public void userIsOnTheLoginPageAndClickOnLoginLink() {
        new Home(driver).navigateToURLHomePage()
                        .clickLoginLink();
    }

    @When("^user enters emailAddress \"(.+?)\" and click on continue button$")
    public void userEntersEmailAddressAndClickOnContinueButton(String emailAddress) {
        new Home(driver).typeEmailAddress(emailAddress)
                        .clickContinueButton();
    }

    @And("^user enters password \"(.+?)\" and click on login button$")
    public void userEntersPasswordAndClickOnLoginButton(String password) {
        new Home(driver).typePassword(password)
                        .clickLoginButton();
    }

    @Then("^user is navigated to home page$")
    public void userIsNavigatedToHomePage() {
        new Home(driver).validateHomePage();
    }

    @Then("^user is failed to login$")
    public void validateUnsuccessfulLogin() {
        new Home(driver).validateUnsuccessfulByInvalidCredential();
    }
}
