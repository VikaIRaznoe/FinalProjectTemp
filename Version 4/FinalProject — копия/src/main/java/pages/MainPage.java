package pages;

import general.DriverManager;
import general.DriverManager2;
import general.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.HasClipboard;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

import static general.GeneralMethods.waitForElementPresentRefact;

public class MainPage extends BasePage{

    By elementTODO = By.xpath("//*[contains(@text,'TODO')]");
    By enjoyText = By.id("text");
    By itemEditText = By.id("addItemEditText");
    By elementTuto = By.xpath("//*[contains(@text,'Tuto')]");
    By elementUserList = By.xpath("//*[contains(@text,'List 1')]");
    By elementShareList = By.id("buttonShareList");
    By elementCopyToClipBoard = By.xpath("//*[contains(@text,'Copy to clipboard')]");
    private String APPIUM_SERVER = "http://localhost:4723/wd/hub";

    public void openListTODO(){
        waitForElementPresentRefact(elementTODO,5).click();
    }

    public void openUserList(){
        waitForElementPresentRefact(elementUserList,5).click();
    }

    public void shareList(){
        waitForElementPresentRefact(elementShareList,5).click();
        waitForElementPresentRefact(elementCopyToClipBoard,5).click();
    }

    public void swipeEnjoyElement(){
        GeneralMethods.swipeElementLeft(enjoyText);
    }

    public void clickListAdd(){
        waitForElementPresentRefact(itemEditText,5).click();
    }

    public void editText(String text){
        waitForElementPresentRefact(itemEditText,5).sendKeys(text);
        waitForElementPresentRefact(By.id("validate"),5).click();
    }

    public void clickPlusButton(){
        waitForElementPresentRefact(By.id("buttonAddList"),5).click();
    }

    public void inputNameList(){
        waitForElementPresentRefact(By.id("listTitle"),5).sendKeys("List 1");
        waitForElementPresentRefact(By.id("validateEditList"),5).click();
    }

    public void markAsDoneReminder(String Reminder){
        By elementReminder = By.xpath("//*[contains(@text,\'Reminder\')]");
        waitForElementPresentRefact(elementReminder,5).click();
    }

    public void deleteListTuto(){
        WebElement elementWebTuto = waitForElementPresentRefact(elementTuto,5);
        GeneralMethods.longPress(elementWebTuto);
    }

    public void rotateScreenLandScape(){
        GeneralMethods.rotateScreenLandScape();
    }

    public void searchingElementInList(String Reminder){
       WebElement element = waitForElementPresentRefact(By.xpath("//*[contains(@text,\'Reminder\')]"),5);
       element.click();
    }

    public void clickButtonShare(){
        WebElement elementShare = waitForElementPresentRefact(elementShareList,5);
        elementShare.click();
    }

    public void findTextOfList() throws MalformedURLException {
        //https://appium.io/docs/en/commands/device/clipboard/get-clipboard/
        //driver.getClipboardText();

//        String appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("avd", AVD_NAME);
//        capabilities.setCapability("app", ANDROID_APP);

        AndroidDriver driver = new AndroidDriver(new URL(APPIUM_SERVER), capabilities);
        automateClipboard(driver);
    }

    private void automateClipboard(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
//            wait.until(ExpectedConditions.presenceOfElementLocated(clipboardNav)).click();
//
//            String text = "Hello World";
//            ((HasClipboard) driver).setClipboardText(text);
//            wait.until(ExpectedConditions.presenceOfElementLocated(refreshClipboardBtn)).click();
//            By clipboardText = MobileBy.AccessibilityId(text);
//            Assert.assertEquals(driver.findElement(clipboardText).getText(), text);

            String text = "Reminder 2";
//            driver.findElement(clipboardInput).sendKeys(text);
            //driver.findElement(elementUserList).click();
//            try {
//                driver.hideKeyboard();
//            } catch (Exception ign) {}
            driver.findElement(elementCopyToClipBoard).click();
            Assert.assertEquals(((HasClipboard) driver).getClipboardText(), text);

        } finally {
            driver.quit();
        }
    }

    public void temp(){
        DriverManager2.getDriver().getClipboardText();
        String text = DriverManager2.getDriver().getClipboardText();
        System.out.println(text);
    }
}
