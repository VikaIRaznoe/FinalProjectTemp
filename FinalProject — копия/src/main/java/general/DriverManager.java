package general;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static AppiumDriver<MobileElement> driver;
    private File app = new File("src/test/resources/apps/com.lolo.io.onelist_12.apk");

    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
//    public static MobileDriver<MobileElement> getDriver(String platform) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.0");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","");
        caps.setCapability("appActivity","");
        caps.setCapability("app","/Users/viktoria/IdeaProjects/Java/FinalProject/src/test/resources/Apps/com.lolo.io.onelist_12.apk");
        //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,80);

        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");

        return driver = new AppiumDriver<MobileElement>(appiumURL,caps);

    }

    public static void closeDriver(){
        driver.quit();
    }
}
