package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FindRealtor extends NavigationBar {

    public static final By textField = By.xpath("//input[@id='autocomplete-input']");
    public static final By searchBox = By.xpath("//button/span[text()='Get Started']");
    public static final By validateRealEstateAgentPage = By.xpath("//body/div//a/img");


    private static final Logger LOGGER = LogManager.getLogger(Rent.class);


    public WebDriver driver;

    public FindRealtor(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public FindRealtor typeHomeAddress(String homeAddress) {
        ActOn.element(driver, textField).setValues(homeAddress);
        LOGGER.debug("User enters home address on search box " + homeAddress);

        return this;
    }

    public FindRealtor clickOnSearch() {
        ActOn.element(driver, searchBox).mouseHover();
        ActOn.wait(driver,searchBox).waitForElementLocated();
        ActOn.element(driver, searchBox).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        LOGGER.debug("User is click on search tab");
        return this;

    }


    public FindRealtor validateRealtorAgent(){
        AssertThat.elementassertions(driver, validateRealEstateAgentPage).elementDisplayed();
        LOGGER.debug("User can see real estate agent");

        return this;
    }


}
