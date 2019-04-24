import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class contactsAdd {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "4df1250a72835ffb"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.3");
        caps.setCapability("appPackage","com.android.contacts");
        caps.setCapability("appActivity",".activities.PeopleActivity");
        caps.setCapability("noReset", true);
        //Instantiate Appium Driver
        AndroidDriver <MobileElement>driver = null;
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(3000);
        driver.findElementById("com.android.contacts:id/create_button").click();
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(15)").sendKeys("Helloworld");
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)").sendKeys("0123456789");
        Thread.sleep(3000);
        driver.findElementById("com.android.contacts:id/menu_done").click();
        Thread.sleep(5000);
        driver.findElementById("android:id/up").click();
        Thread.sleep(3000);
        driver.closeApp();
    }
}
