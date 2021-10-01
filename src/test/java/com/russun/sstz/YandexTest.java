package com.russun.sstz;

import com.russun.sstz.pages.yandex.LoginPage;
import com.russun.sstz.pages.yandex.MailPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class YandexTest {
    private static MailPage mailPage;
    private static LoginPage loginPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("nodelink")),chromeOptions);

        mailPage = new MailPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get(ConfigReader.getProperty("loginpage"));
    }
    @Test
    public void yandexMailTest() {
        //Переход на страницу аутентификации
        mailPage.clickLoginBtn();
        //Вход в аккаунт
        loginPage.inputLogin(ConfigReader.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfigReader.getProperty("password"));
        loginPage.clickLoginBtn();

        //Поиск писем по теме во входящих
        mailPage.inputSearch(ConfigReader.getProperty("searchtext"));
        mailPage.clickSearchBtn();
        //Смотрим на количество
        String count = mailPage.getCountFromSpan().split(" ")[0];

        //Пишем новое письмо
        mailPage.clickNewMailBtn();
        //Получатель
        mailPage.inputTo(ConfigReader.getProperty("login"));
        //Тема
        mailPage.inputTheme(ConfigReader.getProperty("theme"));
        //Текст письма
        mailPage.inputText(count);
        mailPage.clickSendBtn();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
