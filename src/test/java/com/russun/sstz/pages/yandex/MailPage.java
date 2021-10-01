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

    @FindBy(xpath = "//div[contains(@class,'ComposeControlPanel-Part')]/descendant::button")
    private WebElement sendButton;

    @FindBy(className = "textinput__control")
    private WebElement searchField;

    @FindBy(xpath = "//form[contains(@class, 'search-input__form')]/descendant::button")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(@class, 'mail-MessagesSearchInfo-Title')]/child::span")
    private WebElement countSpan;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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
