package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmergencyContactsPage {

    public static WebDriver driver;

    public EmergencyContactsPage(WebDriver driver)

    {
        this.driver=driver;
    }

    @FindBy(xpath=".//*[@id='Emergency Contacts']")
    public static WebElement Enter_EmergencyContacts_Data;

    @FindBy(xpath = "(//iframe[@title='Emergency Contacts'])[2]")
    public static WebElement EmergencyIframe;

    @FindBy(xpath="//a[@id='addEmergencyContact']")
    public static WebElement AddContacts;

    @FindBy(id="firstName")
    public static WebElement fName;

    @FindBy(xpath = "//input[@id='lastName']")
    public static WebElement lName;

    public EmergencyContactsPage ClickEmergencyContactsButton()
    {
        WebDriverWait ECbuttonwait=new WebDriverWait(driver,20);
        ECbuttonwait.until(ExpectedConditions.elementToBeClickable(Enter_EmergencyContacts_Data));

        Enter_EmergencyContacts_Data.click();
        return this;
    }

    public EmergencyContactsPage switchToIframe()
    {
        WebDriverWait ECIframeWait=new WebDriverWait(driver,20);
        ECIframeWait.until(ExpectedConditions.elementToBeClickable(EmergencyIframe));

        driver.switchTo().frame(EmergencyIframe);     //switching to EmergencyContacts IFRAME

        return this;
    }

    public EmergencyContactsPage AddEmergency_Contacts()
    {
        WebDriverWait AddEmergency=new WebDriverWait(driver,20);
        AddEmergency.until(ExpectedConditions.elementToBeClickable(AddContacts));

        AddContacts.click();
        return this;
    }

    public EmergencyContactsPage EnterFirstName(String firstName)
    {
        WebDriverWait fNameWait=new WebDriverWait(driver,20);
        fNameWait.until(ExpectedConditions.elementToBeSelected(fName));

        fName.clear();
        fName.sendKeys(firstName);
        return this;
    }

    public EmergencyContactsPage EnterLastName(String lastName)
    {
        WebDriverWait lNameWait=new WebDriverWait(driver,20);
        lNameWait.until(ExpectedConditions.elementToBeClickable(lName));

        lName.clear();
        lName.sendKeys(lastName);

        return this;
    }
}
