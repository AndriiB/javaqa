package hw20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'buy-button button button--with-icon')]")
    private WebElement buyButton;
    public ProductPage(WebDriver driver) {
       super(driver);
    }

    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOf(buyButton));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", buyButton);
    }
}
