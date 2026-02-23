package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Constant.CART_PAGE_URL;
import static constants.Constant.EXPECTED_NAME_FIRST_PRODUCT;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By selectProduct1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

//    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
//    private WebElement selectProduct2;
//
//    @FindBy(id= "add-to-cart-sauce-labs-backpack")
//    private WebElement selectProduct3;

    private final By cart = By.className("shopping_cart_link");
    private final By removeButtonFirstProduct = By.id("remove-sauce-labs-backpack");
    private final By price1FirstProduct = By.id("shopping_cart_container");
    private final By cartProductName = By.cssSelector(".cart_item .inventory_item_name");

    public void selectFirstProduct() {
        WebElement PP1 = driver.findElement(selectProduct1);
        waitElementIsVisible(PP1);
        driver.findElement(selectProduct1).click();
        System.out.println("Первый товар добавлен в корзину");
    }

    public void clickCart() {
        //cart.click();
        driver.get(CART_PAGE_URL);
        System.out.println("Перешли в корзину. URL: " + driver.getCurrentUrl());
    }

    public void removeFirstProduct() {
        WebElement removeFirstProduct = waitElementIsVisible(driver.findElement(removeButtonFirstProduct));
        driver.findElement(removeButtonFirstProduct).click();
        System.out.println("Первый товар удален из корзины");
    }

    public void assertAddFirstProduct() {
        WebElement cartPName = waitElementIsVisible(driver.findElement(cartProductName));
        String actualNameFirstProduct = driver.findElement(cartProductName).getText();
        Assertions.assertEquals(EXPECTED_NAME_FIRST_PRODUCT, actualNameFirstProduct,
                "Error name first product");
        System.out.println("Прверка названия первого товара: " + actualNameFirstProduct);
    }

    public void assertRemoveFirstProduct() {
        WebElement removeP1 = waitElementIsVisible(driver.findElement(removeButtonFirstProduct));
        System.out.println("Первый товар удален из корзины");
    }
}
