package pages;

import constants.WaitDuration;
import driverActions.DriverWaiter;
import driverActions.MobileActions;
import driverActions.MobileElementMethods;
import io.appium.java_client.AppiumDriver;

public class BasePage<PAGE extends BasePage> implements IPageConstructor<PAGE> {
    protected final AppiumDriver driver;
    protected final MobileActions mobileActions;
    protected final DriverWaiter waiter;
    protected final MobileElementMethods elementMethods;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        initElements(driver, WaitDuration.defaultWait);

        mobileActions = new MobileActions(driver);
        waiter = new DriverWaiter(driver);
        elementMethods = new MobileElementMethods(driver);
    }
}
