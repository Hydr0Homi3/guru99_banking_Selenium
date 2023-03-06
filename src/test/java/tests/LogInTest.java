package tests;

import model.Customer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ManagerHomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInValidDataTest() {
        Customer customer = new Customer();
        WebElement managerHomePage = new LogInPage(driver)
                .logInValidData(customer.getUserID(), customer.getPassword())
                .getManagerLink();

        Assert.assertEquals(managerHomePage.getText(), "Manager");
    }
}
