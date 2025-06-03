package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	WebDriver driver;

	// Sleep wrapper
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Get text from element
    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    // Click and wait (example with Thread.sleep, consider replacing with WebDriverWait in real use)
    public static void clickAndWait(WebElement element, int seconds) {
        element.click();
        wait(seconds);
    }

    // Scroll into view using JavaScript
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Switch to frame
    public static void switchToFrame(WebDriver driver, String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    // Switch back to main content
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Accept Alert
    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    // Dismiss Alert
    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    // Get Alert Text
    public static String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }
    
 // Generic equality assertion with custom label
    public static void assertEquals(String label, String actual, String expected) {
    	Assert.assertEquals(label + " mismatch. Expected: " + expected + ", but got: " + actual, expected, actual);
    }
    

}
