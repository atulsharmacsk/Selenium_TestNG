package Tests;
import Managers.PageManager;
import org.testng.annotations.Test;

public class TestClass1 extends BaseTest{

    @Test(description = "Test 1")
    public void test1(){
        pageManager.getSamplePage1().performFirstAction();
        System.out.println(driver.getTitle());
    }

//    @Test(description = "Test 3")
//    public void test3(){
//        pageManager.getSamplePage3().enterFilter("in progress");
//        driver.navigate().back();
//        driver.navigate().forward();
//        pageManager.getSamplePage3().enterFilter("in progress");
//
//    }
}
