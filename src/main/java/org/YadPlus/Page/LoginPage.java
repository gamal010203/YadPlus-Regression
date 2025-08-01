package org.YadPlus.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.xpath("(//input[@id='email'])[2]");
//    private By emailField = By.id("email");

    private By continueButton = By.id("submit-login");

    private By PassField = By.xpath("//body/main/div/div[2]/div[3]/div[2]/form/div[1]/span");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openLoginPage() {
        driver.get("https://dev.yad-plus.com/en/auth");
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        System.out.println("Button text: " + continueBtn.getText());
        continueBtn.click();
    }
}

