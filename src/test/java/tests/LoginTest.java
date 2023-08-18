package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка логина с валидными данными")
    public void loginVerificationWithValidData() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();
        loginPage.isPageOpen();

        assertTrue(entriesPage.titleVisible());
    }
    @Test(description = "Проверка логина с не валидными данными")
    public void loginVerificationWithInvalidData() {
        loginPage.open();
        loginPage.login("adxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getLoginErrorMessage(), "Login failed", "Ошибка ввода");
    }
    @Test(description = "Проверка логина с пустым полем User")
    public void validatingLoginWithEmptyUserField() {
        loginPage.open();
        loginPage.login("", "Nata1111");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getMessageAboutEmptyUserField(), "Mandatory field", "Пустое поле");
    }
    @Test(description = "Проверка логина с пустым полем Password")
    public void validatingLoginWithEmptyPasswordField() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getMessageAboutEmptyPasswordField(), "Mandatory field", "Пустое поле");
    }
    @Test(description = "Проверка логина с пустыми полями ")
    public void validatingLoginWithEmptyField() {
        loginPage.open();
        loginPage.login("", "");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getMessageAboutEmptyUserField(),"Mandatory field", "Пустое поле");
    }
}
