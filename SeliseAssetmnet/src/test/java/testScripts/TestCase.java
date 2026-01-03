package testScripts;

import Pages.DashboardPage;
import Pages.LoginPage;
import UtilsPackage.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase
{
    DashboardPage dpobj;
    WebDriver driverobj;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driverobj = new ChromeDriver();
        driverobj.manage().window().maximize();
        driverobj.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        wait = new WebDriverWait(driverobj, Duration.ofSeconds(15));

        //  LOGIN ONCE
        driverobj.get("https://opensource-demo.orangehrmlive.com/");

    }
    @Test
    public void verifyLoginFunctionality(){
        LoginPage lpobj = new LoginPage(driverobj);
        dpobj = lpobj.login("Admin","admin123");
        Assert.assertTrue(dpobj.confirmLogin());

    }

    @Test(dependsOnMethods = "verifyLoginFunctionality")
    public void verifyDashboardTitle(){
        String expectTitle="Dashboard";
        String actulTitle = dpobj.getDashboardTitle();
        Assert.assertEquals(actulTitle,expectTitle);
    }

    @Test(dependsOnMethods = "verifyLoginFunctionality")
    public void verifyAdminIsPresent()
    {
        String expectTitle="Admin";
        String actulTitle = dpobj.getAdminTitle();
        Assert.assertEquals(actulTitle,expectTitle);
    }

    @Test(dependsOnMethods = "verifyLoginFunctionality")
    public void verifyPIM()
    {
        String expectTitle="PIM";
        String actulTitle = dpobj.getPIM();
        Assert.assertEquals(actulTitle,expectTitle);
    }

    @Test(dependsOnMethods = "verifyLoginFunctionality")
    public void verifyUserName()
    {
        String expectTitle="MD Salahin";
        String actulTitle = dpobj.userName();

        if(expectTitle.equals(actulTitle))
        {
            Assert.assertEquals(actulTitle,expectTitle);
        }else
        {
            Utils.captureScreenshot(driverobj,"profileNamePic");
        }
    }
    @Test(dependsOnMethods = "verifyLoginFunctionality")
    public void verifyPmClick()
    {
        dpobj.clickOnPmModule();
        String expectTitle="Employee List";
        String actulTitle = dpobj.employeeList();
        Assert.assertEquals(actulTitle,expectTitle);
    }
    @Test(dependsOnMethods = "verifyPmClick")
    public void verifyNamesNotEmpty() {
        Assert.assertTrue(dpobj.extractEmployee());
    }
   @AfterClass
    public void quitDriver()
    {
        driverobj.quit();
    }

}
