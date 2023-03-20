package hw17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

    public class BaseTest {
        protected WebDriver driver;
        protected String URL = "https://rozetka.com.ua/ua/";

    @BeforeClass
    public void initBrowser() {
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

//    @AfterClass
//    public void closeBrowser() {
//        driver.quit();
//        }
}
