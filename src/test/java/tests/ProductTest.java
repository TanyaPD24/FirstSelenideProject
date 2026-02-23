package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {
    @BeforeEach
    public void setUpProductPage() {
        loginPage.login("standard_user", "secret_sauce");
        loginPage.assertNameProductPage();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());
    }

    @Test
    public void selectFirstProductInProductPage() {
        productPage.selectFirstProduct();
        productPage.clickCart();
        productPage.assertAddFirstProduct();
        productPage.removeFirstProduct();
        productPage.assertRemoveFirstProduct();
    }
}
