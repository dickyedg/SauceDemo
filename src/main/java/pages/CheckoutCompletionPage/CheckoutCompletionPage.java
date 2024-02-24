package pages.CheckoutCompletionPage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class CheckoutCompletionPage extends BasePage<CheckoutCompletionPage> {

    @FindBy(id = "checkout_complete_container")
    public WebElement checkoutCompletionContainer;

    public CheckoutCompletionPage(AppiumDriver driver) {
        super(driver);
    }

    public void verifyCheckoutCompletionIsShowing() {
        Assert.assertTrue(elementMethods.isElementVisible(checkoutCompletionContainer));
    }
}
