package pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SettingsPage extends BasePage {
    public SettingsPage(MobileDriver<MobileElement> driver) throws SQLException, MalformedURLException {
        super(driver);
    }
}
