package tests;

import model.Customer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {

    @Test
    public void logInValidDataTest() {
        Customer customer = new Customer();
        WebElement managerHomePage = new LogInPage(driver)
                .logInValidData(customer.getUserID(), customer.getPassword())
                .getHomePageTitle();

        Assert.assertEquals(managerHomePage.getText(), "Guru99 Bank");
    }

    @Test
    public void logInInvalidDataTest() {
        LogInPage logInPage = new LogInPage(driver)
                .logInInvalidData("Kubala", "randomPassword");

        Assert.assertEquals(logInPage.getAlertText(), "User or Password is not valid");
    }
}
