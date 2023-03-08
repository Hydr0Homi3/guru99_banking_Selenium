package tests;

import model.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebElement;
import pages.LogInPage;

public class LogInTest extends BaseTest {

    @Test
    public void logInValidDataTest() {
        Customer customer = new Customer();
        WebElement managerHomePage = new LogInPage(driver)
                .logInValidData(customer.getUserID(), customer.getPassword())
                .getHomePageTitle();

        assertEquals(managerHomePage.getText(), "Guru99 Bank");
        assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
    }

    @Test
    public void logInInvalidUserIdValidPasswordTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("Kubala", "guzedEt");

        assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }

    @Test
    public void logInValidUserIdInvalidPasswordTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("mngr483341", "randompassword");

        assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }

    @Test
    public void logInInvalidUserIdInvalidPasswordTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("Kubala", "randompassword");

        assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }
}
