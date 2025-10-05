package org.YadPlus.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    WebDriver driver ;
    WebDriverWait wait;
    private By userAvatar = By.xpath("//button[@data-testid='Header-user-avatar-button']");

    public Homepage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isUserAvatarDisplayed() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatar));
        return avatar.isDisplayed();
    }
}
