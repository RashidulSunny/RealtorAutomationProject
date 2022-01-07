package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.Search;

public class SortingSteps {
    WebDriver driver = Hooks.driver;


    @Given("^user is in home page for searching house$")
    public void navigateToHomePageForSearch() {
        new Home(driver)
                .navigateToURLHomePage();

    }

    @When("^user enter zip code \"(.+?)\" on search text box and click on search icon$")
    public void clickOnSearchIcon(String searchBox) {
        new Search(driver)
                .typeZipCode(searchBox)
                .clickSearchIcon();

    }

    @And("^user click on bed tab and select 3 bedroom$")
    public void clickOnBedTab(){
        new Search(driver)
                .clickBedIcon();

    }

    @Then("^user can see all newest listings home$")
    public void validateFamilyHome() {
        new Search(driver)
                .validateFamilyHomePage();

    }
    @Then("^user can see home with 3 bedroom$")
    public void validateThreeBedFamilyHome() {
        new Search(driver)
                .validateThreeBedFamilyHomePage();

    }

}
