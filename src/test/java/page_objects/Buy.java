package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buy extends NavigationBar{

    public static final By SearchFieldForBuy = By.xpath("//input[@id='searchbox-input']");
    public static final By SearchTabIcon = By.xpath("//button[contains(@aria-label, 'Search')]");
    //public static final By HicksvilleNyHomeLogo = By.xpath("//h1[contains(text(),'Hicksville, NY Real Estate & Homes for Sale')]");
    public static final By LogoForValidation = By.xpath("//a/img[@data-testid= 'global-nav-custom']");
    private static final Logger LOGGER = LogManager.getLogger(Buy.class);

    public WebDriver driver;
    public Buy(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public Buy typeAddress(String address){
        ActOn.element(driver, SearchFieldForBuy).setValues(address);
        LOGGER.debug("User enters address on search box " + address);

        return this;
    }
    public Buy clickSearchTabIcon(){
        ActOn.element(driver, SearchTabIcon).click();
        LOGGER.debug("User is click on search tab icon");
        return this;

    }

    public Buy validateHomePage(){
        AssertThat.elementassertions(driver, LogoForValidation).elementDisplayed();
        LOGGER.debug("User can see all new construction home for buy");

        return this;
    }




}
