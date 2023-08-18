package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    public static final By MENU_SLOGAN = By.xpath("//div[@class='header__menu-slogan']");
    public static final By LOGIN_PRIMARY = By.xpath("//a[@class = 'btn btn-primary']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть сайт")

    public HomePage open() {
        driver.get(URL+"en");
        log.info("Open site with URL:" + URL);
        return this;
    }
    @Step("Нажать кнопку LOGIN")

    public HomePage clickLoginPrimary() {
        driver.findElement(LOGIN_PRIMARY).click();
        log.info("Click on loginButton with xPath: By.xpath");
        return this;
    }

    @Override
    public boolean isPageOpen() {
        return isExist (MENU_SLOGAN);
    }
}
