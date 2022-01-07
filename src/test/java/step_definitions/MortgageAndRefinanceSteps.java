package step_definitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.MortgageCalculator;
import page_objects.RefinanceCalculator;

import java.util.List;
import java.util.Map;

public class MortgageAndRefinanceSteps {

    WebDriver driver = Hooks.driver;



    @Given("^user is in the realtor home page for searching mortgage calculator$")
    public void navigateToRealtorHomePage() {

        new Home(driver)
                .navigateToURLHomePage();

    }
    @Given("^user is in the realtor home page for searching refinance calculator$")
    public void navigateToHomePage() {

        new Home(driver)
                .navigateToURLHomePage();

    }

    @And("^user navigate to mortgage page$")
    public void navigateToMortgageCalculatorPage(){
        new Home(driver)
                .mouseHoverToMortgage()
                .mouseHoverMortgageCalculator()
                .navigateToMortgagePage();


    }
    @And("^user navigate to refinance page$")
    public void navigateToRefinanceCalculatorPage(){
        new Home(driver)
                .mouseHoverToMortgage()
                .mouseHoverRefinanceCalculator()
                .navigateToRefinancePage();



    }


    @When("^user can see the monthly mortgage payment upon entering the data$")
    public void calculateMonthlyPayment(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : data) {
            new MortgageCalculator(driver)
                    .typeHomePrice(cells.get("HomePrice"))
                    .typeDownPayment(cells.get("DownPayment"))
                    .typeInterestRate(cells.get("InterestRate"))
                    .typePropertyTax(cells.get("PropertyTax"));


        }
    }
    @When("^user can see the new monthly payment upon entering the data$")
    public void newMonthlyPayment(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : data) {
            new RefinanceCalculator(driver)
                    .typeOriginalLoanAmount(cells.get("OriginalLoanAmount"))
                    .typeOriginalLoanRate(cells.get("OriginalLoanRate"))
                    .typeCurrentBalance(cells.get("CurrentBalance"))
                    .typeNewLoanRate(cells.get("NewLoanRate"));
        }
    }

    @Then("^The monthly mortgage payment is \"(.+?)\"$")
    public void validateMonthlyMortgagePayment(String monthlyPayment) {
        new MortgageCalculator(driver)
                .monthlyMortgagePayment(monthlyPayment);

    }
    @Then("^The new monthly payment after refinancing is \"(.+?)\"$")
    public void validateNewMonthlyPayment(String newMonthlyPayment) {
        new RefinanceCalculator(driver)
                .newMonthlyPayment(newMonthlyPayment);

    }


}
