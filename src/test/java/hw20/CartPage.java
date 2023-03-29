package hw20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//ul[@class='cart-list']/li")
    List<WebElement> cartItems;

    @FindBy(xpath="//a[@data-testid='title'] ")
    List<WebElement> titles;

    @FindBy(xpath = "//rz-cart")
    private WebElement cartButton;


    @FindBy(xpath = "//button[contains(@id, 'cartProductActions0')]")
    private WebElement threeDots;


    @FindBy(xpath = "//button[contains(text(), (' Видалити '))]")
    private WebElement deleteItem;

    @FindBy(xpath = "//div[@class='preloader']")
    private WebElement loader;


    public CartPage(WebDriver driver) {
        super(driver);
    }

   public void clickCartButton() {
       wait.until(ExpectedConditions.visibilityOf(cartButton));
       cartButton.click();
       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(new By.ByXPath("//ul[@class='cart-list']/li")));
   }
}
