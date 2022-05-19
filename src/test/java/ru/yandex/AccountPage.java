package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public  WebDriver driver;
    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".legouser__menu-header .user-account__subname")
    WebElement userAccountSubname;

    public String getUserSubname(){
        return userAccountSubname.getText();
    }

    @FindBy(css = "a.user-account.user-account_has-ticker_yes.user-account_has-accent-letter_yes.legouser__current-account.i-bem")
    WebElement userMenu;

    public void entryUserMenu(){
        userMenu.click();
    }

    @FindBy(css = ".legouser__menu-item_action_exit")
    WebElement logOutBtn;

    public void logOut(){
        logOutBtn.click();
    }
}
