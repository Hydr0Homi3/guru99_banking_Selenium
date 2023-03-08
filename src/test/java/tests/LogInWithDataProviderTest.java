package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.DriverFactory;
import utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInWithDataProviderTest extends BaseTest {

    @Test(dataProvider = "data")
    public void logInWithDataProvider(String username, String password) {
        if (username.equals("mngr483341") && password.equals("guzedEt")) {
            WebElement managerHomePage = new LogInPage(driver)
                    .logInValidData(username, password)
                    .getHomePageTitle();

            assertEquals(managerHomePage.getText(), "Guru99 Bank");
            assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
        } else {   // tests either invalid username, password or both
            LogInPage logInPage = new LogInPage(driver)
                    .logInInvalidData(username, password);

            assertEquals(logInPage.getAlertText(), "User or Password is not valid");
        }
    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }

    /* TODO: remove this after I learn how to use data providers in JUnit and won't be forced to use testNg */

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("//*[@id='save']")).click();
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}
