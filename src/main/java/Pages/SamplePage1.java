package Pages;

import org.openqa.selenium.WebDriver;

public class SamplePage1 {

    private WebDriver driver;

    public SamplePage1(WebDriver driver){
        this.driver=driver;
    }

    public void performFirstAction(){
        System.out.println("perform first action");
    }
}
