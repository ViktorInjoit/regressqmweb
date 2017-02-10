package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.nio.file.Paths;
import java.util.HashMap;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private static String currentBrowser = "Chrome";
    public static String currentDomain = "https://qmdev.quickblox.com/";

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private SoftAssert softAssert;



    @BeforeTest
    public void initDriver() {
        if (System.getProperty("selenium.browser") == null) {
            System.setProperty("selenium.browser", "chrome");
        }

        webDriver = getNewDriver();
        webDriverWait = new WebDriverWait(webDriver, 15);
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void destroyDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @BeforeSuite
    private WebDriver getNewDriver() {
        String path = System.getProperty("user.dir");
        //Setting up the chrome driver
        if (webDriver == null && System.getProperty("selenium.browser").equals("chrome")) {
            //Defining the OS
            if (System.getProperty("os.name").contains("Windows")) {
                Reporter.log("Starting chrome driver for windows", true);
                System.setProperty("webdriver.chrome.driver", Paths.get("./src/test/resources/chromedriver.exe").toAbsolutePath().toString());
            } else if (System.getProperty("os.name").contains("Mac OS")) {
                Reporter.log("Starting chrome driver for Mac OS", true);
                System.setProperty("webdriver.chrome.driver", Paths.get("./src/test/resources/chromedriver_mac").toAbsolutePath().toString());
            }
            //setting options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--desktop-window-1080p");
            options.addArguments("start-maximized");

            String downloadFilePath = path + "/downloads";
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilePath);

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            webDriver = new ChromeDriver(options);
        } else if (webDriver == null && System.getProperty("selenium.browser").equals("firefox")) {
            if (System.getProperty("os.name").contains("Windows")) {
                Reporter.log("Starting firefox driver for windows", true);
                System.setProperty("webdriver.chrome.driver", Paths.get("./src/test/resources/geckodriver.exe").toAbsolutePath().toString());
            } else if (System.getProperty("os.name").contains("Mac OS")) {
                Reporter.log("Starting firefox driver for Mac OS", true);
                System.setProperty("webdriver.chrome.driver", Paths.get("./src/test/resources/geckodriver_mac").toAbsolutePath().toString());
            }
            //realization here
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }
}
