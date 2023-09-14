package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class TegTest extends BaseTest {

    @Test(description = "Проверка создания тега")
    public void createTeg() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .open()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Даже если вас съели – у вас два выхода")
                .clickHomeButton();
        tagsPage.clickEntries()
                .writeTextToTag("TEG")
                .clickOk()
                .clickHomeButton();

        assertEquals(tagsPage.getTextListTeg(), "TEG", "Тег не создан");

    }

    @Test(description = "Проверка удаления тега")
    public void deleteTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .open()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Счастлив не тот, у кого много, а тот, кому хватает")
                .clickHomeButton();
        tagsPage.clickEntries()
                .writeTextToTag("TEG")
                .clickOk()
                .clickHomeButton();
        tagsPage.clickButtonManagerTags()
                .buttonDeleteTags();

        assertEquals(tagsPage.noTegOnPage(), "No tags", "Тег не удалён");


    }

    @Test(description = "Проверка редактирования  тега")
    public void editTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .open()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("В жизни нужно стремиться обгонять не других, а самого себя.")
                .clickHomeButton();
        tagsPage.clickEntries()
                .writeTextToTag("TEG")
                .clickOk()
                .clickHomeButton()
                .clickButtonManagerTags()
                .buttonEditTags()
                .createTagName("NEW_TEG")
                .clickOnOkButton();

        assertEquals(tagsPage.getTextTeg(), "NEW_TEG", "Тег не изменён");
    }

}