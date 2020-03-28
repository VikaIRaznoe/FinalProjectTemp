package pages;

import general.DriverManager;
import general.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.HasClipboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
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

    public void findTextOfList(String[] Reminder){
        DriverManager.getDriver().getClipboardText();
        String text = DriverManager.getDriver().getClipboardText();
        boolean find = false;
        for(String strReminder: Reminder){
            find = text.trim().contains(strReminder.trim());
            System.out.println("List contains: " + strReminder.trim() + " : " + find);
        }
    }
}
