package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search extends NavigationBar{
    public static final By SearchBoxField = By.xpath("//input[@id='searchbox-input']");
    public static final By SearchIconTab = By.xpath("//button[contains(@aria-label, 'Search')]");
    public static final By HouseLogo = By.xpath("//h1[contains(text(),'11365, NY Real Estate & Homes for Sale')]");
    public static final By ThreeBedTab = By.xpath("//*[@id=\"filter-btn-2066482\"]");
    public static final By ThreeIcon = By.xpath("//label[contains(@aria-label, 'Select 3+ Baths')]");
    public static final By ThreeBedLogo = By.xpath("//*[@id=\"srp-header\"]/div[1]/h1");
    private static final Logger LOGGER = LogManager.getLogger(Search.class);


    public WebDriver driver;
    public Search(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public Search typeZipCode(String zipCode){
        ActOn.element(driver, SearchBoxField).setValues(zipCode);
        LOGGER.debug("User enters zip code " + zipCode);

        return this;
    }
    public Search clickSearchIcon(){
        ActOn.element(driver, SearchIconTab).click();
        LOGGER.debug("User is click on search icon");
        return this;

    }
    public Search clickBedIcon(){
        LOGGER.debug("Mouse Hover to bed tab");
        ActOn.element(driver, ThreeBedTab).mouseHover();
        ActOn.wait(driver,ThreeBedTab).waitForElementLocated();
        ActOn.element(driver, ThreeBedTab).click();

        return this;
    }
    public Search clickThreeIcon(){
        LOGGER.debug("Mouse Hover to three icon");
        ActOn.element(driver, ThreeIcon).mouseHover();
        ActOn.wait(driver,ThreeIcon).waitForElementLocated();
        ActOn.element(driver, ThreeIcon).click();

        return this;
    }

    public Search validateFamilyHomePage(){
        AssertThat.elementassertions(driver, HouseLogo).elementDisplayed();
        LOGGER.debug("User can see all home in this zip code");

        return this;
    }
    public Search validateThreeBedFamilyHomePage(){
        AssertThat.elementassertions(driver, ThreeBedLogo).elementDisplayed();
        LOGGER.debug("User can see all home with 3 bedroom in this zip code");

        return this;
    }

}
