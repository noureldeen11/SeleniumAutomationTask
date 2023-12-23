package tests;

import org.testng.annotations.Test;
import pages.BillingDetailsPage;
import pages.ShoppingCartPage;

public class BillingDetailsTest extends TestBase {

    @Test
    public void verifyExistingOfBillingDetails() {

        String expectedName = "Thinking in HTML";
        String expectedPrice = "₹400.00";
        String expectedQuantity = "1";
        String expectedTotal = "₹400.00";
        new ShoppingCartPage(driver).verifyProductDetails(expectedName, expectedPrice, expectedQuantity, expectedTotal).clickOnProceedToCheckout();
        new BillingDetailsPage(driver).verifyExisitingOfBillingDetails();

    }
}
