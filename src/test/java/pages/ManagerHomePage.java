package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {

    @FindBy(xpath = ("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"))
    private WebElement mangerID;

    private WebDriver driver;

    public ManagerHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getMangerID() {
        return mangerID;
    }
}


