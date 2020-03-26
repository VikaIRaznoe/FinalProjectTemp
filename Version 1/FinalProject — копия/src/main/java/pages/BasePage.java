package pages;

import general.DriverManager;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;


public class BasePage {
    MobileDriver<MobileElement> driver = DriverManager.getDriver();
    //MobileDriver<MobileElement> driver;

    public BasePage(MobileDriver<MobileElement> driver) throws MalformedURLException {
        this.driver = driver;
//        this.driver = DriverManager.getDriver();
    }
}
