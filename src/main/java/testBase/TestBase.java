package testBase;

import Util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
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

    final String capabilityFileName = "capabilities.json";
    final String sauceDemoUrl = "http://saucedemo.com";

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        JSONUtil jsonUtil = new JSONUtil();

        JsonNode jsonNode = jsonUtil.readJSONFromFile(capabilityFileName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, jsonNode.get("platform").asText());
        dc.setCapability(MobileCapabilityType.UDID, jsonNode.get("udid").asText());
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, jsonNode.get("deviceName").asText());
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, jsonNode.get("browserType").asText());
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, jsonNode.get("automationName").asText());

        driver = new AndroidDriver(new URL(jsonNode.get("localHostUrl").asText()), dc);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.get(sauceDemoUrl);
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
