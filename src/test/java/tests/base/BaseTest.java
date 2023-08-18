package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.EntriesPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

public abstract class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected EntriesPage entriesPage;

    @Step("Настройка и открытие браузера")
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        entriesPage = new EntriesPage(driver);
    }

    @Step("Закрытие браузера")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}