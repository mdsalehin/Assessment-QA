package UtilsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ExtractEmployeeList
{
    static List<String> storeNames;
    static List<WebElement> allNameElements;
    static List<WebElement> allEmployeeElements;
    static List<String> storeStatus;



    public static void scrollIntoView(WebDriver driver, int x_axis, int y_axis) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x_axis+","+y_axis+")");
    }


    public static boolean getEmployeeList(WebDriver driver, By locForName, By locForStatus ) {
        allNameElements = driver.findElements(locForName);
        allEmployeeElements = driver.findElements(locForStatus);

        storeNames = new ArrayList<>();
        storeStatus = new ArrayList<String>();

        int i=0;
        while(i<5) {
            storeNames.add(allNameElements.get(i).getText());

            if(!((allEmployeeElements.get(i).getText())==null)) {
                storeStatus.add(allEmployeeElements.get(i).getText());
            }else {
                storeStatus.add("");
            }

            i++;
        }


        //for debugging purpose
        for(String s:storeNames) {
            System.out.println(s);
        }

        for(String s:storeStatus) {
            System.out.println(s);
        }

        // check Extracted name is not empty
        return checkNonEmptyList(storeNames);

    }

    // check Extracted name is not empty
    public static boolean checkNonEmptyList(List<String> names) {
        boolean allNamesValid = true;
        for (String name : names) {
            if (name.isEmpty()) {
                allNamesValid = false;
                break;
            }
        }

        return allNamesValid;
    }
}
