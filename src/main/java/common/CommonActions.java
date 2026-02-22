package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import static common.Config.BROWSER;
import static constants.Constant.Timeout.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER) {
            case "chrome_Win":
                driver = new ChromeDriver();
                break;
            case "mozilla":
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("incorrect browser" + BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
