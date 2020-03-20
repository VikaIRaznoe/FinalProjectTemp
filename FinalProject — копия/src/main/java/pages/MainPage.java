package pages;

import general.GeneralMethods;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;


public class MainPage extends BasePage{

    public MainPage(MobileDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void createNewTab() {
    }

    public void createNewIssue(){

    }

    public void openTabTODO() throws InterruptedException {
        WebElement elementTODO = GeneralMethods.waitForElementPresentRefact(By.xpath("//*[contains(@text,'TODO')]"),5);
        elementTODO.click();
        Thread.sleep(2000);
    }

    public void swipeEnjoyElement() throws InterruptedException {
        GeneralMethods.swipeElementLeft(By.id("text"));
        Thread.sleep(2000);
    }

}
