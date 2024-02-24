package pages;

import io.appium.java_client.AppiumDriver;
import pages.login.LoginPage;
import pages.showcase.ShowcasePage;

public class Pages {
    private final AppiumDriver driver;
    private LoginPage loginPage;
    private ShowcasePage showcasePage;

    public Pages(AppiumDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        if (this.loginPage == null) {
            this.loginPage = new LoginPage(this.driver);
        }
        return this.loginPage;
    }

    public ShowcasePage showcasePage() {
        if (this.showcasePage == null) {
            this.showcasePage = new ShowcasePage(this.driver);
        }
        return this.showcasePage;
    }
}
