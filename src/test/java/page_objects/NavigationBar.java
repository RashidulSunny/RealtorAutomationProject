package page_objects;


import command_provider.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationBar {

    public final By mortgageLink = By.linkText("Mortgage");
    public final By mortgageCalculatorLink = By.linkText("Mortgage Calculator");
    public final By refinanceCalculatorLink = By.linkText("Refinance Calculator");
    public final By buyLink = By.linkText("Buy");
    public final By homeForSaleLink = By.linkText("Homes For Sale");
    public final By rentLink = By.linkText("Rent");
    public final By apartmentForRentLink = By.linkText("Apartments For Rent");
    public final By findRealtorLink = By.xpath("//a[contains(@aria-label, 'Navigation Find Realtors® link' )]");
    public final By searchForRealEstateAgentLink = By.linkText("Search For Real Estate Agent");


    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);


    public WebDriver driver;

    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }
    public NavigationBar mouseHoverToMortgage(){
        LOGGER.debug("Mouse Hover to Mortgage Link");
        ActOn.element(driver, mortgageLink).mouseHover();
        ActOn.wait(driver,mortgageLink).waitForElementLocated();
        return this;
    }

    public NavigationBar mouseHoverMortgageCalculator(){
        LOGGER.debug("Mouse Hover to Mortgage Calculator Page");
        ActOn.element(driver, mortgageCalculatorLink).mouseHover();
        ActOn.wait(driver,mortgageCalculatorLink).waitForElementLocated();
        return this;

    }
    public NavigationBar mouseHoverRefinanceCalculator(){
        LOGGER.debug("Mouse Hover to Refinance Calculator Page");
        ActOn.element(driver, refinanceCalculatorLink).mouseHover();
        ActOn.wait(driver,refinanceCalculatorLink).waitForElementLocated();
        return this;

    }
    public MortgageCalculator navigateToMortgagePage(){
        ActOn.element(driver, mortgageCalculatorLink).click();
        LOGGER.debug("Navigate to Mortgage Calculator Page");
        return new MortgageCalculator(driver);
    }
    public MortgageCalculator navigateToRefinancePage(){
        ActOn.element(driver, refinanceCalculatorLink).click();
        LOGGER.debug("Navigate to Refinance Calculator Page");
        return new MortgageCalculator(driver);
    }

    public NavigationBar mouseHoverToBuy(){
        LOGGER.debug("Mouse Hover to Buy Link");
        ActOn.element(driver, buyLink).mouseHover();
        ActOn.wait(driver,buyLink).waitForElementLocated();
        return this;
    }
    public Buy navigateToHomeForSale(){
        LOGGER.debug("Navigate to Home For Sale Page");
        ActOn.element(driver, homeForSaleLink).mouseHover();
        ActOn.wait(driver,homeForSaleLink).waitForElementLocated();
        ActOn.element(driver, homeForSaleLink).click();
        return new Buy(driver);

    }
    public NavigationBar mouseHoverToRent(){
        LOGGER.debug("Mouse Hover to Rent Link");
        ActOn.element(driver, rentLink).mouseHover();
        ActOn.wait(driver,rentLink).waitForElementLocated();
        return this;
    }
    public Rent navigateToApartmentForRent(){
        LOGGER.debug("Navigate to Apartment For Rent Page");
        ActOn.element(driver, apartmentForRentLink).mouseHover();
        ActOn.wait(driver,apartmentForRentLink).waitForElementLocated();
        ActOn.element(driver, apartmentForRentLink).click();
        return new Rent(driver);

    }
    public NavigationBar mouseHoverToFindRealtors(){
        LOGGER.debug("Mouse Hover to Find Realtor Link");
        ActOn.element(driver, findRealtorLink).mouseHover();
        ActOn.wait(driver,findRealtorLink).waitForElementLocated();
        return this;
    }
    public FindRealtor navigateToSearchForRealEstateAgent(){
        LOGGER.debug("Navigate to Search For Real Estate Agent Page");
        ActOn.element(driver, searchForRealEstateAgentLink).mouseHover();
        ActOn.wait(driver,searchForRealEstateAgentLink).waitForElementLocated();
        ActOn.element(driver, searchForRealEstateAgentLink).click();
        return new FindRealtor(driver);

    }


}
