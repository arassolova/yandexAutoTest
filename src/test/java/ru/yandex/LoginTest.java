package ru.yandex;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
* Use case:
* 1. Пользователь открывает страницу аутентификации
* 2. Вводит валидные данные
* 3. Удостоверяется в успешной аутентификации — об этом свидетельствует имя пользователя в верхнем правом углу окна
* 4. Пользователь осуществляет выход из аккаунта
*/

public class LoginTest {

    static LoginPage loginPage;
    static AccountPage accountPage;
    static WebDriver driver;
    /**
     * Делаем первоначальную настройку
     */
    @BeforeClass
    public static void setUp() {
        //путь до драйвера
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создаем экземпляр драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        //задаем задержку на ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //переход на страницу
        driver.get(ConfProperties.getProperty("loginpageProperties"));
    }

    @Test
    public void loginTest(){
        loginPage.inputLogin(ConfProperties.getProperty("loginProperties"));
        loginPage.clickLoginButton();
        loginPage.inputPassword(ConfProperties.getProperty("passwordProperties"));
        loginPage.clickLoginButton();
        accountPage.entryUserMenu();
        String userName = accountPage.getUserSubname();
        Assert.assertEquals(ConfProperties.getProperty("userNameProperties"), userName);
    }

    @Test
    public void logoutTest(){
        // accountPage.entryUserMenu();
        accountPage.logOut();
    }

    @AfterClass
    public static void quit(){
       driver.quit();
    }
}
