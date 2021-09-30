package com.russun.sstz.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(), 'Написать')]/..")
    private WebElement newMailButton;

    @FindBy(className = "composeYabbles")
    private WebElement toField;

    @FindBy(name = "subject")
    private WebElement themeField;

    @FindBy(css = "div#cke_1_contents > div")
    private WebElement textField;

    @FindBy(css = "html#nb-1 > body > div:nth-of-type(3) > div:nth-of-type(10) > div > div > div > div > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div > div > div > button")
    private WebElement sendButton;

    @FindBy(css = "html#nb-1 > body > div:nth-of-type(3) > div:nth-of-type(7) > div > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div > div > div > div > form > div > span > input")
    private WebElement searchField;

    @FindBy(css = "html#nb-1 > body > div:nth-of-type(3) > div:nth-of-type(7) > div > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div > div > div > div > form > button")
    private WebElement searchButton;

    @FindBy(css = "html#nb-1 > body > div:nth-of-type(3) > div:nth-of-type(7) > div > div:nth-of-type(3) > div:nth-of-type(3) > div:nth-of-type(3) > div > div:nth-of-type(5) > div > div > div > div:nth-of-type(2) > div > div > div > span > span")
    private WebElement countSpan;

    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void clickLoginBtn() {
        loginButton.click();
    }

    public void clickNewMailBtn() {
        newMailButton.click();
    }

    public void inputTo(String to){
        toField.sendKeys(to + "@yandex.ru");
    }

    public void inputTheme(String theme){
        themeField.sendKeys(theme);
    }

    public void inputText(String text){
        textField.sendKeys(text);
    }

    public void clickSendBtn(){
        sendButton.click();
    }

    public void inputSearch(String text){
        searchField.sendKeys(text);
    }

    public void clickSearchBtn(){
        searchButton.click();
    }

    public String getCountFromSpan(){
        return countSpan.getText();
    }
}
