package qa.Demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class FirstTest {
    @Test
    public void testSearchGoogle() {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().setSize(new Dimension(1000, 1000));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl-> " + currentUrl);

        Assertions.assertEquals("https://demowebshop.tricentis.com/", currentUrl);

        WebElement searchInput = driver.findElement(By.id("small-searchterms"));
        searchInput.sendKeys("Laptop");
        searchInput.submit();

        String currentTitle = driver.getTitle();
        System.out.println("currentTitle-> " + currentTitle);
        Assertions.assertEquals("Demo Web Shop. Search", currentTitle);

//        driver.navigate().to("https://selenium.dev");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

        WebElement nameProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'14.1-inch Laptop')]")));
        String textContentTitle = nameProduct.getAttribute("textContent");
        System.out.println("textContentTitle  -> " + textContentTitle);
        Assertions.assertEquals( "14.1-inch Laptop", textContentTitle);

        WebElement addToCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Add to cart']")));
        addToCard.click();

        WebElement shoppingCard = driver.findElement(By.xpath("//span[@class='cart-label']"));
        shoppingCard.click();

        Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@value='Add to cart']"))));

        WebElement qtyProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='qty-input']")));
        String qtyValue = qtyProduct.getAttribute("value");
        System.out.println("qtyValue -> " + qtyValue);
        Assertions.assertEquals( "1", qtyValue);

        Set<String> allLogs = driver.manage().logs().getAvailableLogTypes();
        System.out.println("logs -> " + allLogs);

        driver.quit();
    }
}
