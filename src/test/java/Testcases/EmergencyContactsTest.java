package Testcases;

import Pages.EmergencyContactsPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class EmergencyContactsTest extends  BaseTest {


    @Test
    public void Enter_EmergencyContact()
    {
        loginpage.AcceptWarning();
        loginpage.EnterUserName(Prop.getProperty("UserName"));
        loginpage.EnterPassword(Prop.getProperty("Password"));
        loginpage.LoginContinue();
        loginpage.EnterPin(Prop.getProperty("Pin"));
        loginpage.Loginclick();
        loginpage.AcceptRules();
        loginpage.AcceptPolicy();
        loginpage.AboutMeTab();
        Emergencypage.ClickEmergencyContactsButton();
        Emergencypage.switchToIframe();
        Emergencypage.AddEmergency_Contacts();
        //Emergencypage.AddEmergency_Contacts();
        //Emergencypage.switchToIframe();
        Emergencypage.EnterFirstName(Prop.getProperty("fName"));
        Emergencypage.EnterLastName(Prop.getProperty("lName"));



    }
}
