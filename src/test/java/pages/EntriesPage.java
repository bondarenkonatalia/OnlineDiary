package pages;

import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2

public class EntriesPage extends BasePage {
    public static final By CREATE_AN_ENTRY_BUTTON = By.id("create-entry");
    public static final By NEW_ENTRY = By.xpath("//*[contains(text(), '%s");
    public static final By DELETE_ENTRIES_BUTTON = By.id("delete-entries");
    public static final By RECORD_INPUT_FIELD = By.xpath("//div[contains(@class,'contenteditable cke_editable')]");
    public static final By SAVE_BUTTON = By.xpath("//a[@title='Save']");
    public static final By HOME_BUTTON = By.id("back-to-overview");
    public static final By CHECKBOX_ENTRY = By.xpath("//input[@class='ng-pristine ng-valid']");
    String RecordingDirectory = "//div[@class='div ng-scope']";

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу")
    public EntriesPage open() {
        driver.get(URL);
        log.info("Open page with URL:" + URL);
        return this;
    }

    public boolean titleVisible() {
        driver.findElement(CREATE_AN_ENTRY_BUTTON).isDisplayed();
        log.info("Checks that the title is visible");
        return true;
    }
    @Step("Создание новой записи с введенным текстом")
    public void createNewEntryWithText() {
        driver.findElement(CREATE_AN_ENTRY_BUTTON).click();
        log.info("Push button CREATE_AN_ENTRY_BUTTON");
        driver.findElement(RECORD_INPUT_FIELD).sendKeys();
        log.info("Entry field opened");
        driver.findElement(SAVE_BUTTON).click();
        log.info("Press save button");
        driver.findElement(HOME_BUTTON).click();
        log.info("Press home button");

    }
    @Step("Проверка создания записи ")
    public String textEntryShouldBe() {
        return driver.findElement(NEW_ENTRY).getText();
    }

    @Step("Удаление записи")
    public EntriesPage deleteEntry() {
        List<WebElement> list = driver.findElements(CHECKBOX_ENTRY);
        list.get(0).getText();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new EntriesPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_AN_ENTRY_BUTTON);
    }
}
