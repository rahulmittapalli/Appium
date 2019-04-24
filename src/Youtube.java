import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Youtube {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "4df1250a72835ffb"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.3");
        caps.setCapability("appPackage", "com.google.android.youtube");
        caps.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
        caps.setCapability("noReset", true);
        //Instantiate Appium Driver
        AndroidDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        }
        catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        driver.findElementByAccessibilityId("Search").click();
        Thread.sleep(5000);
        driver.findElementById("com.google.android.youtube:id/search_edit_text").sendKeys("viva news");
        driver.findElementById("com.google.android.youtube:id/text").click();
        Thread.sleep(5000);
        driver.findElementById("com.google.android.youtube:id/thumbnail").click();
        Thread.sleep(5000);
//        int i=10;
//        while(i>=0)
//        {
//            driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
//            i--;
//            System.out.println("the value of i is "+i);
//        }
        System.out.println(driver.findElementById("com.google.android.youtube:id/title").getText());
        driver.findElementByAccessibilityId("Expand Mini Player").click();
        driver.findElementByAccessibilityId("Enter full screen").click();
        int Element =driver.findElementsById("com.google.android.youtube:id/close_button").size();
        System.out.println("Element size is "+Element);
        if(Element !=0)
        {
            driver.findElementById("com.google.android.youtube:id/close_button").click();
        }
        driver.closeApp();
    }
    }

