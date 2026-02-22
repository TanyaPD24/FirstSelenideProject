package pages;

import org.openqa.selenium.WebDriver;
import sun.net.httpserver.simpleserver.JWebServer;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
