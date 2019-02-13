import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class playstore {
    AppiumDriver driver =null;

    @BeforeTest
        public void play() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName","Samsung");
            capabilities.setCapability("platformVersion", "4.4.2");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "9323542a");
            capabilities.setCapability("noReset", "True");
            capabilities.setCapability("autoGrantPermissions", "True");
            capabilities.setCapability("autoAcceptAlerts", "True");
            //capabilities.setCapability("appActivity","com.android.vending.AssetBrowserActivity");
            //capabilities.setCapability("appPackage","com.android.vending");
            //capabilities.setCapability("avd", "Nexus_6_API_22");
           File app = new File("/Users/rahulmittapalli/Downloads/WiFiAnalyzer.apk");
           capabilities.setCapability("app", app.getAbsolutePath());
           driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        @Test
    public void openApp() throws InterruptedException {
            Thread.sleep(3000);
            driver.findElement(By.id("com.android.vending:id/search_box_idle_text")).click();
            driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys("SHAREit");
            driver.findElement(By.id("com.android.vending:id/tab_bar")).click();
            Thread.sleep(3000);
            driver.findElement(By.className("android.widget.Button")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("com.android.vending:id/continue_button")).click();
            Thread.sleep(30000);
            WebElement uninstalled=driver.findElement(By.className("android.widget.Button"));
            String uninstall= uninstalled.getText();
            if (uninstall.equals("UNINSTALL")) {
                uninstalled.click();
            }
            driver.findElement(By.id("android:id/button1")).click();
            Thread.sleep(5000);
            driver.closeApp();
    }
}

