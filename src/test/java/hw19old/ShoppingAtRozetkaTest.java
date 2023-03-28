package hw19old;

import org.testng.annotations.Test;

import java.io.IOException;

public class ShoppingAtRozetkaTest extends BaseTest {


    @Test
    public void shoppingAtRozetkaTest() throws IOException, InterruptedException {

        HomePage homePage = launchRozetka();

        SearchResultsPage searchResultsPage = homePage.clickSearch();

        ProductPage productPage = searchResultsPage.clickThirdProduct();

        CartPage cartPage = productPage.addToCart();

//        cartPage.checkNrItems();

//        cartPage.checkTitle();
    }
}
