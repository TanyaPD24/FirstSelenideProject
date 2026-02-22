import common.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CarPage;

import static common.Config.BROWSER_OPEN;
import static common.Config.CLEAR_COOKIES;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarPage carPage = new CarPage(driver);

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
