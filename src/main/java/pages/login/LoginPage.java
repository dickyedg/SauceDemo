package pages.login;

import driverActions.DriverWaiter;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

@Getter
@Setter
public class LoginPage extends BasePage<LoginPage> {

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnLoginButton() {
        mobileActions.click(loginButton);
    }

    public void fillLoginDetails(String username, String password) {
        mobileActions.sendKeys(usernameField, username);
        mobileActions.sendKeys(passwordField, password);
    }

    @Override
    public void waitPage() {
        DriverWaiter driverWaiter = new DriverWaiter(driver, 2);
        driverWaiter.waitForVisibilityOf(loginButton);
    }
}
