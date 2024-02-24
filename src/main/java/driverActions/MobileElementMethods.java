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

    public String getText(WebElement element) {
        return waiter.waitForVisibilityOf(element).getText();
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
