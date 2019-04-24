import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class contactdelete {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "4df1250a72835ffb"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.3");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);
        //Instantiate Appium Driver
        AndroidDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        }
        catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        driver.findElementById("android:id/search_src_text").sendKeys("Hello");
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(3)").click();
        driver.pressKey(new KeyEvent(AndroidKey.DEL));
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(1)").click();
        driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
        driver.closeApp();
    }
}
