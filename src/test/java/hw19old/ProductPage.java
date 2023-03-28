package hw19old;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'buy-button button button--with-icon')]")
    private WebElement buyButton;
    public ProductPage(WebDriver driver) {
       super(driver);
    }

    public CartPage addToCart() {
        buyButton.click();
        return new CartPage(driver);
    }
}
