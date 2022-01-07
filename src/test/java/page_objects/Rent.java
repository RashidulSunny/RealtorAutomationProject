package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Rent extends NavigationBar{

    public static final By SearchField = By.xpath("//input[@id='searchbox-input']");
    public static final By SearchTab = By.xpath("//button/span[contains(@class, 'search-btn-text')]");
    public static final By QueensNyLogo = By.xpath("//h1[contains(text(),'Queens, NY Rentals - Apartments and Houses for Ren')]");
    private static final Logger LOGGER = LogManager.getLogger(Rent.class);

    public WebDriver driver;
    public Rent(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public Rent typePlace(String place){
        ActOn.element(driver, SearchField).setValues(place);
        LOGGER.debug("User enters place on search box " + place);

        return this;
    }
    public Rent clickSearchTab(){
        ActOn.element(driver, SearchTab).click();
        LOGGER.debug("User is click on search tab");
        return this;

    }
    public Rent validateRentHomePage(){
        AssertThat.elementassertions(driver, QueensNyLogo).elementDisplayed();
        LOGGER.debug("User can see all home for rent in queens, ny");

        return this;
    }



}
