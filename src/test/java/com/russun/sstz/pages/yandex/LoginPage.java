package com.russun.sstz.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "passp-field-login")
    private WebElement identifierField;

    @FindBy(id = "passp:sign-in")
    private WebElement loginButton;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwdField;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputLogin(String login) {
        identifierField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginButton.click();
    }
}
