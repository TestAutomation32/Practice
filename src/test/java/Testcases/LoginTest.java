package Testcases;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginSuccess()
    {

         loginpage.AcceptWarning();
         loginpage.EnterUserName(Prop.getProperty("UserName"));
         loginpage.EnterPassword(Prop.getProperty("Password"));
         TakeScreenshots();
         loginpage.LoginContinue();
         loginpage.EnterPin(Prop.getProperty("Pin"));
         TakeScreenshots();
         loginpage.Loginclick();
         loginpage.AcceptRules();
         loginpage.AcceptPolicy();
         loginpage.LoginSuccessCheck();
         loginpage.HamburgerMenu();
        // loginpage.HeaderMessage();

    }
}
