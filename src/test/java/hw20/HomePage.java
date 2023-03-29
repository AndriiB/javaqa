package hw20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private WebElement searchSubmit;

    public HomePage(WebDriver driver) {
       super(driver);
    }


    public void clickSearch(String productName) {
            searchBar.sendKeys(productName);

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", searchSubmit);
//            wait.until(ExpectedConditions.elementToBeClickable(searchSubmit));
//            searchSubmit.click();
        }

    public void clearSearch() {
        searchBar.clear();
    }
}
