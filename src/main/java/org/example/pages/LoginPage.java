package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    // Локаторы элементов страницы
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Методы взаимодействия (Actions)

    public void enterUsername(String username) {
        logger.info("Ввод имени пользователя: {}", username);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Ввод пароля");
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Нажатие кнопки Login");
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageText() {
        logger.info("Ожидание сообщения об ошибке");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    /**
     * Универсальный метод для выполнения входа
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}