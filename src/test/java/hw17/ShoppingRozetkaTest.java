package hw17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShoppingRozetkaTest extends BaseTest {

    @Test(priority=1)
    public void shoppingAcer() {
        driver.get(URL);
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Acer Aspire");
        WebElement searchSubmit = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
        searchSubmit.click();
        WebElement thirdItem = driver.findElement(By.xpath("//ul[contains(@class, 'catalog-grid')]//li[3]"));
        thirdItem.click();
        WebElement buyButton = driver.findElement(By.xpath("//button[contains(@class, 'buy-button button button--with-icon')]"));
        buyButton.click();
    }

    @Test(priority=2)
    public void shoppingFreggia() {
        driver.get(URL);
        WebElement searchFreggia = driver.findElement(By.name("search"));
        searchFreggia.sendKeys("FREGGIA");
        WebElement searchSubmitFreggia = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
        searchSubmitFreggia.click();
        WebElement thirdItemFreggia = driver.findElement(By.xpath("//ul[contains(@class, 'catalog-grid')]//li[3]"));
        thirdItemFreggia.click();
        WebElement buyButtonFreggia = driver.findElement(By.xpath("//button[contains(@class, 'buy-button button button--with-icon')]"));
        buyButtonFreggia.click();

    }

    @Test(priority=3)
    public void checkNrItems() {
        List<WebElement> cartItems = driver.findElements(By.xpath("//ul[@class='cart-list']/li"));
        Assert.assertEquals(cartItems.size(), 2);
    }

    @Test(priority=4)
    public void checkTitle() {
        String acerItem = driver.findElement(By.xpath("//div[@class='cart-product__main']/a[contains(@title, 'Acer')]")).getText();
        Assert.assertTrue(acerItem.contains("Acer Aspire"));
        String freggiaItem = driver.findElement(By.xpath("//div[@class='cart-product__main']/a[contains(@title, 'FREGGIA')]")).getText();
        Assert.assertTrue(freggiaItem.contains("FREGGIA"));
    }
}
