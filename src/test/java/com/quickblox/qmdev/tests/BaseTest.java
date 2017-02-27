package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.initializations.TestDataAndSelectors;
import com.quickblox.qmdev.utils.TestListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest extends TestDataAndSelectors {



    private static String currentBrowser = "chrome";
    private static String currentDomain = "https://qmdev.quickblox.com/";

    protected WebDriver driver;
    protected WebDriverWait wait;

//    Setting chromedriver for Linux and Windows. Remember that names of executable drivers files are different
//    protected  WebDriver setChromeDriver(){
//        String pathToChromeDriver = Paths.get("./src/test/resources/ChromeDriver/chromedriver_linux").toAbsolutePath().toString();
//        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        WebDriver chromeDriver = new ChromeDriver(options);
//        return chromeDriver;
//    }

    //    Setting chromedriver for Mac and Windows
    private WebDriver setChromeDriver(){
        String pathToChromeDriverMac = Paths.get("./src/test/resources/chromedrivers/chromedriver_mac").toAbsolutePath().toString();
        String pathToChromeDriverWin = Paths.get("./src/test/resources/chromedrivers/chromedriver.exe").toAbsolutePath().toString();
//        if (driver == null && System.getProperty("selenium.browser").equals("chrome")) {
            if (System.getProperty("os.name").contains("Windows")) {
                Reporter.log("Starting ChromeDriver for Windows", true);
                System.setProperty("webdriver.chrome.driver", pathToChromeDriverWin);
            } else if (System.getProperty("os.name").contains("Mac")) {
                Reporter.log("Starting ChromeDriver for Mac OS");
                System.setProperty("webdriver.chrome.driver", pathToChromeDriverMac);
            }
//        }
        HashMap<String, Object> preferences = new HashMap<>();
        preferences.put("profile.default_content_setting_values.notifications", 2);
        preferences.put("profile.default_content_settings.popups", 0);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", preferences);
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--desktop-window-1080p");
        chromeOptions.addArguments("--start-maximized");
        // this option may fail facebook log in
//        chromeOptions.addArguments("--disable-plugins");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        chromeDriver.manage().window().setSize(new Dimension(1920,1080));
        return chromeDriver;
    }

    private WebDriver setFirefoxDriver(){
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        firefoxDriver.manage().window().maximize();

        return firefoxDriver;
    }

    // Before use Safari driver - you should download the latest version from here - http://www.seleniumhq.org/download/
    // and add him to your Safari browser as browser extension
    private WebDriver setSafariDriver(){
        SafariDriver safariDriver;
        try {
            safariDriver = new SafariDriver();
        } catch (UnreachableBrowserException e){
            safariDriver = new SafariDriver();
        }

        safariDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        safariDriver.manage().window().maximize();

        return safariDriver;
    }

    private WebDriverWait setWebDriverWait() {
        return new WebDriverWait(driver, 15);
    }

    public static String getUniqueValue(){
        return UUID.randomUUID().toString().substring(1, 7);
    }

    public static String getUniqueId(){
        int var  = new Random(System.currentTimeMillis()).nextInt(9999999 - 111);
        return String.valueOf(var);
    }

    static public String getCurrentBrowser(){
        return currentBrowser;
    }

    static public String getCurrentDomain(){
        return currentDomain;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    public WebDriverWait getWebDriverWait() {
        return wait;
    }

    @Parameters({"browser", "domain"})
    @BeforeTest
    public void setUpBrowserAndDomain(String browser, String domain)
    {
        currentBrowser = browser;
        currentDomain = domain;
    }

    @BeforeMethod
    public void setUp()
    {
        switch (currentBrowser) {
            case "Chrome":
                driver = setChromeDriver();
                wait = setWebDriverWait();
                break;
            case "Firefox":
                driver = setFirefoxDriver();
                break;
            case "Safari":
                driver = setSafariDriver();
                break;
        }
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
