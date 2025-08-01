package org.YadPlus.Test;

import org.YadPlus.Page.LoginPage;
import org.YadPlus.Setup.Base;
import org.testng.annotations.*;

public class LoginTest extends Base {
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        initializeBrowser();
        loginPage = new LoginPage(driver, wait);
    }

    @Test(priority = 1)
    public void openPageAndEnterEmail() {
        loginPage.openLoginPage();
        loginPage.enterEmail("gamal.mohamed.test@gmail.com");
            loginPage.clickContinue();
    }

    @Test(priority = 2, dependsOnMethods = "openPageAndEnterEmail")
    public void EnterPassLogin(){

    }

    @AfterClass
    public void tearDown() {
   //     quitBrowser();
    }
}
