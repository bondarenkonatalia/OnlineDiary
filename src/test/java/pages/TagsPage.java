package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class TagsPage extends BasePage {

    public static final By MANAGER_TAGS_BUTTON = By.xpath("//a[@class='tags__manage-link']");
    public static final By TITLE_MANAGER_TAGS = By.xpath("//div[@class='content-container clearfix ng-scope']//h1");
    public static final By EDIT_TAGS = By.xpath("//i[@class='icon-plus icon-white']");
    public static final By INPUT_TAG_NAME = By.xpath("//input[@ng-change='resetFormStatus()']");
    public static final By BUTTON_OK = By.xpath("//button[@class='btn btn-default']");
    public static final By ENTRIES = By.xpath("(//div[@class=' body'])[1]");
    public static final By NEW_TAG_INPUT = By.xpath("//input[@ng-model='model.newTag']");
    public static final By CREATE_NEW_TAG_BUTTON = By.id("assign-new-tag");
    public static final By DELETE_TAG_BUTTON = By.xpath("//a[@ng-click='deleteTag(tag)']");
    public static final By ENTRY_TAG_NO = By.xpath("//div[@class='none centered']");

    public TagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку для редактирования тегов")
    public TagsPage buttonEditTags() {
        driver.findElement(EDIT_TAGS).click();
        log.info("click the button edit teg");
        return this;
    }

    @Step("Редактировать имя тега")
    public TagsPage createTagName(String text) {
        driver.findElement(INPUT_TAG_NAME).clear();
        log.info("Clear tag entry field");
        driver.findElement(INPUT_TAG_NAME).sendKeys(text);
        log.info("Enter tag name");
        return this;
    }

    @Step("Нажать кнопку OK")
    public TagsPage clickOnOkButton() {
        driver.findElement(BUTTON_OK).click();
        log.info("Click the confirmation button, change the tag with the xpath.:");
        return this;
    }
    @Step("Выбрать запись")
    public TagsPage clickEntries() {
        driver.findElement(ENTRIES).click();
        log.info("Select entry");
        return this;
    }
    @Step("Записать имя тега")
    public TagsPage writeTextToTag(String text) {
        driver.findElement(ENTRIES).click();
        log.info("Writing text to tag field " + text);
        driver.findElement(NEW_TAG_INPUT).sendKeys(text);
        return this;
    }
    @Step("Подтвердить создание тега")
    public TagsPage clickOk() {
        driver.findElement(CREATE_NEW_TAG_BUTTON).click();
        log.info("Click on create new teg button with id:");
        return this;
    }
    @Step("Нажать кнопку MANAGER_TAGS_BUTTON")
    public TagsPage clickButtonManagerTags() {
        driver.findElement(MANAGER_TAGS_BUTTON).click();
        return new TagsPage(driver);
    }
    @Step("Нажать на кнопку удаления тегов")
    public TagsPage buttonDeleteTags() {
        driver.findElement(DELETE_TAG_BUTTON).click();
        log.info("click the button delete teg");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
    @Step("Взять текст тега")
    public String gettextTeg() {
        return driver.findElement(NEW_TAG_INPUT).getText();
    }



    @Override
    public boolean isPageOpen() {
        return isExist(TITLE_MANAGER_TAGS);
    }
}