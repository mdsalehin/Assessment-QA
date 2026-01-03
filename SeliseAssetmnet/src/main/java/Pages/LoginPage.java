package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class LoginPage
{
    WebDriverWait waitobj;
    WebDriver driverobj;

    public LoginPage(WebDriver driverobj)
    {
        this.driverobj = driverobj;
        PageFactory.initElements(driverobj,this);
        this.waitobj = new WebDriverWait(driverobj, Duration.ofSeconds(10));
    }

    //PageElements
    @FindBy(className = "oxd-input")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement usePassword;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;

   //Actions ON WebElements

    public DashboardPage  login(String username, String usepassword)
    {
        waitobj.until(ExpectedConditions.visibilityOf(userName)).sendKeys(username);
        waitobj.until(ExpectedConditions.visibilityOf(usePassword)).sendKeys(usepassword);
        submit.click();
        return new DashboardPage(driverobj);
    }


}
