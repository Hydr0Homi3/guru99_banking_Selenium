package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogInPage {

    @FindBy(name = "uid")
    private WebElement userIDInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    private String alertText;

    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ManagerHomePage logInValidData(String userID, String password) {
        userIDInput.sendKeys(userID);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ManagerHomePage(driver);
    }

    public LogInPage logInInvalidData(String userID, String password) {
        userIDInput.sendKeys(userID);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public String getAlertText() {
        alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }
}
