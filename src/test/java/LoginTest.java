import org.junit.jupiter.api.*;


public class LoginTest extends BaseTest {

    //@Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})

    @Test
    public void login() {
        loginPage.assertTitle();
        loginPage.login("standard_user", "secret_sauce");
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
