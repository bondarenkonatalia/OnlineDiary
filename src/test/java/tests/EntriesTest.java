package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import tests.base.BaseTest;

import static java.awt.SystemColor.text;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EntriesTest extends BaseTest {
    @Test(description = "Проверка создания новой записи")
    public void creatingNewEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open()
                .createNewEntryWithText("Победившему себя ничего не страшно")
                .clickHomeButton();
    }

    @Test(description = "Проверка редактирования записи")
    public void editEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open()
                .editingPost("Новый текст")
                .clickHomeButton();

    }

    @Test(description = "Проверка удаления записи")
    public void deleteEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open()
                .selectEntry()
                .clickDeleteEntriesButton()
                .gettextEntry();

    }

    @Test(description = "Проверка удаления всех записей")
    public void deletingAllEntries() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open()
                .selectAllEntries()
                .clickDeleteEntriesButton();
    }
}




