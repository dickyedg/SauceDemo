package pages.showcase;

import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Getter
@Setter
public class ShowcasePage extends BasePage<ShowcasePage> {

    @FindBy(id = "inventory_container")
    private WebElement productShowcaseContainer;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    private String productNameIdentifier;
    public ShowcasePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnProductNameOnIndex(int index) {
        productNameIdentifier = "(//div[@id=\"inventory_container\"])[2]/div/div["+ index + "]/div[2]/div[1]/a/div";
        WebElement productNameElement = driver.findElement(By.xpath(productNameIdentifier));
        mobileActions.click(productNameElement);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 3);
        driverWaiter.waitForVisibilityOf(productShowcaseContainer);
    }
}
