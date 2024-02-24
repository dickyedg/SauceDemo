package pages.CheckoutPreviewPage;

import Util.PricingUtil;
import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import pages.CheckoutCompletionPage.CheckoutCompletionPage;

public class CheckoutPreviewPage extends BasePage<CheckoutPreviewPage> {
    @FindBy(css = "[class*='summary_info_label summary_total_label']")
    public WebElement summaryTotalPrice;

    @FindBy(className = "summary_subtotal_label")
    public WebElement subTotalItemsPrice;

    @FindBy(className = "summary_tax_label")
    public WebElement taxPriceElement;

    @FindBy(id = "finish")
    public WebElement finishButton;

    PricingUtil pricingUtil;

    public CheckoutPreviewPage(AppiumDriver driver) {
        super(driver);
        pricingUtil = new PricingUtil();
    }

    public void verifyTotalPrices() {
        pricingUtil = new PricingUtil();
        double taxPrice = pricingUtil.splitPricingWithCurrency(elementMethods.getText(taxPriceElement));
        double subTotalPrice = pricingUtil.splitPricingWithCurrency(elementMethods.getText(subTotalItemsPrice));
        double totalPrice = pricingUtil.splitPricingWithCurrency(elementMethods.getText(summaryTotalPrice));
        Assert.assertEquals(totalPrice, subTotalPrice + taxPrice);
    }

    public void verifySubTotalPriceMatchedWithCartPrice(double priceOnCheckoutPreview) {
        double subTotalPrice = pricingUtil.splitPricingWithCurrency(elementMethods.getText(subTotalItemsPrice));
        Assert.assertEquals(subTotalPrice, priceOnCheckoutPreview);
    }

    public CheckoutCompletionPage clickFinishButton() {
        mobileActions.click(finishButton);
        return new CheckoutCompletionPage(driver);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 2);
        driverWaiter.waitForVisibilityOf(summaryTotalPrice);
        System.out.println("User is in checkout preview page now");
    }
}
