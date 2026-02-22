package qa.Demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {

    @Disabled
    @Test
    public void testAlert() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://javascript.info/alert-prompt-confirm");

        WebElement alertRun = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-action = 'run'])[1]")));;
        alertRun.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        alertRun.click();
        System.out.println("textAlert -> " +alert.getText());
        alert.accept();

        driver.quit();
    }

    @Test
    public void testIframe() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://javascript.info/cross-window-communication");
        driver.manage().window().maximize();

        WebElement iframeRun = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-action = 'run'])[5]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeRun);
        Thread.sleep(500);
        iframeRun.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("textAlert -> " +alert.getText());
        alert.accept();

//        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, '/')]")));
//        driver.switchTo().frame(iframe);
//
//
//        WebElement buttonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='sitetoolbar__nav-toggle']")));
//        buttonLogin.click();

        driver.quit();
    }

}
