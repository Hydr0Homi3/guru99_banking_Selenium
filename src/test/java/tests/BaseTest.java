package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("//*[@id='save']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}