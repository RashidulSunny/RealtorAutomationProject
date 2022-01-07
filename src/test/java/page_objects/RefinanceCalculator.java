package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RefinanceCalculator extends NavigationBar{

    public static final By OriginalLoanAmountField = By.id("original_loan_amount");
    public static final By OriginalLoanRateField = By.id("original_rate");
    public static final By CurrentBalanceField = By.xpath("//input[@id='current_balance']");
    public static final By NewLoanRateField = By.xpath("//input[@id='refinance_rate']");
    public static final By NewMonthlyPayment = By.xpath("//*[@id=\"__next\"]/div/div[1]/section/div[1]/article[3]/section/article/article/dl[2]/dd[2]");
    private static final Logger LOGGER = LogManager.getLogger(RefinanceCalculator.class);


    public WebDriver driver;

    public RefinanceCalculator(WebDriver driver){
        super(driver);

        this.driver = driver;
    }

    public RefinanceCalculator typeOriginalLoanAmount(String OriginalLoanAmount){
        ActOn.element(driver, OriginalLoanAmountField).setValues(OriginalLoanAmount);
        LOGGER.debug("User enters original loan amount " + OriginalLoanAmount);
        return this;
    }
    public RefinanceCalculator typeOriginalLoanRate(String OriginalLoanRate){
        ActOn.element(driver, OriginalLoanRateField).setValues(OriginalLoanRate);
        LOGGER.debug("User enters original loan rate " + OriginalLoanRate);
        return this;
    }
    public RefinanceCalculator typeCurrentBalance(String CurrentBalance){
        ActOn.element(driver, CurrentBalanceField).setValues(CurrentBalance);
        LOGGER.debug("User enters current balance amount " + CurrentBalance);
        return this;
    }

    public RefinanceCalculator typeNewLoanRate(String NewLoanRate){
        ActOn.element(driver, NewLoanRateField).setValues(NewLoanRate);
        LOGGER.debug("User enters new loan rate " + NewLoanRate);
        return this;
    }
    public RefinanceCalculator newMonthlyPayment(String newMonthlyPayment){
        AssertThat.elementassertions(driver, NewMonthlyPayment).elementDisplayed();
        LOGGER.debug("User can see new monthly payment after refinancing");
        return this;
    }
}
