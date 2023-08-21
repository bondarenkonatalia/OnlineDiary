package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TagsPage extends BasePage {

    public static final By TITLE_MANAGER_TAGS = By.xpath("//h1[.='Manage Tags']");
    public static final By EDIT_TAGS = By.xpath("//div[@id='main']//table[@class='spaced-table']//i[@class='icon-plus icon-white']");
    public static final By TITLE_EDIT_TAGS = By.xpath("//h1[.='Edit Tag']");
    public static final By INPUT_TAG_NAME = By.xpath("//input[@id='tag']");
    public static final By BUTTON_OK = By.xpath("//button[@class='btn btn-primary']");

    public TagsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Открыть страницу")

    public LoginPage open() {
        driver.get(URL+"app/#/tags");
        log.info("Open page with URL: " + URL);
        return this.open();
    }

    @Step("Теги менеджера заголовков должны быть видны")
    public boolean titleTagsShouldBeVisible() {
        return driver.findElement(TITLE_MANAGER_TAGS).isDisplayed();
    }

    @Step("Нажмать на кнопку для редактирования тегов")
    public void buttonEditTags() {
        driver.findElement(EDIT_TAGS).click();
    }

    @Step("Теги редактирования заголовка должны быть видны")
    public boolean titleEditTagsShouldBeVisible() {
        return driver.findElement(TITLE_EDIT_TAGS).isDisplayed();
    }

    @Step("Очистить имя тега")
    public void clearTagName() {
        driver.findElement(INPUT_TAG_NAME).clear();
    }

    @Step("Нажать на кнопку отправки страницы настроек")
    public void clickOnOkButton() {
        driver.findElement(BUTTON_OK).click();
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}