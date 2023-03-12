package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.ExcelReader;
import utils.Helper;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class LogInRefactoredTest extends BaseTest {

    @Test(testName = "Log in with data provider", dataProvider = "data")
    public void logInRefactored(String username, String password) throws IOException {
        LogInPage logInPage = new LogInPage(driver)
                .logIn(username, password);

        try {
            assertEquals(logInPage.getAlertText(), "User or Password is not valid");
        } catch (NoAlertPresentException e) {
            String mangerId = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"))
                    .getText()
                    .replaceAll("Manger Id : ", "");
            assertEquals(username, mangerId);
            assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
            Helper.getScreenshot(driver);
        }
    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }
}
