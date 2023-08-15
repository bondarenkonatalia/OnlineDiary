package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test(description = "Переход на страницу аввторизации")
    public void goToLoginPage(){
        homePage.open()
                .clickLoginPrimary()
                .isPageOpen();

        assertTrue(loginPage.isPageOpen());

    }
}
