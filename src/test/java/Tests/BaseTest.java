package Tests;

import Managers.FileManager;
import Managers.PageManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    PageManager pageManager;

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("BrowserName");
        if (browser.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.toLowerCase().contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(FileManager.getInstance().getConfigReader().getURL());

        pageManager=new PageManager(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
