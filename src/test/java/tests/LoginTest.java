package tests;

import org.junit.jupiter.api.*;

import static constants.Constant.data.NAME_LOGIN;
import static constants.Constant.data.PASSWORD;



public class LoginTest extends BaseTest {

    //@Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})

    @Test
    public void login() {
        loginPage.assertTitle();
        loginPage.login(NAME_LOGIN, PASSWORD);
        loginPage.assertNameProductPage();
    }

//    @Test
//    public void emptyLogin() {
//        loginPage.login(null, "secret_sauce");
//        loginPage.closeErrorMessage();
//    }
//
//    @Test
//    public void emptyPassword() {
//        loginPage.login("standard_user", null);
//        loginPage.assertErrorMessageForPassword();
//        loginPage.closeErrorMessage();
//    }
//
//    @Test
//    public void emptyLoginAndPassword() {
//        loginPage.login(null, null);
//        loginPage.closeErrorMessage();
//    }
//
//    @Test
//    public void fillWithInvalidUserName() {
//        loginPage.login("test", "secret_sauce");
//        loginPage.assertErrorMessageForCredentials();
//    }
//
//    @Test
//    public void fillWithSpecialChars() {
//        loginPage.login("!@#$%^&*()_+-=[]{}|;:,.<>?", "!@#$%^&*()_+-=[]{}|;:,.<>?");
//    }

}
