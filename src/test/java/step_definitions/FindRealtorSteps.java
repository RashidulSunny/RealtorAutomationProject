package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.*;


public class FindRealtorSteps {

    WebDriver driver = Hooks.driver;

    @Given("^user is in the realtor home page for searching a realtor agent for sell a property$")
    public void navigateToHomePageForFindRealtor() {

        new Home(driver)
                .navigateToURLHomePage();

    }

    @And("^user navigate to real estate agent page$")
    public void navigateToFindRealtorAgentPage(){
        new Home(driver)
                .mouseHoverToFindRealtors()
                .navigateToSearchForRealEstateAgent();

    }

    @When("^user type home address \"(.+?)\" inside search box and click search button$")
    public void typeSearchAndClickIcon(String homeAddress){
        new FindRealtor(driver)
                .typeHomeAddress(homeAddress)
                .clickOnSearch();

    }


    @Then("^user can see real estate agent$")
    public void validateRealtorAgent() {
        new FindRealtor(driver)
                .validateRealtorAgent();

    }

}
