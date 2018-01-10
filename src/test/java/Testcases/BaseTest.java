package Testcases;

import Pages.EmergencyContactsPage;
import Pages.LoginPage;
import Pages.PersonalinformationPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.*;

public class BaseTest {

public WebDriver driver;
public LoginPage loginpage;
public PersonalinformationPage PIpage;
public EmergencyContactsPage Emergencypage;

public static Properties Prop = null;

@BeforeSuite
public void Setup()
{

    ReadData();
    System.setProperty("webdriver.chrome.driver",Prop.getProperty("ChromeDriverPath"));
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(Prop.getProperty("LoginURL"));

    //PAGE FACTORY INITIATE
    loginpage = PageFactory.initElements(driver,LoginPage.class);
    PIpage = PageFactory.initElements(driver, PersonalinformationPage.class);
    Emergencypage = PageFactory.initElements(driver, EmergencyContactsPage.class);

    //ECpage=PageFactory.initElements(driver,EmergencyContactsPage.class);


}


@AfterSuite
public  void close()
{

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
   // driver.close();
}
//READIND DATA FROM PROPERTIES FILE
public void ReadData()
    {

        File file = new File("C:/Users/Khalil Conteh/IdeaProjects/PracticeDemo/src/Data.Properties");
        FileInputStream fileinput = null;

        try {
            fileinput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Prop = new Properties();

        try {
            Prop.load(fileinput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     //TAKE SCREENSHOT
    public void TakeScreenshots()
    {

        Random rand = new Random();
        int x  = rand.nextInt(2000); //Will generate random numbers between 1 to 200.

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File("c:\\SeleniumScreenshots\\"+x+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
