package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class EntriesTest extends BaseTest {

    @Test(description = "Проверка создания новой записи")
    public void creatingNewEntry() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Человек всесилен, пока ничем не занят")
                .clickHomeButton();

        assertEquals(entriesPage.getTextEntry(), "Человек всесилен, пока ничем не занят", "Запись не создана");

        entriesPage.selectEntry()
                .clickDeleteEntriesButton();


    }

    @Test(description = "Проверка удаления записи")
    public void deleteEntry() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Человек всесилен, пока ничем не занят")
                .clickHomeButton()
                .selectEntry()
                .clickDeleteEntriesButton();

        assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Запись не удалена");
    }

    @Test(description = "Проверка редактирования записи")
    public void editEntry() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Чтобы в жизнь пришло что-то новое, нужно освободить для него место")
                .clickHomeButton()
                .editingPost("Новый текст")
                .clickHomeButton();

        assertEquals(entriesPage.getTextEntry(), "Новый текст", "Запись не изменилась");

        entriesPage.selectEntry()
                .clickDeleteEntriesButton();

    }

    @Test(description = "Проверка удаления всех записей")
    public void deletingAllEntries() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Чтобы в жизнь пришло что-то новое, нужно освободить для него место")
                .clickHomeButton()
                .selectAllEntries()
                .clickDeleteEntriesButton();

        assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Запись не удалёна");

    }
}




