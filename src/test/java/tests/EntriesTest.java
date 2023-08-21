package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EntriesTest extends BaseTest {
    @Test(description = "Проверка создания новой записи")
    public void creatingNewEntry() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();
        entriesPage.open();
        entriesPage.createNewEntryWithText("Смысл жизни есть всегда. Его нужно только найти");
        entriesPage.clickHomeButton();

    }
    @Test(description = "Проверка редактирования записи")
    public void editEntry() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();
        entriesPage.open();
        entriesPage.editingPost("Текст изменён");
        entriesPage.clickHomeButton();

    }
    @Test(description = "Проверка удаления записи")
    public void deleteEntry() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();
        entriesPage.open();
        entriesPage.selectEntry();
        entriesPage.clickDeleteEntriesButton();
    }
    @Test(description = "Проверка удаления записи")
    public void deletingAllEntries() {
        loginPage.open();
        loginPage.login("aadxeep@mailto.plus", "Nata1111");
        loginPage.clickLoginButton();
        entriesPage.open();
        entriesPage.selectAllEntries();
        entriesPage.clickDeleteEntriesButton();
    }
}




