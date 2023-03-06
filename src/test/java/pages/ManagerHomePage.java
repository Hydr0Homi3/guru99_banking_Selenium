package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {

    @FindBy(xpath = "//a[text()='Manager']")
    private WebElement managerLink;

    private WebDriver driver;

    public ManagerHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getManagerLink() {
        return managerLink;
    }
}


