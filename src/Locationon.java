import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Locationon {

    AppiumDriver driver = null;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("udid", "ZY2226MHT8");
        capabilities.setCapability("deviceName", "Moto");
        capabilities.setCapability("automationName", "sample1");
        //capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("noReset", "True");
        File app = new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", "True");
        capabilities.setCapability("autoAcceptAlerts", "True");




        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebElement location = driver.findElement(By.id("com.app.wifianalyzer:id/dialog_ok"));
        System.out.println(location.isDisplayed());
        location.click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.android.settings:id/switch_widget")).click();
        Thread.sleep(3000);
        driver.launchApp();
        Thread.sleep(3000);
        driver.closeApp();

    }


    }
