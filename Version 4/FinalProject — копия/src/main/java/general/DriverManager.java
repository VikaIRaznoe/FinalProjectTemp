package general;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver(){
        return driver;
    }

    public static void initializeDriver(URL url, DesiredCapabilities capabilities){
        driver = new AppiumDriver<MobileElement>(url, capabilities);
    }
}
