package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

public abstract class BaseTest {
    protected String user;
    protected String password;

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected EntriesPage entriesPage;
    protected TagsPage tagsPage;
    protected SettingsPage settingsPage;
    protected UploadImagePage uploadImagePage;


    @Step("Настройка и открытие браузера")
    @BeforeMethod
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = System.getenv().getOrDefault("ONLINEDIARY_USER", PropertyReader.getProperty("onlineDiary.user"));
        password = System.getenv().getOrDefault("ONLINEDIARY_PASSWORD", PropertyReader.getProperty("onlineDiary.password"));


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        entriesPage = new EntriesPage(driver);
        tagsPage = new TagsPage(driver);
        settingsPage = new SettingsPage(driver);
        uploadImagePage = new UploadImagePage(driver);
    }

    @Step("Закрытие браузера")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}
