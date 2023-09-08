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
                .open();
        tagsPage.clickEntries()
                .writeTextToTag("TEG 1")
                .clickOk()
                .clickHomeButton();

        assertEquals(tagsPage.getTextListTeg(), "TEG 1", "Тег не создан");

    }

    @Test(description = "Проверка редактирования  тега")
    public void editTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        tagsPage.clickButtonManagerTags()
                .buttonEditTags()
                .createTagName("TEG33")
                .clickOnOkButton();

        assertEquals(tagsPage.getTextTeg(), "TEG33", "Тег не изменён");
    }

    @Test(description = "Проверка удаления тега")
    public void deleteTag() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton();
        tagsPage.clickButtonManagerTags()
                .buttonDeleteTags();

        assertEquals(tagsPage.noTegOnPage(), "No tags", "Тег не удалён");


    }


}