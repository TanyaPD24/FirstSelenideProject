package constants;

public class Constant {
    public static class Timeout {
        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 10;

    }

    public static final String URL = "https://www.saucedemo.com/";
    public static final String EXPECTED_TITLE = "Swag Labs";
    public static final String EXPECTED_TITLE_PRODUCT_PAGE = "Products";
    public static final String ERROR_INVALID_CREDENTIALS = "Epic sadface: Username and password do " +
            "not match any user in this service";

    public static final String EXPECTED_NAME_FIRST_PRODUCT = "Sauce Labs Backpack";
    public static final String CART_PAGE_URL = "https://www.saucedemo.com/cart.html";
    public static final String PRODUCT_URL = "https://www.saucedemo.com/inventory.html";

    public static class data {
        public static final String NAME_LOGIN = "standard_user";
        public static final String PASSWORD = "secret_sauce";
    }
}
