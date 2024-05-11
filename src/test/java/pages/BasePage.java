package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public AppiumServiceBuilder appiumServiceBuilder;
    public AppiumDriverLocalService appiumDriverLocalService;
    public static AppiumDriver<MobileElement> driver = null;
    public Properties properties = new Properties();
    public InputStream input = null;
    public static String PLATFORM_TYPE = "PLATFORM_TYPE";
    public static String APP_PACKAGE = "APP_PACKAGE";
    public static String APP_ACTIVITY = "APP_ACTIVITY";

    @BeforeSuite

    public AppiumDriver<MobileElement> getDriver() {
        startServer();
        String platform = getPlatformPropertyByKey(PLATFORM_TYPE);
        if (getPlatformPropertyByKey(PLATFORM_TYPE).equalsIgnoreCase("android")) {
            androidSetup();
        } else {
            String errorMessage = String.format("Tests are configured to run only on Android, but the current platform is %s.", platform);
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        stopServer();
    }

    public void androidSetup() {
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getPlatformPropertyByKey(APP_PACKAGE));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getPlatformPropertyByKey(APP_ACTIVITY));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        // Set the device/emulator details
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "UEEDU18713002733");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "UEEDU18713002733");
        driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), desiredCapabilities);
    }

    public void iosSetup() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
        File app = new File(appDir, "sopy.app");
        desiredCapabilities.setCapability("platformVersion", "9.2");
        desiredCapabilities.setCapability("deviceName", "iPhone 6");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(appiumDriverLocalService.getUrl(), desiredCapabilities);
    }

    public String getPlatformPropertyByKey(String str) {
        try (InputStream input = new FileInputStream("property/android.properties")) {
            properties.load(input);
            return properties.getProperty(str, "android"); // Provide a default value if the property is not found
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error loading properties", e);
        }
//        return properties.getProperty(str);
    }

    public void startServer() {

        System.setProperty("APPIUM_BASE_PATH", "/wd/hub");
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1");
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.withCapabilities(desiredCapabilities);
//        appiumServiceBuilder.withArgument("--base-path", "/wd/hub");
        appiumServiceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
        System.out.println("URL: " + appiumDriverLocalService.getUrl());
    }

    public void stopServer() {
        appiumDriverLocalService.stop();
    }

    public AppiumDriver<MobileElement> getMobileDriver() {
        if (driver == null) {
            getDriver();
        }
        return driver;
    }
}
