package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EntriesTest extends BaseTest {
    @Test(description = "Проверка создания новой записи")
    public void creatingNewEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Нельзя упускать возможность чему-то научиться")
                .clickHomeButton();

        assertEquals(entriesPage.gettextEntry(),"Нельзя упускать возможность чему-то научиться","Запись не создана");

    }

    @Test(description = "Проверка редактирования записи")
    public void editEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        entriesPage.open()
                .editingPost("Новый текст")
                .clickHomeButton();

        assertEquals(entriesPage.gettextEntry(),"Новый текст","Запись не изменилась");

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

        assertEquals(entriesPage.gettextEntry(),"Новый текст","Запись не удалена");

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




