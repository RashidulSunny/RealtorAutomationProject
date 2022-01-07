package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MortgageCalculator extends NavigationBar{

    public static final By HomePriceField = By.xpath("//input[@id='homePrice']");
    public static final By DownPaymentField = By.id("downPayment");
    public static final By InterestRateField = By.id("interestRate");
    public static final By PropertyTaxField = By.id("propertyTaxes");
    public static final By MonthlyMortgagePayment = By.xpath("//*[@id=\"tabpanel-0\"]/div/div[1]/span");
    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculator.class);

    public WebDriver driver;

    public MortgageCalculator(WebDriver driver){
        super(driver);

        this.driver = driver;
    }

    public MortgageCalculator typeHomePrice(String HomePrice){
        ActOn.element(driver, HomePriceField).setValues(HomePrice);
        LOGGER.debug("User enters home price " + HomePrice);
        return this;
    }
    public MortgageCalculator typeDownPayment(String DownPayment){
        ActOn.element(driver, DownPaymentField).setValues(DownPayment);
        LOGGER.debug("User enters down payment " + DownPayment);
        return this;
    }
    public MortgageCalculator typeInterestRate(String InterestRate){
        ActOn.element(driver, InterestRateField).setValues(InterestRate);
        LOGGER.debug("User enters interest rate " + InterestRate);
        return this;
    }
    public MortgageCalculator typePropertyTax(String PropertyTax){
        ActOn.element(driver, PropertyTaxField).setValues(PropertyTax);
        LOGGER.debug("User enters property tax " + PropertyTax);
        return this;
    }
    public MortgageCalculator monthlyMortgagePayment(String monthlyPayment){
        AssertThat.elementassertions(driver, MonthlyMortgagePayment).elementDisplayed();
        LOGGER.debug("User can see total monthly mortgage payment");
        return this;
    }


}
