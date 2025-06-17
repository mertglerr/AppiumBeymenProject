package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private  static UiAutomator2Options options;
    private  static XCUITestOptions iosoptions;
    public   static AppiumDriverLocalService service;
    public static AppiumDriver driver;


    public   static AndroidDriver getDriver() {

        if (driver == null){
            switch (configreader.getProperty("platformName")){
                case "Android":
                    options = new UiAutomator2Options()
                            .setUnlockType("pin")
                            .setUnlockKey("1111")
//                            .setApp(configreader.getProperty("appurl"))
                            .setDeviceName("Medium")
                            .setAppPackage(configreader.getProperty("mainPagePackage"))
                            .setAppActivity(configreader.getProperty("mainPageActivity"))
                            .setAutomationName("uiAutomator2")
                            .setNoReset(true)
                            .setNewCommandTimeout(Duration.ofMinutes(10));

                    try {
                        driver = new AndroidDriver(
                                new URL("http://127.0.0.1:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return (AndroidDriver) driver;
    }

    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }
    public static void serverKapat() {
        service.stop();
    }

}
