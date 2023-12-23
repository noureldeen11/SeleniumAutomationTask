package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BillingDetailsPage extends PageBase {
    private WebDriver driver;

    private By BillingDetailsForm = By.cssSelector(".woocommerce-billing-fields");

    public BillingDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyExisitingOfBillingDetails() {
        return getElement(BillingDetailsForm).isDisplayed();
    }


}
