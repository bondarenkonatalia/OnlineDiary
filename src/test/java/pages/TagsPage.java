package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TagsPage extends BasePage {

    public static final By MANAGER_TAGS_BUTTON = By.xpath("//a[@class='tags__manage-link']");
    public static final By TITLE_MANAGER_TAGS = By.xpath("//div[@class='content-container clearfix ng-scope']//h1");
    public static final By EDIT_TAGS = By.xpath("//a[@ng-href='#/tags/289432/edit']");
    public static final By INPUT_TAG_NAME = By.xpath("//input[@class='form-control ng-pristine ng-valid']");
    public static final By BUTTON_OK = By.xpath("//button[@class='btn btn-default']");

    public TagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку для редактирования тегов")
    public void buttonEditTags() {
        driver.findElement(EDIT_TAGS).click();
    }

    @Step("Очистить имя тега")
    public void clearTagName() {
        driver.findElement(INPUT_TAG_NAME).clear();
    }
    @Step("Создать имя тега")
    public void createTagName(String text) {
        driver.findElement(INPUT_TAG_NAME).sendKeys(text);
    }
    @Step("Нажать кнопку OK")
    public void clickOnOkButton() {
        driver.findElement(BUTTON_OK).click();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(TITLE_MANAGER_TAGS);
    }
}