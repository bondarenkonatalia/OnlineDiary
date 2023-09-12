package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2

public class EntriesPage extends BasePage {
    public static final By CREATE_AN_ENTRY_BUTTON = By.id("create-entry");
    public static final By NEW_ENTRY = By.xpath("//div[@ng-bind-html='entry.body']");
    public static final By DELETE_ENTRIES_BUTTON = By.id("delete-entries");
    public static final By RECORD_INPUT_FIELD = By.xpath("//div[contains(@class,'contenteditable cke_editable')]");
    public static final By SAVE_BUTTON = By.xpath("//span[@class='cke_button_icon']");
    public static final By HOME_BUTTON = By.id("back-to-overview");
    public static final By CHECKBOX_ENTRY = By.xpath("//input[@ng-change='updateSelectionState()']");
    public static final By ALL_CHECKBOX = By.xpath("//input[@ng-change='selectOrUnselectAll()']");
    public static final By NO_RECORDS= By.xpath("//div[@class='none centered']");

    public EntriesPage(WebDriver driver) {
        super(driver);
    }
    @Step("Открыть страницу")
    public EntriesPage open() {
        driver.get(URL + "app/#/entries");
        log.info("Open page with URL:" + URL);
        return this;
    }

    @Step("Нажать кнопку CREATE_AN_ENTRY_BUTTON")
    public EntriesPage clickCreateAnEntryButton() {
        driver.findElement(CREATE_AN_ENTRY_BUTTON).click();
        log.info("Push button CREATE_AN_ENTRY_BUTTON");
        driver.findElement(RECORD_INPUT_FIELD).click();
        log.info("Entry field opened");
        return this;
    }

    @Step("Создание новой записи с текстом")
    public EntriesPage createNewEntryWithText(String text) {
        driver.findElement(RECORD_INPUT_FIELD).sendKeys(text);
        log.info("Enter text in the input field " + text);
        driver.findElement(SAVE_BUTTON).click();
        log.info("Press save button");
        return this;
    }
    @Step("Взять текст созданной записи")
    public String getTextEntry() {
        return driver.findElement(NEW_ENTRY).getText();
    }

    @Step("Нажать кнопку HOME_BUTTON")
    public EntriesPage clickHomeButton() {
        driver.findElement(HOME_BUTTON).click();
        log.info("Press home button with xPath: "+ HOME_BUTTON);
        return this;
    }
    @Step("Выбрать запись из списка")
    public EntriesPage selectEntry() {
        List<WebElement> list = driver.findElements(CHECKBOX_ENTRY);
        log.info("Put all elements into a list");
        list.get(0).click();
        log.info("Select an item from a list");
        return this;
    }
    @Step("Выбрать все записи")
    public EntriesPage selectAllEntries() {
        driver.findElement(ALL_CHECKBOX).click();
        log.info("Click on all checkbox with xPath: "+ ALL_CHECKBOX);
        return this;
    }
    @Step("Редактирование созданной записи")
    public EntriesPage editingPost(String text) {
        driver.findElement(NEW_ENTRY).click();
        log.info("Select created entry");
        driver.findElement(RECORD_INPUT_FIELD).clear();
        log.info("Clear entry field");
        driver.findElement(RECORD_INPUT_FIELD).sendKeys(text);
        log.info("Enter text in the input field");
        driver.findElement(SAVE_BUTTON).click();
        log.info("Press save button");
        return this;
    }
    @Step("Нажать кнопку DELETE_ENTRIES_BUTTON")
    public EntriesPage clickDeleteEntriesButton() {
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        log.info("Press delete entries button with xPath: "+ DELETE_ENTRIES_BUTTON);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
    @Step("Найти абзац «Записи не найдены")
    public boolean isThereNoEntries() {
        driver.findElement(NO_RECORDS);
        log.info("Finding the 'No entries found paragraph'");
        return true;
    }

    @Step("Убедиться, что на странице нет записей")
    public String noEntriesOnPage() {
        return driver.findElement(NO_RECORDS).getText();
    }
    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_AN_ENTRY_BUTTON);
    }
}