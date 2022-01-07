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

    @Given("^user is in the realtor home page for searching home for buy$")
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

    @When("^user type address \"(.+?)\" inside search box and click search icon$")
    public void typeSearchBoxAndClickSearchTab(String address){
        new Buy(driver)
                .typeAddress(address)
                .clickSearchTabIcon();
    }


    @Then("^user can see all  home for buy in Hicksville, NY$")
    public void userIsNavigatedToNewConstructionBuyHomePage() {
        new Buy(driver)
                .validateHicksvilleHomePage();
    }
}


