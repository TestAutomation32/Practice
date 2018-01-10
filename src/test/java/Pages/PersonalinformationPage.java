package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PersonalinformationPage {

    public static WebDriver driver;

    public PersonalinformationPage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='Personal Information']")
    public static WebElement BtnPIBegin;

    @FindBy(xpath = "//iframe[@title='Personal Information']")
    public static WebElement PIIframe;

    @FindBy(xpath = ".//*[@id='buttCore']")
    public static WebElement BtnCertify;

    @FindBy(xpath = "//span[text()='Save and Close']")
    public static WebElement BtnSaveClose;

    @FindBy(xpath = ".//*[@id='firstName']")
    public static WebElement TxtboxFirstName;

    @FindBy(xpath = "//a[text()='First Name is required.']")
    public static WebElement FNameValidation;

    @FindBy(xpath = ".//*[@id='lastName']")
    public static WebElement TxtboxLastName;

    @FindBy(xpath = "//a[text()='Last Name is required.']")
    public static WebElement LNameValidation;

    @FindBy(id = "TIN_Confirmation1")
    public static WebElement SSNStatusYes;

     @FindBy(id="maritalstatus")
     public static WebElement DrpDownMaritalStatus;

     @FindBy(className = "ui-datepicker-trigger")
     public static WebElement TapCalendar;

    @FindBy(className = "ui-datepicker-month")
    public static WebElement DobMonth;

    @FindBy(className = "ui-datepicker-year")
    public static WebElement DobYear;

    @FindBy(xpath = "//a[@href='#' and text()='14']")
    public static WebElement SelectDate;

    @FindBy(id="countryOfBirth")
    public static WebElement SelectCountryBirth;

    public PersonalinformationPage SwitchtoPI() {


        WebDriverWait BeginWait = new WebDriverWait(driver, 60);
        BeginWait.until(ExpectedConditions.elementToBeClickable(BtnPIBegin));
        BtnPIBegin.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame(PIIframe);
        System.out.println("Successfully Switched To Frame");

        return this;
    }

    public PersonalinformationPage CertifyButttonStatusCheck() {


        LoginPage MyLogin = new LoginPage(driver);

        MyLogin.LoginSuccess();

        WebDriverWait Certifybtnwait = new WebDriverWait(driver, 60);
        Certifybtnwait.until(ExpectedConditions.visibilityOf(BtnCertify));


        Assert.assertEquals(true, BtnCertify.isEnabled());

        return this;
    }

    public PersonalinformationPage CheckFirstNameValidation(String ExpectedText) {

        WebDriverWait FirstNameWait = new WebDriverWait(driver, 60);
        FirstNameWait.until(ExpectedConditions.elementToBeClickable(TxtboxFirstName));

        TxtboxFirstName.clear();

        WebDriverWait SavebuttonWait = new WebDriverWait(driver, 60);
        SavebuttonWait.until(ExpectedConditions.elementToBeClickable(BtnSaveClose));

        BtnSaveClose.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String ActualText = FNameValidation.getText();
        Assert.assertEquals(ActualText, ExpectedText);

        return this;
    }

    public PersonalinformationPage CheckLastNameValidation(String ExpectedText) {
        WebDriverWait LastNameWait = new WebDriverWait(driver, 60);
        LastNameWait.until(ExpectedConditions.elementToBeClickable(TxtboxLastName));

        TxtboxLastName.clear();

        WebDriverWait SavebuttonWait = new WebDriverWait(driver, 60);
        SavebuttonWait.until(ExpectedConditions.elementToBeClickable(BtnSaveClose));

        BtnSaveClose.click();

        String ActualText = LNameValidation.getText();
        Assert.assertEquals(ActualText, ExpectedText);


        return this;
    }

    public PersonalinformationPage SSNCheckYes()
    {

        SSNStatusYes.click();
        return this;
    }


    public PersonalinformationPage SelectMaritalStatus()
    {

        WebDriverWait SelectBoxwait = new WebDriverWait(driver,60);
        SelectBoxwait.until(ExpectedConditions.elementToBeClickable(DrpDownMaritalStatus));


        Select status = new Select(DrpDownMaritalStatus);
        status.selectByVisibleText("Single");

        return this;
    }

   public PersonalinformationPage SelectDoB()
   {

       WebDriverWait Calendariconwait = new WebDriverWait(driver,60);
       Calendariconwait.until(ExpectedConditions.elementToBeClickable(TapCalendar));

       TapCalendar.click();

        Select Month = new Select(DobMonth);
        Month.selectByIndex(5);

       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       Select Year = new Select(DobYear);
        Year.selectByIndex(3);

       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
        SelectDate.click();

       return this;
   }

   public PersonalinformationPage SelectCountryOfBirth()
    {
        WebDriverWait CouBirthWait=new WebDriverWait(driver,60);
        CouBirthWait.until(ExpectedConditions.elementToBeClickable(SelectCountryBirth));

        SelectCountryBirth.click();
        //SelectCountryBirth.findElement(By.tagName("option"));
        Select couName=new Select(SelectCountryBirth.findElement(By.tagName("option")));
        couName.selectByIndex(5);

        return this;
    }

}
