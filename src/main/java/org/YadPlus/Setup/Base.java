package org.YadPlus.Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.YadPlus.Page.Homepage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Homepage homePage;

    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

@BeforeMethod
public void goToHomepage(){
    driver.get("https://dev.yad-plus.com/en/auth"); // your base URL
    homePage = new Homepage(driver, wait); // if homepage is accessible directly

}
    @AfterMethod
    public void captureOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                org.openqa.selenium.io.FileHandler.copy(src,
                        new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    @AfterClass
    public void quitBrowser () {
        if (driver != null) {
            driver.quit();
        }

    }
}
