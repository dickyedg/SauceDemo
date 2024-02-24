package purchaseFlow;

import dataProvider.UserDataProvider;
import testBase.TestBase;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {

    @Test(dataProvider = "UserDataProvider", dataProviderClass = UserDataProvider.class,description = "This test case is to verify E2E positive purchase flow")
    public void verifyPurchaseFlow(String username, String password) throws InterruptedException {
        final int TOTAL_ITEMS_TO_ADD = 2;

        pages.loginPage().fillLoginDetails(username, password);
        pages.loginPage().clickOnLoginButton().waitLoaded();

        for(int i = 1 ; i <= TOTAL_ITEMS_TO_ADD; i++) {
            pages.showcasePage().clickOnProductNameOnIndex(i).waitLoaded();
            pages.itemDetailsPage().clickAddToCart();
            pages.itemDetailsPage().tapBackButton().waitLoaded();
        }

        pages.showcasePage().clickOnShoppingCartButton().waitLoaded();
        pages.cartPage().verifyTotalItems(TOTAL_ITEMS_TO_ADD);
        double totalPriceInCart = pages.cartPage().calculateAllPrices();
        pages.cartPage().clickCheckoutButton().waitLoaded();

        pages.addressDetailPage().fillInAddressDetails();
        pages.addressDetailPage().clickContinueButton().waitLoaded();
        pages.checkoutPreviewPage().verifySubTotalPriceMatchedWithCartPrice(totalPriceInCart);
        pages.checkoutPreviewPage().verifyTotalPrices();
        pages.checkoutPreviewPage().clickFinishButton().waitLoaded();

        pages.checkoutCompletionPage().verifyCheckoutCompletionIsShowing();
    }
}