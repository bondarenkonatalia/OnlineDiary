package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UploadImageTest extends BaseTest {
    @Test(description = "Loading File ")
    public void loadingFileFormat() {
        loginPage.open()
                .login("aadxeep@mailto.plus", "Nata1111")
                .clickLoginButton()
                .clickCreateAnEntryButton();
        uploadImagePage.buttonBlockEmage()
                .selectFileLoading()
                .clickButtonSave();

        assertTrue(uploadImagePage.imagePresent());

    }
}
