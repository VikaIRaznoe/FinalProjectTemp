package tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class FirstTest extends BaseTest{

    public FirstTest() throws MalformedURLException {
        //MainPage mainPage = new MainPage();
    }

    @Test
    public void myFirstTest() throws InterruptedException {
        //1)Находим элемент "TODO"
        mainPage.openTabTODO();
        //2)Ищем фразу "Enjoy the app!",двигаем справа налево
        mainPage.swipeEnjoyElement();

    }

    // Два раза у меня открывается приложение и я понимаю почему,но как исправить? А с конце еще третий раз открывается

}
