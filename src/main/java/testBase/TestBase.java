package testBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static AppiumDriver driver;
    public static Pages pages;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "DickyTest2");
        // This capability will open the Chrome browser instead of Native app.
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.get("http://saucedemo.com");
    }

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setup")
    public void setupTestConfig() {
        pages = new Pages(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
