package tests;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.io.File;
import java.io.IOException;

public class Listener implements TestWatcher {
    public static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} = FAILED!", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9, 13);
        LOGGER.info("Trying to trace screenshot..");


        if (BaseTest.driver != null) {
            try {
                TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                File screenshotDir = new File("build/report/tests");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }

                File destination = new File(screenshotDir, screenshotName + ".png");
                FileUtils.copyFile(source, destination);

                LOGGER.info("Screenshot saved to: " + destination.getPath());

            } catch (IOException e) {
                LOGGER.info("Exception on saving screenshot");
                e.printStackTrace();
            }
        } else {
            LOGGER.info("Driver is null, cannot take screenshot");
        }
    }
}
