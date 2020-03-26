package tests;

import general.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

import java.net.MalformedURLException;
import java.sql.SQLException;


public class BaseTest {
    MainPage mainPage;

    @BeforeClass
    public void initPage() throws MalformedURLException, SQLException {
        mainPage = new MainPage(DriverManager.getDriver());
    }

    @AfterClass
    public void tearDown() throws MalformedURLException {
        //DriverManager.getDriver().quit();
        DriverManager.closeDriver();
    }
}
