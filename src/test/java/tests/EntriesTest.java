package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EntriesTest extends BaseTest {

    @Test(description = "Проверка создания новой записи")
    public void creatingNewEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Человек всесилен, пока ничем не занят")
                .clickHomeButton();

        assertEquals(entriesPage.getTextEntry(), "Человек всесилен, пока ничем не занят", "Запись не создана");

    }
    @Test(description = "Проверка удаления записи")
    public void deleteEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .selectEntry()
                .clickDeleteEntriesButton();


        assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Entry is not deleted");
    }

    @Test(description = "Проверка редактирования записи")
    public void editEntry() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .open()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Чтобы в жизнь пришло что-то новое, нужно освободить для него место")
                .clickHomeButton()
                .editingPost("Новый текст")
                .clickHomeButton();

        assertEquals(entriesPage.getTextEntry(), "Новый текст", "Запись не изменилась");

    }

    @Test(description = "Проверка удаления всех записей")
    public void deletingAllEntries() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Чтобы в жизнь пришло что-то новое, нужно освободить для него место")
                .clickHomeButton()
                .selectAllEntries()
                .clickDeleteEntriesButton();


        assertTrue(entriesPage.isThereNoEntries());

    }
}




