package org.YadPlus.Test;

import org.YadPlus.Page.Homepage;
import org.YadPlus.Page.LoginPage;
import org.YadPlus.Setup.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginT extends Base {
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        initializeBrowser();
        loginPage = new LoginPage(driver, wait);
    }

    @Test(priority = 1)
    public void openPageAndEnterEmail() {
        loginPage.openLoginPage();
        loginPage.entermail("fdfbe22e48f4@drmail.in");
        loginPage.clickContinue();
    }

    @Test(priority = 2, dependsOnMethods = "openPageAndEnterEmail")
    public void EnterPassLogin() {
loginPage.enterpass("Abdusa1@");
    }

    @Test (priority = 3, dependsOnMethods = "EnterPassLogin")
    public void Log (){

        loginPage.ContenueLogin();


    }
    public Homepage Login() {
        loginPage.ContenueLogin();
    return new Homepage(driver,wait);

    }

    @AfterTest
    public void terminate() throws InterruptedException {
Thread.sleep(10000);
        driver.quit();
    }

}
