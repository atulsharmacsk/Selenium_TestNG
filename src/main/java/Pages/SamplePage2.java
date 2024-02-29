package Pages;

import org.openqa.selenium.WebDriver;

public class SamplePage2 {

    private WebDriver driver;

    public SamplePage2(WebDriver driver){
        this.driver=driver;
    }

    public void performSecondAction(){
        System.out.println("perform second action");
    }
}
