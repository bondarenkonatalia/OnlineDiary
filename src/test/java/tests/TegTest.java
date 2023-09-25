package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class TegTest extends BaseTest {

    @Test(description = "Проверка создания тега")
    public void createTeg() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Даже если вас съели – у вас два выхода")
                .clickHomeButton()
                .selectEntry();
        tagsPage.writeTextToTag("TEG")
                .clickOk()
                .clickHomeButton();

        assertEquals(tagsPage.getTextListTeg(), "TEG", "Тег не создан");


        tagsPage.clickHomeButton()
                .clickButtonManagerTags()
                .buttonDeleteTags()
                .clickHomeButton();
        entriesPage.selectEntry()
                .clickDeleteEntriesButton();

    }

    @Test(description = "Проверка удаления тега")
    public void deleteTag() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Счастлив не тот, у кого много, а тот, кому хватает")
                .clickHomeButton()
                .selectEntry();
        tagsPage.writeTextToTag("TEG")
                .clickOk()
                .clickHomeButton()
                .clickButtonManagerTags()
                .buttonDeleteTags()
                .clickHomeButton();

        assertEquals(tagsPage.noTegOnPage(), "No tags", "Тег не удалён");

        entriesPage.selectEntry()
                .clickDeleteEntriesButton();

    }

    @Test(description = "Проверка редактирования  тега")
    public void editTag() {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("В жизни нужно стремиться обгонять не других, а самого себя.")
                .clickHomeButton()
                .selectEntry();
        tagsPage.writeTextToTag("TEG")
                .clickOk()
                .clickHomeButton()
                .clickButtonManagerTags()
                .buttonEditTags()
                .createTagName("NEW_TEG")
                .clickOnOkButton()
                .clickHomeButton();

        assertEquals(tagsPage.getTextTeg(), "NEW_TEG", "Тег не изменён");

        tagsPage.clickHomeButton()
                .clickButtonManagerTags()
                .buttonDeleteTags()
                .clickHomeButton();
        entriesPage.selectEntry()
                .clickDeleteEntriesButton();

    }

}