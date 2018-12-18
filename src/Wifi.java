import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Wifi {

    AppiumDriver driver =null;
    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","6.0.1");
        capabilities.setCapability("udid","ZY2226MHT8");
        capabilities.setCapability("deviceName","Moto");
        capabilities.setCapability("automationName","sample1");
        //capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("noReset","True");
        File app=new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
        capabilities.setCapability("app", app.getAbsolutePath());


        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //Wifi on or off condition
//        WebElement button=driver.findElement(By.id("com.app.wifianalyzer:id/wifi_disabled_view"));
//        System.out.println(button.isDisplayed());
//        button.click();

//Location On and Off condition
        //allow permission

        allowpermission();
    WebElement location=driver.findElement(By.id("com.app.wifianalyzer:id/dialog_ok"));
    System.out.println(location.isDisplayed());
    location.click();
    Thread.sleep(5000);
    //driver.findElement(By.className("android.widget.RelativeLayout")).click();
    //Thread.sleep(4000);
        //
    driver.findElement(By.id("android:id/switchWidget"));


//        WebElement text =driver.findElement(By.id("android:id/title"));
//    if(text.equals("Location"))
//    {
//        driver.findElement(By.id("android:id/switchWidget")).click();
//    }
    WebElement backbutton=driver.findElement(By.id("Navigate up"));
    backbutton.click();


        //Detailed information of Wifi connected

//        driver.findElement(By.id("com.app.wifianalyzer:id/scan_btn")).click();
//        Thread.sleep(5000);
//        WebElement text=driver.findElement(By.id("com.app.wifianalyzer:id/best_practices_txt"));
//        System.out.println(text);
//
//        //List of all devices
//       driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
//        Thread.sleep(10000);
//        List <MobileElement>list=driver.findElements(By.id("com.app.wifianalyzer:id/wifiScanList"));
//       System.out.println("List size is "+list.size());
//
//

//        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc="Navigate up"]")).click();
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

    public void allowpermission()
    {
        while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0)
        {
            driver.findElement(MobileBy.xpath("//*[@class='android.widget.button'][2]")).click();
        }
    }

}
