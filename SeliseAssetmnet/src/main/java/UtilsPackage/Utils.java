package UtilsPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils
{
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // 1. Cast WebDriver to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            // 2. Get the screenshot as a file
            File source = ts.getScreenshotAs(OutputType.FILE);

            // 3. Define the destination path with a unique name (timestamp recommended)
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destinationPath = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + timestamp + ".png";
            File destination = new File(destinationPath);

            // 4. Copy the file to the destination
            FileHandler.copy(source, destination);

            System.out.println("Screenshot captured: " + destinationPath);

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
