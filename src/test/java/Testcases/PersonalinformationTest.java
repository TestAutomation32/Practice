package Testcases;

import com.sun.jna.platform.win32.WinBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PersonalinformationTest extends BaseTest {


    @Test(priority = 1)
    public void SwitchToFrame() {

        PIpage.SwitchtoPI();

    }

    @Test(priority = 0)
    public void CertifyBtnStatusVerification() {

        int Errorcount = 0;
        try {
            PIpage.CertifyButttonStatusCheck();
        } catch (AssertionError E) {

            E.printStackTrace();
        }


        if (Errorcount > 0) {

            Assert.fail();
            Reporter.log("Test Case Failed");
        }

        //  Reporter.log("Certify Button is Disabled");
    }


    @Test(enabled = false)//(priority = 2)
    public void FirstNameValidationVerification() {


        PIpage.CheckFirstNameValidation("First Name is required.");
        Reporter.log("FirstName validation is fired when user submit Firstname as Blank.");
    }

    @Test(enabled = false)//(priority = 3)
    public void LastNameValidationVerification() {


        PIpage.CheckLastNameValidation("Last Name is required.");
        Reporter.log("LastName validation is fired when user submit Firstname as Blank.");
    }

    @Test(priority = 4)
    public void SSNCheckToYes() {

        PIpage.SSNCheckYes();

    }

    @Test(priority = 5)
    public void MaritalStatusSelect() {

        PIpage.SelectMaritalStatus();

    }

    @Test(priority = 6)
    public void EnterDoB()
    {

        PIpage.SelectDoB();
    }

    @Test(enabled =false)//(priority = 7)
    public void CountryOfBirth()
    {
        PIpage.SelectCountryOfBirth();
    }

}
