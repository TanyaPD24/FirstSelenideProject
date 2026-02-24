package tests;

import common.CommonActions;
import constants.Constant;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductPage;

import static common.Config.BROWSER_OPEN;
import static common.Config.CLEAR_COOKIES;

@ExtendWith(Listener.class)
//@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    public static WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected ProductPage productPage = new ProductPage(driver);

    @DisplayName("Авторизация")
    @BeforeEach
    public void checkIsRedirectToAuth() {
        basePage.goToUrl(Constant.URL);
    }

    @AfterEach
    void clearCookiesAndLocalStorages() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExe=(JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExe.executeScript("window.sessionStorage.clear()");

        }
    }

    @AfterAll
    void close() {
        if (!BROWSER_OPEN) {
            driver.close();
        }
    }
}
