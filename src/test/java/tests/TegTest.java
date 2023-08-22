package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TegTest extends BaseTest {
    @Test(description = "Проверка редактирования  тега")
    public void editTag() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();
        tagsPage.clickButtonManagerTags();
        tagsPage.buttonEditTags();
        tagsPage.clearTagName();
        tagsPage.createTagName("Тест 1");
        tagsPage.clickOnOkButton();
    }
}