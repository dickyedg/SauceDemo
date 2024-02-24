package pages.item;

import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ItemDetailsPage extends BasePage<ItemDetailsPage> {
    @FindBy(css = "[class*='btn btn_primary btn_small btn_inventory']")
    public WebElement itemAddToCart;

    @FindBy(className = "inventory_details_price")
    public WebElement itemPrice;

    @FindBy(id = "back-to-products")
    public WebElement backToShowcasePageButton;

    public ItemDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public void tapBackButton() {
        mobileActions.click(backToShowcasePageButton);
    }

    public void clickAddToCart() {
        mobileActions.click(itemAddToCart);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 2);
        driverWaiter.waitForVisibilityOf(itemPrice);
    }
}
