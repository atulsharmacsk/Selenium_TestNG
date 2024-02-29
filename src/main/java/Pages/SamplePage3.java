package Pages;

import Managers.PageManager;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamplePage3 extends PageManager {
    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    String cssSearchFilter="CSS@input[id*='filter']";

    public SamplePage3(WebDriver driver){
        this.driver=driver;
        seleniumUtils=new SeleniumUtils(driver);
    }

    public void enterFilter(String value){
        seleniumUtils.waitForElementEnabled(cssSearchFilter);
        driver.findElement(By.cssSelector(getLocatorValue(cssSearchFilter))).sendKeys(value);
    }
}
