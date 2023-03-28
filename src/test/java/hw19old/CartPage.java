package hw19old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkNrItems() {
        List<WebElement> cartItems = driver.findElements(By.xpath("//ul[@class='cart-list']/li"));
        Assert.assertEquals(cartItems.size(), 2);
    }

    public void checkTitle() {
        String acerItem = driver.findElement(By.xpath("//div[@class='cart-product__main']/a[contains(@title, 'Acer')]")).getText();
        Assert.assertTrue(acerItem.contains("Acer Aspire"));
        String freggiaItem = driver.findElement(By.xpath("//div[@class='cart-product__main']/a[contains(@title, 'FREGGIA')]")).getText();
        Assert.assertTrue(freggiaItem.contains("FREGGIA"));
    }
}
