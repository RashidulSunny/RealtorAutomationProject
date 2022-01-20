package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.Rent;
import page_objects.Search;

public class RentSteps {

    WebDriver driver = Hooks.driver;

    @Given("^the user is on the realtor home page$")
    public void navigateToHomePageForRent() {

        new Home(driver)
                .navigateToURLHomePage();

    }

    @And("^user navigates to the rent page$")
    public void navigateToRentPage(){
        new Home(driver)
                .mouseHoverToRent()
                .navigateToApartmentForRent();

    }

    @When("^the user clicks on the search button upon typing the address \"(.+?)\"$")
    public void typeOnSearchBoxAndClickSearchIcon(String place){
        new Rent(driver)
                .typePlace(place)
                .clickSearchTab();
    }



    @Then("^the user can see all the available homes to rent$")
    public void userIsNavigatedToRentPage() {
        new Rent(driver)
                .validateRentHomePage();

    }



}
