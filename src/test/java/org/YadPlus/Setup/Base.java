package org.YadPlus.Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.YadPlus.Page.Homepage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Homepage homePage;

    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @BeforeClass
    public void setUp() {
        initializeBrowser();
    }

    @BeforeMethod
    public void goToHomepage() {
        homePage = new Homepage(driver, wait);
    }

    @AfterMethod
    public void captureOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                org.openqa.selenium.io.FileHandler.copy(
                        src,
                        new File("resources/screenshots/" + result.getName() + ".png")
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
