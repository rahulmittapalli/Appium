import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Sony {

    AppiumDriver driver =null;
    @Test
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("udid","YT910XCBVR");
        capabilities.setCapability("deviceName","Sony");
        capabilities.setCapability("automationName","sample 1");
       // capabilities.setCapability("browserName","Chrome");
        capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("noReset","True");
        //capabilities.setCapability("appActivity", "com.android.settings.Settings");
        File app=new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        //capabilities.setCapability("app","Chrome");


        System.setProperty("webdriver.chrome.driver","/Users/rahulmittapalli/Downloads/Selenium drivers/chromedriver");
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.findElement(By.id("com.app.wifianalyzer:id/main_toolbar")).click();
        List <MobileElement>list=driver.findElements(By.id("com.app.wifianalyzer:id/wifiScanList"));
        System.out.println("List size is "+list.size());


        //driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc="Navigateup"]")).click();
        //driver.findElement(By.id("com.android.settings:id/title")).click();
        //driver.get("https://www.facebook.com");

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
