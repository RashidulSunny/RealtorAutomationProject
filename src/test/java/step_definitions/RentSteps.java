package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.Rent;

public class RentSteps {

    WebDriver driver = Hooks.driver;

    @Given("^user is in the realtor home page for searching home for rent$")
    public void navigateToHomePageForRent() {

        new Home(driver)
                .navigateToURLHomePage();

    }

    @And("^user navigate to rent page$")
    public void navigateToRentPage(){
        new Home(driver)
                .mouseHoverToRent()
                .navigateToApartmentForRent();

    }

    @When("^user type place \"(.+?)\" inside search box and click search button$")
    public void typeOnSearchBoxAndClickSearchIcon(String place){
        new Rent(driver)
                .typePlace(place)
                .clickSearchTab();
    }

    @Then("^user can see all home for rent in Queens, NY$")
    public void userIsNavigatedToRentPage() {
        new Rent(driver)
                .validateRentHomePage();
    }
}
