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
import java.util.NoSuchElementException;

public class Wifilogin {

    AppiumDriver driver = null;

    @BeforeTest

    public void wifiCheck() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "8.1.0");
        //capabilities.setCapability("udid", "9323542a");
        capabilities.setCapability("deviceName", "Sony");
        capabilities.setCapability("automationName", "sample1");
        capabilities.setCapability("noReset", "True");
        capabilities.setCapability("autoGrantPermissions", "True");
        capabilities.setCapability("autoAcceptAlerts", "True");
        //capabilities.setCapability("avd", "Nexus_6_API_22");

//        String Name=driver.getCapabilities().getCapability("deviceName").toString();
//        System.out.println(Name);
//        String Version =driver.getCapabilities().getCapability("CapabilityType.VERSION").toString();
//        System.out.println(Version);
        File app = new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wifiChecking(driver);
        locationChecking(driver);
    }

    @Test
    public void setup() throws InterruptedException {

        //Detailed information of Wifi connected
        driver.launchApp();
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.app.wifianalyzer:id/channel_ratings_btn")).click();
        List<WebElement> values = driver.findElements(By.className("android.support.v7.app.a$c"));
        System.out.println(values.size());
        values.get(1).click();
        WebElement FiveText = driver.findElement(By.id("com.app.wifianalyzer:id/five_ghz_not_supported"));
        System.out.println(FiveText.getText());
        Assert.assertEquals(FiveText.getText(), "This device does not support 5GHZ mode");
        Thread.sleep(3000);
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_channel")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.app.wifianalyzer:id/dialog_ok")).click();
        values.get(0).click();
        Thread.sleep(2000);
        driver.findElement(By.className("android.widget.ImageButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.app.wifianalyzer:id/channel_graph_btn")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_rescan")).click();
        Thread.sleep(2000);
        WebElement five = driver.findElement(By.id("com.app.wifianalyzer:id/five_GHZ"));
        String name = five.getText();
        System.out.println(name);
        five.click();
        Thread.sleep(3000);
        Assert.assertEquals(FiveText.getText(), "This device does not support 5GHZ mode");
        Thread.sleep(3000);
        driver.findElement(By.id("com.app.wifianalyzer:id/two_GHZ")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("android.widget.ImageButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_rescan")).click();
        System.out.println(driver.findElement(By.className("android.widget.ProgressBar")).isDisplayed());
        driver.findElement(By.className("android.widget.ImageButton")).click();
        Thread.sleep(2000);
        WebElement wifisymbol = driver.findElement(By.id("com.app.wifianalyzer:id/wifi_signal_level"));
        System.out.println("Wifi symbol status is " + wifisymbol.isDisplayed());
        WebElement NetworkName = driver.findElement(By.id("com.app.wifianalyzer:id/current_network_name"));
        System.out.println(NetworkName.getText());
        System.out.println(driver.findElement(By.id("com.app.wifianalyzer:id/frequency_text")).getText());
        System.out.println(driver.findElement(By.id("com.app.wifianalyzer:id/network_connected_text")).getText());
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        System.out.println(scanlist.size());
        if (scanlist.size() > 1) {
            scanlist.get(1).findElement(By.className("android.widget.RadioButton")).click();
        } else {
            scanlist.get(0).findElement(By.className("android.widget.RadioButton")).click();
        }
        driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
//        for(int i=0;i<scanlist.size();i++)
//        {
//         System.out.println(scanlist.get(i).findElement(By.id("com.app.wifianalyzer:id/network_connected_ssid")).getText());
//         System.out.println(scanlist.get(i).findElement(By.id("com.app.wifianalyzer:id/network_connected_text")).getText());
//        }
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_add_network")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/dialog_cancel")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
        driver.closeApp();
    }

    public void wifiChecking(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        if (driver.findElements(By.id("com.app.wifianalyzer:id/wifi_enable_btn")).size() != 0) {
            System.out.println("Wifi is turned OFF");
            driver.findElement(By.id("com.app.wifianalyzer:id/wifi_enable_btn")).click();
            Thread.sleep(10000);
        } else {
            System.out.println("Wifi is turned ON");
        }
    }

    public void locationChecking(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;

        if (driver.findElements(By.id("com.app.wifianalyzer:id/dialog_ok")).size() != 0) {
            System.out.println("Location is turned OFF");
            WebElement location = driver.findElement(By.id("com.app.wifianalyzer:id/dialog_ok"));
            System.out.println(location.isDisplayed());
            location.click();
            driver.findElement(By.id("com.android.settings:id/switch_widget")).click();
            Thread.sleep(3000);
        } else {
            System.out.println("Location is turned ON");
        }
    }
}
