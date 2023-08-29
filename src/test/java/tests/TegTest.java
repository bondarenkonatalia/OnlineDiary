package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TegTest extends BaseTest {
    @Test(description = "Проверка редактирования  тега")
    public void editTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        tagsPage.clickButtonManagerTags()
                .buttonEditTags()
                .createTagName("TEG 3")
                .clickOnOkButton();
    }

    @Test(description = "Проверка создания тега")
    public void createTeg() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open();
        tagsPage.clickEntries()
                .writeTextToTag("TEG 1")
                .clickOk();
    }
    @Test(description = "Проверка удаления тега")
    public void deleteTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        tagsPage.clickButtonManagerTags()
                .buttonDeleteTags()
                .gettextTeg();

    }

}