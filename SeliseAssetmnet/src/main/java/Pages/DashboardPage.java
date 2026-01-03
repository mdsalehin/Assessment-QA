package Pages;

import UtilsPackage.ExtractEmployeeList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class DashboardPage
{

    WebDriver driverobj;
    By locForName = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][3]");
    By locForStatus = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][6]");
    public DashboardPage(WebDriver driverobj)
    {
        this.driverobj = driverobj;
        PageFactory.initElements(driverobj,this);
    }

    @FindBy(xpath="//h6[text()='Dashboard']")
     WebElement dashboardTitle;

    @FindBy(xpath="//span[text()='Admin']")
     WebElement adminModuleTab;

    @FindBy(xpath="//span[text()='PIM']")
     WebElement pimModuleTab;

    @FindBy(xpath="//p[@class='oxd-userdropdown-name']")
     WebElement userProfileName;

    @FindBy(xpath="//a[text()='Employee List']")
     WebElement pimEmployeeListTab;

    @FindBy(className ="oxd-userdropdown-name")
    WebElement confirmLogin;


    public boolean confirmLogin()
    {
        return confirmLogin.isDisplayed();
    }

    public String getDashboardTitle(){
        return dashboardTitle.getText();
    }

    public String getAdminTitle()
    {
        return adminModuleTab.getText();
    }

    public String getPIM()
    {
        return pimModuleTab.getText();
    }

    public String userName()
    {

        return  userProfileName.getText();

    }

    public String employeeList()
    {
        return pimEmployeeListTab.getText();
    }

    public void clickOnPmModule()
    {
        pimModuleTab.click();
    }
    public boolean extractEmployee() {
        ExtractEmployeeList.scrollIntoView(driverobj, 0, 500);
        return ExtractEmployeeList.getEmployeeList(driverobj, locForName, locForStatus);

    }
}
