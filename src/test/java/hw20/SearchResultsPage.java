package hw20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'catalog-grid')]//li[3]")
    private WebElement thirdProduct;
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickThirdProduct(){
         thirdProduct.click();
    }
}
