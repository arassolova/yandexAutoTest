package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "input#passp-field-login")
    private WebElement loginInput;

    @FindBy(css = "button#passp\\:sign-in")
    private WebElement loginBtn;

    @FindBy(css = "input#passp-field-passwd")
    private WebElement passwordInput;

    public void inputLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

}

