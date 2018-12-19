import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo {

    AppiumDriver driver =null;
    @Test
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("udid","ZW2222DWD3");
        capabilities.setCapability("deviceName","Motorola c Plus");
        capabilities.setCapability("automationName","sample 123");
        capabilities.setCapability("browserName","Chrome");
        capabilities.setCapability("noReset","True");
        capabilities.setCapability("appActivity", "com.android.settings.Settings");

        //capabilities.setCapability("app","Chrome");


        System.setProperty("webdriver.chrome.driver","/Users/rahulmittapalli/Downloads/Selenium drivers/chromedriver");
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.get("https://www.facebook.com");
        
//        driver.findElements(By.xpath(""));

    }
//    @AfterClass
//    public void tearDown()throws Exception{
//        driver.quit();
//    }
//    @Test
//     public void Browser()
//    {
//
//        driver.findElement(By.id("com.android.chrome:id/url_bar\n")).sendKeys("https://www.google.com");
//    }



}
