package tests;

import general.DriverManager;
import general.DriverManager2;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.clipboard.HasClipboard;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
   // private File app = new File("src/test/resources/apps/com.lolo.io.onelist_12.apk");

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.0");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","");
        caps.setCapability("appActivity","");
        caps.setCapability("app","/Users/viktoria/IdeaProjects/Java/FinalProject/src/test/resources/Apps/com.lolo.io.onelist_12.apk");
        //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,80);

        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
//        DriverManager.initializeDriver(appiumURL, caps);
        DriverManager2.initializeDriver(appiumURL, caps);
    }
    @AfterClass
    public void  tearDown() {
        DriverManager.getDriver().quit();
    }
}
