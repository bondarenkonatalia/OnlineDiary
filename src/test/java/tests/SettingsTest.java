package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

    public class SettingsTest extends BaseTest {
        String textLanguage = "Modifications enregistrées";

        @Test(description = "Проверка выбора языка")
        public void selectLanguage() {
            loginPage.open()
                    .login("aadxeep@mailto.plus", "Nata1111")
                    .clickLoginButton()
                    .open();
            settingsPage.clickSettingButton()
                    .selectSettingLanguage()
                    .selectLanguage()
                    .clickButtonOkLanguage();

            assertEquals(settingsPage.gettextMessageLanguage(), textLanguage, "Текст не совпадает");

        }
    }