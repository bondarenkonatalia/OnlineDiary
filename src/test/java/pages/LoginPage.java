package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By USER = By.xpath("//input[@name ='login']");
    public static final By PASSWORD = By.xpath("//input[@name ='password']");
    public static final By LOGIN_BUTTON = By.xpath("//div[@class = 'btn-text-content']");
    public static final By LOGIN_FIELD= By.xpath("//div[@class ='alert alert-danger']");
    public static final By MANDATORY_FIELD_USER = By.xpath("//div[@class='help-block ng-binding']");
    public static final By MANDATORY_FIELD_PASSWORD = By.xpath("//div[contains(text(), 'Mandatory field')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу")

    public LoginPage open() {
        driver.get(URL+"app/#/");
        log.info("Open page with URL: " + URL);
        return this;
    }
    @Step("Ввести логин и пароль")

    public LoginPage login(String user, String password) {
        driver.findElement(USER).sendKeys(user);
        log.info("Enter in the User field " + user);
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Enter in the Password field " + password);
        return this;
    }
    @Step("Нажать кнопку LOGIN")
    public EntriesPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Click on loginButton with xPath:" + LOGIN_BUTTON);
        return new EntriesPage(driver);
    }
    @Step("Получить сообщение об ошибке входа")
    public String getLoginErrorMessage(){
        log.info("Login error message");
        return driver.findElement(LOGIN_FIELD).getText();
    }

    @Step("Получить сообщение о не заполненом поле User")
    public String getMessageAboutEmptyUserField() {
        log.info("Mandatory field");
        return driver.findElement(MANDATORY_FIELD_USER).getText();

    }
    @Step("Получить сообщение о не заполненом поле Password")
    public String getMessageAboutEmptyPasswordField() {
        log.info("Mandatory field");
        return driver.findElement(MANDATORY_FIELD_PASSWORD).getText();
    }
    @Override
    public boolean isPageOpen () {
        return isExist(LOGIN_BUTTON);
    }
}
