package hw19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//ul[@class='cart-list']/li")
    List<WebElement> cartItems;

    @FindBy(xpath = "//rz-cart")
    private WebElement clickCart;

    @FindBy(xpath = "//div[@class='cart-product__main']/a[contains(@title, 'Acer')]")
    private WebElement acerItem;

    @FindBy(xpath = "//div[@class='cart-product__main']/a[contains(@title, 'FREGGIA')]")
    private WebElement freggiaItem;

    @FindBy(xpath = "//div[@class='cart-product__main']/a[contains(@title, 'Skif')]")
    private WebElement skifItem;


    public CartPage(WebDriver driver) {
        super(driver);
    }

   public void clickCartButton() {
        clickCart.click();
   }

    public void checkNrItems() {
        Assert.assertEquals(cartItems.size(), 3);
    }

    public void checkTitles() {
        WebElement[] items = { acerItem, freggiaItem, skifItem };
        String[] titles = { "Acer Aspire", "FREGGIA", "Skif" };

        for (int i = 0; i < items.length; i++) {
            Assert.assertTrue(items[i].getText().contains(titles[i]));
        }
    }
}
