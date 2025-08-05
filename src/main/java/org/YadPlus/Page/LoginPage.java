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
    private By PasswordField = By.xpath("//input[@id=\"password\"]");
    private By containnuepassbutton = By.xpath("(//button)[3]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openLoginPage() {
        driver.get("https://dev.yad-plus.com/en/auth");
    }

    public void entermail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void enterpass(String Password) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(PasswordField));
        emailInput.clear();
        emailInput.sendKeys(Password);
    }

    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        System.out.println("Button text: " + continueBtn.getText());
        continueBtn.click();
    }
    public void ContenueLogin() {
        WebElement continueBtn1 = wait.until(ExpectedConditions.elementToBeClickable(containnuepassbutton));
        System.out.println("Button text: " + continueBtn1.getText());
        continueBtn1.click();
    }
}

