package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Properties;

import static Testcases.BaseTest.Prop;

public class LoginPage {

    public static WebDriver driver;

    public LoginPage(WebDriver driver)
    {

        this.driver = driver;
    }


    @FindBy(xpath = "//input[@value='Accept']")
    public static WebElement BtnWarningAccept;


    @FindBy(id = "PlaceHolderMain_pnlPassword_UserName")
    public static WebElement TxtboxUserName;


    @FindBy(id = "PlaceHolderMain_pnlPassword_password")
    public static WebElement TxtboxPasword;


    @FindBy(xpath = "//input[@value='Continue']")
    public static WebElement BtnLoginContinue;

    @FindBy(id = "PlaceHolderMain_pnlPin_password")
    public static WebElement TxtboxPin;

    @FindBy(xpath = "//input[@value='Login']")
    public static WebElement BtnLogin;

    @FindBy(xpath = "//input[@value='Accept']")
    public static WebElement BtnRulesAccept;

    @FindBy(xpath = "//input[@value='Accept']")
    public static WebElement BtnPolicyAccept;

    @FindBy(xpath = ".//*[@id='Personal Information']")
    public static WebElement BtnPIBegin;

    @FindBy(xpath="//span[text()='Before You Begin']")
    public static WebElement BtnBegin;

    @FindBy(id="eods-aboutme-tab")
    public static WebElement BtnAboutMe;

    @FindBy(xpath = "//button[@class='hamburger']")
    public static WebElement HbMenu;

    @FindBy(xpath = "//span[contains(text(),'Important Message for')]")
    public static WebElement IntroMessage;

    //ACCEPT LOGIN WARNING
    public LoginPage AcceptWarning()
    {

        WebDriverWait AcceptWait = new WebDriverWait(driver,60);
        AcceptWait.until(ExpectedConditions.elementToBeClickable(BtnWarningAccept));
        BtnWarningAccept.click();
        System.out.println("1. Warning Accepted");
        Reporter.log("1. Warning Accepted");
        return  this;

    }

    //ENTER USER NAME
    public LoginPage EnterUserName(String UserName)
    {
        WebDriverWait UsernameWait = new WebDriverWait(driver,60);
        UsernameWait.until(ExpectedConditions.elementToBeClickable(TxtboxUserName));

        TxtboxUserName.sendKeys(UserName);
        System.out.println("2. Username Entered");
        Reporter.log("2. Username Entered");

        return this;

    }

    //ENTER PASSWORD
    public void EnterPassword(String Pwd)
    {
        WebDriverWait PasswordWait = new WebDriverWait(driver,60);
        PasswordWait.until(ExpectedConditions.elementToBeClickable(TxtboxPasword));

        TxtboxPasword.sendKeys(Pwd);
        System.out.println("3. Password Entered");
        Reporter.log("3. Password Entered");


    }

    //CLICK ON CONTINUE BUTTON
    public LoginPage LoginContinue()
    {
        WebDriverWait BtnContinueWait = new WebDriverWait(driver,60);
        BtnContinueWait.until(ExpectedConditions.elementToBeClickable(BtnLoginContinue));

        BtnLoginContinue.click();
        System.out.println("4. Continue Click");
        Reporter.log("4. Continue Click");

        return  this;

    }

    //ENTER PIN
    public LoginPage EnterPin(String Pin)
    {

        WebDriverWait PinWait = new WebDriverWait(driver,60);
        PinWait.until(ExpectedConditions.elementToBeClickable(TxtboxPin));

        TxtboxPin.sendKeys(Pin);

        return  this;
    }


    public  void LoginSuccess()
    {

        AcceptWarning();
        EnterUserName(Prop.getProperty("UserName"));
        EnterPassword(Prop.getProperty("Password"));
        LoginContinue();
        EnterPin(Prop.getProperty("Pin"));
        Loginclick();
        AcceptRules();
        AcceptPolicy();


        //return this;
    }
    //CLICK ON LOGIN
    public LoginPage Loginclick()
    {
        WebDriverWait BtnLoginWait = new WebDriverWait(driver,60);
        BtnLoginWait.until(ExpectedConditions.elementToBeClickable(BtnLogin));

        BtnLogin.click();


        return  this;
    }

    public LoginPage AcceptRules()
    {

        WebDriverWait AcceptWait = new WebDriverWait(driver,60);
        AcceptWait.until(ExpectedConditions.elementToBeClickable(BtnRulesAccept));
        BtnRulesAccept.click();
        //System.out.println("1. Warning Accepted");
        //Reporter.log("1. Warning Accepted");
        return  this;

    }

    public LoginPage AcceptPolicy()
    {

        WebDriverWait AcceptWait = new WebDriverWait(driver,60);
        AcceptWait.until(ExpectedConditions.elementToBeClickable(BtnPolicyAccept));
        BtnPolicyAccept.click();
        //System.out.println("1. Warning Accepted");
        //Reporter.log("1. Warning Accepted");
        return  this;

    }

    public LoginPage LoginSuccessCheck()
    {

        WebDriverWait BtnPIBeginWait = new WebDriverWait(driver,60);
        BtnPIBeginWait.until(ExpectedConditions.elementToBeClickable(BtnBegin));

        if(BtnBegin.isDisplayed())
        {

            Reporter.log("Logged in Successfully.");
        }
        else
        {

            Reporter.log("There was some error while login.");
        }
        return this;
    }

    public LoginPage AboutMeTab()
    {
        WebDriverWait AboutMeWait=new WebDriverWait(driver,30);
        AboutMeWait.until(ExpectedConditions.elementToBeClickable(BtnAboutMe));

        BtnAboutMe.click();

        return this;
    }

    public LoginPage HamburgerMenu()
    {
        WebDriverWait HbMenuWait = new WebDriverWait(driver,60);
        HbMenuWait.until(ExpectedConditions.elementToBeClickable(HbMenu));

        if(HbMenu.isDisplayed()) {
            HbMenu.click();
        }
        else
        {
            Reporter.log("Either Button is not loaded or xpath has changed");
        }
        return this;
    }

    public LoginPage HeaderMessage()
    {
        WebDriverWait HeadMsgWait = new WebDriverWait(driver,60);
        HeadMsgWait.until(ExpectedConditions.elementToBeClickable(IntroMessage));

        String IntroMsg=IntroMessage.getText();
        Reporter.log("Message found after successful login :" + IntroMsg);

        return this;
    }


}
