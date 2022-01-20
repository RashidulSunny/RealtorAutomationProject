package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Buy;
import page_objects.Home;


public class BuySteps {

    WebDriver driver = Hooks.driver;

    @Given("^the user is on the realtor home page for searching home for buy$")
    public void navigateToHomePageForBuy() {

        new Home(driver)
                .navigateToURLHomePage();

    }

    @And("^user navigate to buy page$")
    public void navigateToBuyPage(){
        new Home(driver)
                .mouseHoverToBuy()
                .navigateToHomeForSale();

    }

    @When("^the user clicks on the search icon upon typing the address \"(.+?)\"$")
    public void typeSearchBoxAndClickSearchTab(String Address){
        new Buy(driver)
                .typeAddress(Address)
                .clickSearchTabIcon();
    }


    @Then("^the user can see all the available homes$")
    public void userIsNavigatedToNewConstructionBuyHomePage() {
        new Buy(driver)
                .validateHomePage();


    }
}


