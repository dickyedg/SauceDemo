package pages.AddressDetailPage;

import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CheckoutPreviewPage.CheckoutPreviewPage;

public class AddressDetailPage extends BasePage<AddressDetailPage> {
    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "checkout_info_container")
    public WebElement addressDetailContainer;

    @FindBy(id = "continue")
    public WebElement continueButton;

    public AddressDetailPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckoutPreviewPage clickContinueButton() {
        mobileActions.click(continueButton);
        return new CheckoutPreviewPage(driver);
    }

    public void fillInAddressDetails(String firstName, String lastName, String postalCode) {
        mobileActions.sendKeys(firstNameField, firstName);
        mobileActions.sendKeys(lastNameField, lastName);
        mobileActions.sendKeys(postalCodeField, postalCode);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 2);
        driverWaiter.waitForVisibilityOf(addressDetailContainer);
        System.out.println("User is in address detail page now");
    }
}
