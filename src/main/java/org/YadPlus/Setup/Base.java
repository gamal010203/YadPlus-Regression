package org.YadPlus.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
