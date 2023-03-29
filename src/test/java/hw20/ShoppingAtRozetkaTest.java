package hw20;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ShoppingAtRozetkaTest extends BaseTest {


    @Test
    public void shoppingAtRozetkaTest() throws IOException, InterruptedException {

        HomePage homePage = launchRozetka();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/products.properties");
        prop.load(fis);

        String products = prop.getProperty("products");
        String[] productNames = products.split(", ");

        for (String productName : productNames) {
            homePage.clickSearch(productName.trim());
            searchResultsPage.clickThirdProduct();
            productPage.addToCart();
            driver.navigate().back();
            homePage.clearSearch();
        }

        cartPage.clickCartButton();


        //Checking that the cart contains equal number of items as the properties file
        Assert.assertEquals(productNames.length, cartPage.cartItems.size());

        //Checking that text in titles contains product names from the properties file
        for (String productName : productNames) {
            boolean found = false;
            for (WebElement title : cartPage.titles) {
                if (title.getText().contains(productName)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found, "Product name '" + productName + "' not found in titles.");
        }

    }
}
