package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class SettingsPage extends BasePage {
    public static By SETTINGS_BUTTON = By.xpath("//a[@class='user-menu__btn']");
    public static By SETTINGS_LIST = By.xpath("//div//li[@class='active']");
    public static By LIST_LANGUAGE = By.xpath("//option[@value]/ancestor::div[@class = 'col-sm-4']//option");
    public static By BUTTON_OK = By.xpath("//button[@class='btn btn-default']");
    public static By TEXT_LANGUAGE = By.xpath("//div[@class = 'alert alert-success' and text()]");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать кнопку SETTINGS_BUTTON")
    public SettingsPage clickSettingButton() {
        log.info("Press button with xPath: "+ SETTINGS_BUTTON);
        driver.findElement(SETTINGS_BUTTON).click();
        return this;
    }
    @Step("Выбрать настройки Language из списка настроек")
    public SettingsPage selectSettingLanguage() {
        List<WebElement> settings = driver.findElements(SETTINGS_LIST);
        log.info("Put all elements into a list");
        settings.get(0).click();
        log.info("Select an item from a list");
        return this;
    }
    @Step("Выбрать язык из списка")
    public SettingsPage selectLanguage() {
        List<WebElement> language = driver.findElements(LIST_LANGUAGE);
        log.info("Put all elements into a list");
        language.get(2).click();
        log.info("Select an item from a list");
        return this;
    }
    @Step("Нажать кнопку BUTTON_OK")
    public SettingsPage clickButtonOkLanguage() {
        driver.findElement(BUTTON_OK).click();
        log.info("Press button with xPath: "+ BUTTON_OK);
        return this;
    }
    @Step("Получить сообщение об изменении языка")
    public String gettextMessageLanguage() {
        return driver.findElement(TEXT_LANGUAGE).getText();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SETTINGS_BUTTON);
    }
}
