package base;

import config.ConfigManager;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ZERO);
    }

    protected WebDriver driver() {
        return DriverManager.getDriver();
    }

    protected String baseUrl() {
        return ConfigManager.baseUrl();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
