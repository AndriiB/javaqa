package hw23.tests;

import hw23.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.Collection;
import java.util.Collections;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeMethod
    public void initBrowser() {
        WebDriverManager.chromedriver().arch64().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications", "start-maximized", "incognito");
        options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
        driver = new ChromeDriver(options);
    }


    @BeforeMethod(dependsOnMethods = {"initBrowser"})
    public void openRztk() {
        driver.get("https://rozetka.com.ua/");
        mainPage = new MainPage(driver);
    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
