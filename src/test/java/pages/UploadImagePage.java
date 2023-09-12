package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

@Log4j2
public class UploadImagePage extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//span[@class = 'cke_button_icon']");
    public static final By IMAGE_BUTTON = By.xpath("//span[@class='cke_button_icon cke_button__image_icon']");
    public static final By SELECT_FILE_BUTTON = By.xpath("//input[@name='txtUpload']");
    public static final By UPLOAD_BUTTON_OK = By.xpath("//a[@title = 'OK']");
    public static final By IMAGE_VISIBILITY= By.xpath("//span[@data-cke-widget-wrapper='1']");

    public UploadImagePage(WebDriver driver) {
        super(driver);
    }


    @Step("Нажать кнопку сохранить")
    public UploadImagePage clickButtonSave() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("Click" + SAVE_BUTTON);
        return this;
    }

    @Step("Нажать кнопку IMAGE_BUTTON")
    public UploadImagePage buttonBlockEmage() {
        driver.findElement(IMAGE_BUTTON).click();
        log.info("Select button block");
        return this;
    }

    @Step("Выбрать загрузку файла")
    public UploadImagePage selectFileLoading() {
        WebElement element = driver.findElement((By.xpath("//iframe[@title='Upload']")));
        driver.switchTo().frame(element);
        File file = new File("src/test/resources/ЧЕЛОВЕЧЕК.png");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Uploading a picture");
        driver.switchTo().defaultContent();
        driver.findElement(UPLOAD_BUTTON_OK).click();
        log.info("Click button ok");
        return this;
    }
    @Step("Изображение должно присутствовать на странице")
    public boolean imagePresent() {
        return driver.findElement(IMAGE_VISIBILITY).isDisplayed();
    }


    @Override
    public boolean isPageOpen() {
        return isExist(IMAGE_BUTTON);
    }
}
