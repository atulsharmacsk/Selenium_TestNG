package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumUtils {
    WebDriver driver;

    public SeleniumUtils(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElementEnabled(String locWithValue){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        wait.until((d)->{
            int temp=locWithValue.indexOf("@");
            return getElement(locWithValue.substring(0,temp), locWithValue.substring(temp+1)).isDisplayed();
        });
    }

    public WebElement getElement(String Locator, String value){
        switch(Locator){
            case "ID":
                return driver.findElement(By.id(value));
            case "XPATH":
                return driver.findElement(By.xpath(value));
            case "CSS":
                return driver.findElement(By.cssSelector(value));
            default:
            throw new RuntimeException("add locatorss");
        }
    }

    public void clickUsingWait(By by){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoreAll(List.of(NoSuchElementException.class, ElementClickInterceptedException.class, StaleElementReferenceException.class));
        wait.until((d)->{
                    return isElementClickable(driver,by);
                });
    }

    public boolean isElementClickable(WebDriver driver, By by){
        try {
            driver.findElement(by).click();
            return true;
        }catch (Exception e){
            if(e instanceof NoSuchElementException || e instanceof  ElementClickInterceptedException || e instanceof  StaleElementReferenceException)
                return false;
            else
                throw new RuntimeException("Add the exception to isElementClickable & clickUsingWait");
        }
    }

}
