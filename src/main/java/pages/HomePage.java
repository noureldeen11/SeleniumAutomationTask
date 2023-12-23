package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;

public class HomePage extends PageBase {
	
    private WebDriver driver;
    private By searchBox = By.name("s");
    private By productTitle = By.cssSelector(".post-title.entry-title"); 
 
    private By AddToBasketbtn = By.cssSelector("button[type='submit']");
    private By viewBasketbtn = By.cssSelector(".button.wc-forward");
      
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    
    public void searchForBook(String bookTitle) {
       setText(searchBox,bookTitle);;
       getElement(searchBox).submit();
    }
    
    public void clickOnProductTitle() {
        getElement(productTitle).click();
     }
     
//    public String getBookTitle() {
//        WebElement bookName = getElement(bookTitle);
//        return bookName.getText();
//    }
//    
//    public String getBookPrice() {
//        WebElement bookprice = getElement(bookPrice);
//        return bookprice.getText();
//    }
//    
//    public HomePage verifyBookDetails(String expectedName, String expectedPrice) {
//        String actualName = getBookTitle();
//        String actualPrice = getBookPrice();
//        assert actualName.equals(expectedName);
//        assert actualPrice.equals(expectedPrice);
//        return this;
//    }
    
    public HomePage ClickingOnAddtoBasket(){
        clickButton(AddToBasketbtn);
    	return this;
    }

    public HomePage clickOnViewBasketbtn(){

       clickButton(viewBasketbtn);
       return this;
    }
}
