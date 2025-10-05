package org.YadPlus.TestClient;

import org.YadPlus.Page.Homepage;
import org.YadPlus.Page.LoginPage;
import org.YadPlus.Setup.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClientLoginTest extends Base {
    private LoginPage loginPage;
    private Homepage homepage;

    @BeforeClass
    public void setup() {
        initializeBrowser();
        loginPage = new LoginPage(driver, wait);
        homepage = new Homepage(driver, wait);
    }

    @Test
    public void successfulLoginTest() {
        loginPage.openLoginPage();
        loginPage.entermail("a7684d1f33dd@drmail.in");
        loginPage.clickContinue();
        loginPage.enterpass("Abdu123!");
        loginPage.ContenueLogin();
        Assert.assertTrue(homepage.isUserAvatarDisplayed(), "Login failed: User avatar not displayed.");
    }

    @AfterTest
    public void terminate() throws InterruptedException {
Thread.sleep(10000);
        driver.quit();
    }

}
