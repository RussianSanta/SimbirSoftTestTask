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
    public static MailPage mailPage;
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        ChromeOptions test = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://192.168.0.191:5558/wd/hub"),test);

        mailPage = new MailPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get(ConfigReader.getProperty("loginpage"));
    }
    @Test
    public void loginTest() {
        mailPage.clickLoginBtn();
        loginPage.inputLogin(ConfigReader.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfigReader.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @Test
    public void sendMessageTest(){
        mailPage.inputSearch(ConfigReader.getProperty("searchtext"));
        mailPage.clickSearchBtn();
        String count = mailPage.getCountFromSpan().split(" ")[0];

        mailPage.clickNewMailBtn();
        mailPage.inputTo(ConfigReader.getProperty("login"));
        mailPage.inputTheme(ConfigReader.getProperty("theme"));
        mailPage.inputText(count);
        mailPage.clickSendBtn();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
