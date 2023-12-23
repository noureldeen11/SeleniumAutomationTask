package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends TestBase {

    @Test(priority = 1)
    public void goToShoppingCart() {
        HomePage homePage = new HomePage(driver);

        homePage.searchForBook("Thinking in HTML");
        homePage.clickOnProductTitle();
        try {
            WebElement dismissButton = driver.findElement(By.id("dismiss-button"));
            dismissButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Dismiss button not found or ad might not be present.");
        }
        homePage.ClickingOnAddtoBasket();
        try {
            WebElement dismissButton3 = driver.findElement(By.id("dismiss-button"));
            dismissButton3.click();
        } catch (NoSuchElementException e) {
            System.out.println("Dismiss button not found or ad might not be present.");
        }
        homePage.clickOnViewBasketbtn();
        try {
            WebElement dismissButton3 = driver.findElement(By.id("dismiss-button"));
            dismissButton3.click();
        } catch (NoSuchElementException e) {
            System.out.println("Dismiss button not found or ad might not be present.");
        }

    }

    @Test(priority = 2)
    public void verifyCartDetails() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String expectedName = "Thinking in HTML";
        String expectedPrice = "₹400.00";
        String expectedQuantity = "1";
        String expectedTotal = "₹400.00";

        shoppingCartPage.verifyProductDetails(expectedName, expectedPrice, expectedQuantity, expectedTotal);
        shoppingCartPage.clickOnProceedToCheckout();
    }


}
