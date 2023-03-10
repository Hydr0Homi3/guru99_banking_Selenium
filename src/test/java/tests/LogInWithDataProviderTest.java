package tests;

import model.Customer;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.ExcelReader;

import java.io.IOException;


public class LogInWithDataProviderTest extends BaseTest {

    @Test(testName = "Log in with data provider", dataProvider = "data")
    public void logInWithDataProvider(String username, String password) {
        Customer customer = new Customer();
        if (username.equals(customer.getUserID()) && password.equals(customer.getPassword())) {
            WebElement managerHomePage = new LogInPage(driver)
                    .logInValidData(username, password)
                    .getMangerID();

            assertEquals(managerHomePage.getText().replaceAll("Manger Id : ", ""), customer.getUserID());
            assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
        } else {                                                                        // tests either invalid username, password or both
            LogInPage logInPage = new LogInPage(driver)
                    .logInInvalidData(username, password);

            assertEquals(logInPage.getAlertText(), "User or Password is not valid");
        }
    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }
}

