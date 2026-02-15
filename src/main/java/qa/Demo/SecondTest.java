package qa.Demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTest {

    @Test
    public void testGithub() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/TanyaPD24");

        driver.manage().addCookie((new Cookie("user_session", "vxgcRNo1e9VgGs7_5cgNfnk5qEWVK-SQhjDpTUWk_3MydWrG")));
        driver.navigate().refresh();



        driver.quit();

    }
}
