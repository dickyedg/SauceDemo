package pages.AddressDetailPage;

import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

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

    final String FIRST_NAME = "testFirstName";
    final String LAST_NAME = "testLastName";
    final String POSTALCODE = "13111";

    public AddressDetailPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        mobileActions.click(continueButton);
    }

    public void fillInAddressDetails() {
        mobileActions.sendKeys(firstNameField, FIRST_NAME);
        mobileActions.sendKeys(lastNameField, LAST_NAME);
        mobileActions.sendKeys(postalCodeField, POSTALCODE);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 2);
        driverWaiter.waitForVisibilityOf(addressDetailContainer);
    }
}
