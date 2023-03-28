package hw19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//ul[@class='cart-list']/li")
    List<WebElement> cartItems;

    @FindBy(xpath="//a[@data-testid='title'] ")
    List<WebElement> titles;

    @FindBy(xpath = "//rz-cart")
    private WebElement clickCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

   public void clickCartButton() {
        clickCart.click();
   }

}
