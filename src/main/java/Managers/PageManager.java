package Managers;

import Pages.SamplePage1;
import Pages.SamplePage2;
import Pages.SamplePage3;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private SamplePage1 samplePage1;
    private SamplePage2 samplePage2;
    private SamplePage3 samplePage3;

    private WebDriver driver;

    public PageManager(){}
    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public SamplePage1 getSamplePage1() {
        return (samplePage1 == null) ? new SamplePage1(driver) : samplePage1;
    }

    public SamplePage2 getSamplePage2() {
        return (samplePage2 == null) ? new SamplePage2(driver) : samplePage2;
    }

    public SamplePage3 getSamplePage3() {
        return (samplePage3 == null) ? new SamplePage3(driver) : samplePage3;
    }

    public String getLocator(String locatorWithValue){
        return locatorWithValue.substring(0,locatorWithValue.indexOf("@"));
    }

    public String getLocatorValue(String locatorWithValue){
        return locatorWithValue.substring(locatorWithValue.indexOf("@")+1);
    }
}
