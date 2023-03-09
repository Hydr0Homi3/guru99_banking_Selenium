package tests;

import model.Customer;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.LogInPage;



public class LogInTest extends BaseTest {

    @Test(testName = "Log in with valid user id and valid password")
    public void logInValidDataTest() {
        Customer customer = new Customer();
        WebElement managerHomePage = new LogInPage(driver)
                .logInValidData(customer.getUserID(), customer.getPassword())
                .getHomePageTitle();

        assertEquals(managerHomePage.getText(), "Guru99 Bank");
        assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
    }

    @Test(testName = "Log in with invalid user id and valid password")
    public void logInInvalidUserIdValidPasswordTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("Kubala", "guzedEt");

        assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }

    @Test(testName = "Log in with valid user id and invalid password")
    public void logInValidUserIdInvalidPasswordTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("mngr483341", "randompassword");

        assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }

    @Test(testName = "Log in with invalid user id and invalid password")
    public void logInInvalidUserIdInvalidPasswordTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("Kubala", "randompassword");

        assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }
}
