package driverActions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MobileElementMethods {
    protected final AppiumDriver driver;
    protected final DriverWaiter waiter;

    public MobileElementMethods(AppiumDriver driver) {
        this.driver = driver;
        this.waiter = new DriverWaiter(driver);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            boolean isVisible = (boolean) ((JavascriptExecutor) driver).executeScript(
                    "return window.getComputedStyle(arguments[0]).getPropertyValue('display') !== 'none'", element);
            return isVisible;
        } catch (Exception e) {
            return false;
        }
    }
}
