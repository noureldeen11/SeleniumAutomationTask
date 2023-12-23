package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class BookDetailsTest extends TestBase {

    @Test
    public void validatebookdetails() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForBook("Thinking in HTML");
        //homePage.verifyBookDetails(expectedBookName,expectedBookPrice);
        homePage.clickOnProductTitle();
        homePage.ClickingOnAddtoBasket();
        homePage.clickOnViewBasketbtn();
    }

}
