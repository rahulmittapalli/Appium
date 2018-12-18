import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class wifienable {

    AppiumDriver driver = null;

    @BeforeTest

    public void wificheck() throws  MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("udid", "ZY2226MHT8");
        capabilities.setCapability("deviceName", "Moto");
        capabilities.setCapability("automationName", "sample1");
        capabilities.setCapability("noReset", "True");
        capabilities.setCapability("autoGrantPermissions", "True");
        File app = new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void setup() throws InterruptedException {
        //Detailed information of Wifi Enabled
        driver.findElement(By.id("com.app.wifianalyzer:id/wifi_enable_btn")).click();
        Thread.sleep(3000);
        driver.closeApp();
    }
}
