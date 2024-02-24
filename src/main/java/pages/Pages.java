package pages;

import io.appium.java_client.AppiumDriver;
import pages.AddressDetailPage.AddressDetailPage;
import pages.CheckoutCompletionPage.CheckoutCompletionPage;
import pages.CheckoutPreviewPage.CheckoutPreviewPage;
import pages.cart.CartPage;
import pages.item.ItemDetailsPage;
import pages.login.LoginPage;
import pages.showcase.ShowcasePage;

public class Pages {
    private final AppiumDriver driver;
    private LoginPage loginPage;
    private ShowcasePage showcasePage;
    private ItemDetailsPage itemDetailsPage;
    private CartPage cartPage;
    private CheckoutPreviewPage checkoutPreviewPage;
    private AddressDetailPage addressDetailPage;
    private CheckoutCompletionPage checkoutCompletionPage;

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

    public ItemDetailsPage itemDetailsPage() {
        if (this.itemDetailsPage == null) {
            this.itemDetailsPage = new ItemDetailsPage(this.driver);
        }
        return this.itemDetailsPage;
    }

    public CartPage cartPage() {
        if (this.cartPage == null) {
            this.cartPage = new CartPage(this.driver);
        }
        return this.cartPage;
    }

    public CheckoutPreviewPage checkoutPreviewPage() {
        if (this.checkoutPreviewPage == null) {
            this.checkoutPreviewPage = new CheckoutPreviewPage(this.driver);
        }
        return this.checkoutPreviewPage;
    }

    public AddressDetailPage addressDetailPage() {
        if (this.addressDetailPage == null) {
            this.addressDetailPage = new AddressDetailPage(this.driver);
        }
        return this.addressDetailPage;
    }

    public CheckoutCompletionPage checkoutCompletionPage() {
        if (this.checkoutCompletionPage == null) {
            this.checkoutCompletionPage = new CheckoutCompletionPage(this.driver);
        }
        return this.checkoutCompletionPage;
    }
}
