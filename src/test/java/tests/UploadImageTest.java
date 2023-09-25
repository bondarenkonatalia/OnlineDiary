package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class UploadImageTest extends BaseTest {
    @Test(description = "Проверка загрузки файла при создании записи")
    public void loadingFileFormat() throws InterruptedException {
        loginPage.open()
                .login(user, password)
                .clickLoginButton()
                .clickCreateAnEntryButton();
        uploadImagePage.buttonBlockImage()
                .selectFileLoading()
                .clickButtonSave();

        assertTrue(uploadImagePage.imagePresent());

    }
}
