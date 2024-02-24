package pages.cart;

import Util.PricingUtil;
import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class CartPage extends BasePage<CartPage> {

    @FindBy(className = "inventory_item_name")
    public WebElement itemNames;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    @FindBy(className = "cart_item")
    public List<WebElement> cartItemsContainer;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public double calculateAllPrices() {
        PricingUtil pricingUtil = new PricingUtil();
        double totalPrice = 0;
        for (WebElement itemPrice : itemPrices) {
            String price = elementMethods.getText(itemPrice);
            totalPrice += pricingUtil.splitPricingWithCurrency(price);
        }
        return totalPrice;
    }

    public void verifyTotalItems(int expectedTotalItems) {
        Assert.assertEquals(cartItemsContainer.size(), expectedTotalItems);
    }

    public void clickCheckoutButton() {
        mobileActions.click(checkoutButton);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 2);
        driverWaiter.waitForVisibilityOf(itemNames);
    }
}
