package hw19old;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends BasePage {

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private WebElement searchSubmit;

    public HomePage(WebDriver driver) {
       super(driver);
    }

//    public SearchResultsPage clickSearch() throws IOException {
//
//        searchBar.sendKeys();
//
//        searchSubmit.click();
//
//        return new SearchResultsPage(driver);
//    }

//    public SearchResultsPage clickSearch() throws IOException, InterruptedException {
//        Properties prop = new Properties();
//        FileInputStream fis = new FileInputStream("src/test/resources/products.properties");
//        prop.load(fis);
//
//        String products = prop.getProperty("products");
//        String[] productNames = products.split(", ");
//
//        for (String productName : productNames) {
//           searchBar.sendKeys(productName.trim());
//           searchSubmit.click();
//        }
//        return new SearchResultsPage(driver);
//  }

    public SearchResultsPage clickSearch() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/products.properties");
        prop.load(fis);

        String products = prop.getProperty("products");
        String[] productNames = products.split(", ");

        for (String productName : productNames) {
            searchBar.sendKeys(productName.trim());
            searchSubmit.click();
//            driver.findElement(By.cssSelector("[class*='product']")).click();
            driver.navigate().back();
        }

        return new SearchResultsPage(driver);
    }

}
