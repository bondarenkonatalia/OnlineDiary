package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
                .writeTextToTag("TEG 2")
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