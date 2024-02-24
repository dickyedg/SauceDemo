package purchaseFlow;

import io.appium.java_client.android.AndroidDriver;
import testBase.TestBase;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {

    @Test(description = "This test case is to verify E2E positive purchase flow")
    public void verifyPurchaseFlow() throws InterruptedException {
        //((AndroidDriver) driver).context("CHROMIUM");
        pages.loginPage().fillLoginDetails("standard_user", "secret_sauce");
        pages.loginPage().clickOnLoginButton();

        pages.showcasePage().clickOnProductNameOnIndex(1);
        Thread.sleep(10000);
    }
}