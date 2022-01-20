package page_objects;


import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

public class Home extends NavigationBar{

    public static final By LogInLink = By.xpath("//a[contains(text(),'Log in')]");
    public static final By Email = By.xpath("//input[@id='raas_email']");
    public static final By Continue = By.xpath("//button[contains(text(),'Continue')]");
    public static final By Password = By.id("raas_password");
    public static final By LoginButton = By.xpath("//button[2][contains(text(),'Login')]");
    public static final By Logo = By.xpath("//body/div//a/img");
    public static final By InvalidPassword = By.id("raas_password_helper");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);


    public WebDriver driver;
    public Home(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public Home navigateToURLHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("RealtorAppURL"));
        LOGGER.debug("Home Page URL is launch");
        return this;
    }


    public Home clickLoginLink(){
        ActOn.element(driver, LogInLink).click();
        LOGGER.debug("User is click on login link");
        return this;
    }

    public Home typeEmailAddress(String emailAddress){
        ActOn.element(driver, Email).setValues(emailAddress);
        LOGGER.debug("User enters email address " + emailAddress);

        return this;
    }
    public Home clickContinueButton(){
        ActOn.element(driver, Continue).click();
        LOGGER.debug("User is click on continue link");
        return this;
    }
    public Home typePassword(String password){
        ActOn.element(driver, Password).setValues(password);
        LOGGER.debug("User enters password " + password);
        return this;
    }
    public Home clickLoginButton(){
        ActOn.element(driver, LoginButton).click();
        LOGGER.debug("User is click on login link");
        return this;
    }

    public Home validateHomePage(){
        AssertThat.elementassertions(driver, Logo).elementDisplayed();
        LOGGER.debug("User is navigated to home page");
        return this;
    }
    public Home validateUnsuccessfulByInvalidCredential(String massage){
        AssertThat.elementassertions(driver, InvalidPassword).elementDisplayed();
        LOGGER.debug("User is still on the login page");
        return this;
    }
}
