package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static constants.Constant.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By userName = By.xpath("//input[@id='user-name']");
    private final By userPassword = By.xpath("//input[@id='password']");
    private final By buttonLogin = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By actualNameProductPage = By.xpath("//span[@class='title']");

    public void assertTitle() {
        String actualTitle = driver.getTitle();

        assert actualTitle != null;
//        if (actualTitle.equals(EXPECTED_TITLE)) {
//            System.out.println("Actual title - OK - " + EXPECTED_TITLE);
//        } else {
//            System.out.println("not ok - " + actualTitle);
//        }
        Assertions.assertEquals(EXPECTED_TITLE, actualTitle);

    }

    public void urlTitle () {
        String baseTitle = driver.getTitle();
        System.out.println("Expected title - " + baseTitle);
    }

    public void login(String username, String password) {
        WebElement name = driver.findElement(userName);
        waitElementIsVisible(name);
        if (username != null) {
            driver.findElement((userName)).sendKeys(username);
        }
        if (password != null) {
            driver.findElement(userPassword).sendKeys(password);
        }
        driver.findElement(buttonLogin).click();
    }

    public void assertNameProductPage() {
        WebElement namePP = driver.findElement(actualNameProductPage);
        waitElementIsVisible(namePP);
        String actualProductNameText = driver.findElement(actualNameProductPage).getText();
        Assertions.assertEquals(EXPECTED_TITLE_PRODUCT_PAGE, actualProductNameText);
    }

    public void assertErrorMessageForPassword() {
        WebElement message = driver.findElement(errorMessage);
        waitElementIsVisible(message);
        Assertions.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Epic sadface: Password is required");
    }

    public void closeErrorMessage() {
        WebElement message = driver.findElement(errorMessage);
        waitElementIsVisible(message).isDisplayed();
        WebElement closeButton = driver.findElement(By.cssSelector(".error-button"));
        closeButton.click();
    }

    public void assertErrorMessageForCredentials() {
        WebElement message = driver.findElement(errorMessage);
        waitElementIsVisible(message);
        String actualError = driver.findElement(errorMessage).getText();
        Assertions.assertEquals(ERROR_INVALID_CREDENTIALS, actualError,
                "Error massage does not match expected");
        System.out.println("Проверка с неверными данными: " + actualError);
    }
}
