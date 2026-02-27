package tests;

import common.CommonActions;
import constants.Constant;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;

@ExtendWith(Listener.class)
//@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    public static WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected ProductPage productPage = new ProductPage(driver);
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("Start time:" + LocalTime.now());
        LOGGER.info("Start clear report dir: build/reports ...");
        File allurerResults = new File("allure-results");
        if (allurerResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allurerResults.listFiles()))
                item.delete();
        }
        if (CLEAR_REPORT_DIR) {
            File allurerScreenshots = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(allurerScreenshots.listFiles()))
                item.delete();
        }


    }

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
