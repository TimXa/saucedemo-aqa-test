package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Явное ожидание до 10 секунд
    }

    /**
     * Проверяет, открылась ли страница с товарами.
     * Использует явное ожидание, что помогает при тестировании performance_glitch_user.
     */
    public boolean isPageOpened() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle))
                    .getText().equalsIgnoreCase("Products");
        } catch (Exception e) {
            return false;
        }
    }
}