package scripts;

import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    static Logger logger = LogManager.getLogger("testBookingFromHomePage");

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(String browser){
        logger.info("Setting up driver");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setDriver(browser);
        driver = driverFactory.getDriver();
        driver.get("https://demo1.cybersoft.edu.vn/");
        logger.info("Da truy cap thanh cong.");
    }
    public WebDriver getDriver() {return driver;}
    void teardown() {
        driver.quit();
    }
    @AfterMethod
    public  void  tearDown(){
        driver.quit();
    }
}