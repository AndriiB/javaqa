package hw18;

import hw17.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DiscussedGoodsTest extends BaseTest {

    @Test
    public void getDiscussedGoods() throws InterruptedException {
        driver.get(URL);

        WebElement closeCross = driver.findElement(By.xpath("//span[@class='exponea-close-cross']"));
        closeCross.click();

        int t = driver.findElements(By.xpath("//h2[normalize-space() = 'Найбільш обговорювані товари']/following-sibling::button")).size();

        do {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            t++;
        } while (t < 0);

        WebElement showMore = driver.findElement(By.xpath("//h2[normalize-space() = 'Найбільш обговорювані товари']/following-sibling::button"));
        showMore.click();
    }


    @Test
    public void printDiscussedGoods() {
        List<WebElement> goodsTitle = driver.findElements(By.xpath("//h2[normalize-space() = 'Найбільш обговорювані товари']/following::ul[1]//li//a[@title]"));
        List<WebElement> goodsPrice = driver.findElements(By.xpath("//h2[normalize-space() = 'Найбільш обговорювані товари']/following::ul[1]//li//div[contains(@class, 'tile__price')][2]"));

        for (int i = 0; i < goodsTitle.size(); i++) {
            WebElement titleElement = goodsTitle.get(i);
            WebElement priceElement = goodsPrice.get(i);
            System.out.println(titleElement.getText() + " коштує " + priceElement.getText() + " гривень");
        }
    }
}
