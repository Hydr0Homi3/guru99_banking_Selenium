package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {

    @FindBy(xpath = "//h2[@class='barone']")
    private WebElement homePageTitle;

    private WebDriver driver;

    public ManagerHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHomePageTitle() {
        return homePageTitle;
    }
}


