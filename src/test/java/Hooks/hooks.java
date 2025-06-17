package Hooks;

import Utilities.Driver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Utilities.Driver.driver;
import static Utilities.Driver.getDriver;

public class hooks {

        public static AppiumDriverLocalService server;

        @After
        public void tearDown(Scenario scenario) throws InterruptedException {
            final byte[] screenshot = ((TakesScreenshot) getDriver() ).getScreenshotAs(OutputType.BYTES);
            if (scenario.isFailed()) {
                scenario.attach(screenshot, "image/png", "screenshots");
            }
            Driver.quitDriver();
        }

        public void forceStopAppiumServer() {

            try {
                Runtime.getRuntime().exec("taskkill /F /IM node.exe");
                Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

}


