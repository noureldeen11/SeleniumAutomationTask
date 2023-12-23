package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBase {
    private WebDriver driver;
    private By productName = By.cssSelector("td[class='product-name'] a");
    private By productPrice = By.cssSelector(".product-price .woocommerce-Price-amount");
    private By productQuantity = By.cssSelector(".product-quantity input");
    private By productTotal = By.cssSelector(".product-subtotal .woocommerce-Price-amount");

    private By proceedToCheckoutBtn = By.cssSelector(".checkout-button.button.alt.wc-forward");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public String getProductQuantity() {
        WebElement quantityElement = getElement(productQuantity);
        return quantityElement.getAttribute("value");
    }

    public String getProductTotal() {
        return getText(productTotal);
    }

    public ShoppingCartPage verifyProductDetails(String expectedName, String expectedPrice, String expectedQuantity, String expectedTotal) {
        String actualName = getProductName();
        String actualPrice = getProductPrice();
        String actualQuantity = getProductQuantity();
        String actualTotal = getProductTotal();

        assert actualName.equals(expectedName);
        assert actualPrice.equals(expectedPrice);
        assert actualQuantity.equals(expectedQuantity);
        assert actualTotal.equals(expectedTotal);
        return this;
    }

    public void clickOnProceedToCheckout() {
        clickButton(proceedToCheckoutBtn);
    }


}
