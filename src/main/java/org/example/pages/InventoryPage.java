package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);

    private final By pageTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPageOpened() {
        logger.info("Проверка открытия страницы товаров");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle))
                    .getText().equalsIgnoreCase("Products");
        } catch (Exception e) {
            logger.error("Страница товаров не загрузилась: {}", e.getMessage());
            return false;
        }
    }
}