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
                .writeTextToTag("TEG 3")
                .clickOk()
                .clickHomeButton();

        assertEquals(tagsPage.getTextListTeg(), "TEG 3", "Тег не создан");

    }

    @Test(description = "Проверка удаления тега")
    public void deleteTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .open()
                .clickCreateAnEntryButton()
                .createNewEntryWithText("Даже если вас съели – у вас два выхода")
                .clickHomeButton();
        tagsPage.clickEntries()
                .writeTextToTag("TEG 3")
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
                .createNewEntryWithText("Даже если вас съели – у вас два выхода")
                .clickHomeButton();
        tagsPage.clickEntries()
                .writeTextToTag("TEG 1")
                .clickOk()
                .clickHomeButton()
                .clickButtonManagerTags()
                .buttonEditTags()
                .createTagName("TEG33")
                .clickOnOkButton();

        assertEquals(tagsPage.getTextTeg(), "TEG33", "Тег не изменён");
    }

}