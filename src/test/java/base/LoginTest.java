package base;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Функционал авторизации")
@Story("Проверка различных сценариев входа в систему")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Успешный логин (standard_user)")
    @Description("Тест проверяет вход с корректными данными и переход на страницу товаров")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assertions.assertTrue(inventoryPage.isPageOpened(), "Страница товаров не открылась после логина");
    }

    @Test
    @DisplayName("Логин с неверным паролем")
    @Description("Проверка отображения ошибки при вводе неверного пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        String errorText = loginPage.getErrorMessageText();
        Assertions.assertTrue(errorText.contains("Username and password do not match"),
                "Текст ошибки не соответствует ожидаемому. Получено: " + errorText);
    }

    @Test
    @DisplayName("Логин заблокированного пользователя")
    @Description("Проверка ошибки при входе заблокированным пользователем (locked_out_user)")
    @Severity(SeverityLevel.NORMAL)
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        String errorText = loginPage.getErrorMessageText();
        Assertions.assertTrue(errorText.contains("Sorry, this user has been locked out"),
                "Сообщение о блокировке некорректно. Получено: " + errorText);
    }

    @Test
    @DisplayName("Логин с пустыми полями")
    @Description("Проверка валидации при попытке входа без ввода данных")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();

        String errorText = loginPage.getErrorMessageText();
        Assertions.assertTrue(errorText.contains("Username is required"),
                "Сообщение о пустых полях некорректно. Получено: " + errorText);
    }

    @Test
    @DisplayName("Логин performance_glitch_user (Задержка)")
    @Description("Проверка успешного входа пользователя с задержкой загрузки")
    @Severity(SeverityLevel.CRITICAL)
    public void testPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assertions.assertTrue(inventoryPage.isPageOpened(), "Страница товаров не открылась для glitch пользователя");
    }
}
