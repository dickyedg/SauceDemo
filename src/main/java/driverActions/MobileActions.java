package driverActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MobileActions {
    protected final AppiumDriver driver;
    protected final DriverWaiter waiter;
    protected final MobileElementMethods elementMethods;
    PointerInput finger;
    List<Sequence> sequenceList;

    public MobileActions(AppiumDriver driver) {
        this.driver = driver;
        this.waiter = new DriverWaiter(driver);
        this.elementMethods = new MobileElementMethods(driver);
        finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        sequenceList = new ArrayList<>();
    }

    public void click(WebElement element) { waiter.waitForElementToBeClickable(element).click();}

    public void sendKeys(WebElement element, String text) {
        waiter.waitForElementToBeClickable(element).click();
        element.click();
        element.sendKeys(text);
        ((AndroidDriver) this.driver).hideKeyboard();
    }
}
