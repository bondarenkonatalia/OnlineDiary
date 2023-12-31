package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка логина с валидными данными")
    public void loginVerificationWithValidData() {
        boolean entriesPageIsopened =
                loginPage.open()
                        .login(user, password)
                        .clickLoginButton()
                        .isPageOpen();

        assertTrue(entriesPageIsopened);
    }

    @Test(description = "Проверка логина с не валидными данными")
    public void loginVerificationWithInvalidData() {
        loginPage.open()
                .login("adxeep@mailto.plus", password)
                .clickLoginButton();

        assertEquals(loginPage.getLoginErrorMessage(), "Login failed", "Ошибка ввода");
    }

    @Test(description = "Проверка логина с пустым полем User")
    public void validatingLoginWithEmptyUserField() {
        loginPage.open()
                .login("",password)
                .clickLoginButton();

        assertEquals(loginPage.getMessageAboutEmptyUserField(), "Mandatory field", "Пустое поле");
    }

    @Test(description = "Проверка логина с пустым полем Password")
    public void validatingLoginWithEmptyPasswordField() {
        loginPage.open()
                .login(user, "")
                .clickLoginButton();

        assertEquals(loginPage.getMessageAboutEmptyPasswordField(), "Mandatory field", "Пустое поле");
    }

    @Test(description = "Проверка логина с пустыми полями ")
    public void validatingLoginWithEmptyField() {
        loginPage.open()
                .login("", "")
                .clickLoginButton();

        assertEquals(loginPage.getMessageAboutEmptyUserField(), "Mandatory field", "Пустое поле");
    }
}
