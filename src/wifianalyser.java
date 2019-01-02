import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class wifianalyser {

    AppiumDriver driver = null;

    @BeforeTest

    public void wifiCheckandlocationCheck() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        //capabilities.setCapability("udid", "9323542a");
        capabilities.setCapability("deviceName", "Sony");
        capabilities.setCapability("automationName", "sample1");
        capabilities.setCapability("noReset", "True");
        capabilities.setCapability("autoGrantPermissions", "True");
        capabilities.setCapability("autoAcceptAlerts", "True");
        //capabilities.setCapability("avd", "Nexus_6_API_22");
        File app = new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void setup() throws InterruptedException {

        //Detailed information of Wifi connected
//        wifiChecking(driver);
//        locationChecking(driver);
//        connectedStatus(driver);
//        scanNetworks(driver);
//        scanbuttonVisibility(driver);
//        ssidInfo(driver);
//        recommendationInfo(driver);
//        channelRatings(driver);
        channelGraph(driver);
    }

    public void scanbuttonVisibility(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        scanlist.get(0).findElement(By.className("android.widget.RadioButton")).click();
        Thread.sleep(16000);
        System.out.println("Scan button status is "+driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).isEnabled());
        driver.launchApp();
    }
    public void ssidInfo(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        scanlist.get(0).findElement(By.className("android.widget.RadioButton")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).click();
        Thread.sleep(5000);
        driver.launchApp();
    }

        public void connectedStatus(AppiumDriver driver) throws InterruptedException {
        this.driver=driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        System.out.println(scanlist.size());
        Thread.sleep(5000);
        for(int i=0;i<scanlist.size()-1;i++) {
            if (i == 0) {
                System.out.println("Connected Network is " + scanlist.get(i).findElement(By.id("com.app.wifianalyzer:id/network_connected_ssid")).getText());
            } else {
                System.out.println("Remaining Networks are " + scanlist.get(i).findElement(By.id("com.app.wifianalyzer:id/network_not_connected_ssid")).getText());
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
        String NetworkName=driver.findElement(By.id("com.app.wifianalyzer:id/current_network_name")).getText();
        System.out.println(NetworkName);
        String FrequencyName=driver.findElement(By.id("com.app.wifianalyzer:id/frequency_text")).getText();
        System.out.println(FrequencyName);
        String NetworkStatus=driver.findElement(By.id("com.app.wifianalyzer:id/network_connected_text")).getText();
        System.out.println(NetworkStatus);
        boolean imagevalue=driver.findElement(By.id("com.app.wifianalyzer:id/wifi_signal_level")).isDisplayed();
        if(imagevalue==true)
        {
            System.out.println("Network signal icon is present");
        }
        else
        {
            System.out.println("Network signal icon is Not present");
        }
            driver.launchApp();
        }

    public void scanNetworks(AppiumDriver driver)
    {
        this.driver=driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_add_network")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/dialog_cancel")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_add_network")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/dialog_ok")).click();
        driver.launchApp();
    }

    public void recommendationInfo(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        scanlist.get(0).findElement(By.className("android.widget.RadioButton")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_rescan")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.app.wifianalyzer:id/channel_ratings_btn")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/channel_graph_btn")).click();
        driver.launchApp();
    }
    public void channelRatings(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        scanlist.get(0).findElement(By.className("android.widget.RadioButton")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/channel_ratings_btn")).click();
        Thread.sleep(3000);
        WebElement Text=driver.findElement(By.id("com.app.wifianalyzer:id/channel_rating_header"));
        System.out.println(Text.findElement(By.className("android.widget.TextView")).getText());
        List<WebElement> values = driver.findElements(By.className("android.support.v7.app.a$c"));
        System.out.println(values.size());
        values.get(1).click();
        WebElement FiveText = driver.findElement(By.id("com.app.wifianalyzer:id/five_ghz_not_supported"));
        System.out.println(FiveText.getText());
        Assert.assertEquals(FiveText.getText(), "This device does not support 5GHZ mode");
        values.get(0).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_channel")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.app.wifianalyzer:id/dialog_ok")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
        driver.launchApp();
    }
    public void channelGraph(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.findElement(By.id("com.app.wifianalyzer:id/scan_other_networks")).click();
        WebElement mainlist = driver.findElement(By.id("com.app.wifianalyzer:id/refresh_scan_list"));
        List<WebElement> scanlist = mainlist.findElements(By.className("android.widget.FrameLayout"));
        scanlist.get(0).findElement(By.className("android.widget.RadioButton")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/show_recommendations_btn")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/channel_graph_btn")).click();
        driver.findElement(By.id("com.app.wifianalyzer:id/menu_rescan")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.app.wifianalyzer:id/five_GHZ")).click();
        if(driver.findElements(By.id("com.app.wifianalyzer:id/next_channels")).size()!=0) {
            driver.findElement(By.id("com.app.wifianalyzer:id/next_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/next_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/next_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/next_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/next_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/prev_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/prev_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/prev_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/prev_channels")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.app.wifianalyzer:id/prev_channels")).click();
            Thread.sleep(3000);
        }
        else {
            WebElement FiveText = driver.findElement(By.id("com.app.wifianalyzer:id/five_ghz_not_supported"));
            Assert.assertEquals(FiveText.getText(), "This device does not support 5GHZ mode");
        }
        driver.findElement(By.id("com.app.wifianalyzer:id/two_GHZ")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
        driver.launchApp();
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
        driver.launchApp();
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
        driver.launchApp();
    }

    @AfterTest

    public void closeApp()
    {
        driver.closeApp();
    }
}
