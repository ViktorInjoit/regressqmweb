package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.initializations.Wrappers;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest extends Wrappers {

    private static String currentBrowser = "Chrome";
    private static String currentDomain = "https://qmdev.quickblox.com/";

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    /**
     * ChromeDriver for Mac
     */
    private WebDriver setChromeDriver() {
//        String pathToChrome = Paths.get("./src/test/resources/chromedriver_mac").toAbsolutePath().toString();
        String pathToChrome = Paths.get("./src/test/resources/chromedriver.exe").toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", pathToChrome);
        WebDriver driverChrome = new ChromeDriver();



        driverChrome.get(currentDomain);
        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driverChrome.manage().window().setSize(new Dimension(1920, 1080));

        this.webDriverWait = new WebDriverWait(driverChrome, 10);
        return driverChrome;
    }
    public static String getCurrentBrowser() {
        return currentBrowser;
    }

    public static String getCurrentDomain() {
        return currentDomain;
    }

    @Override
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Parameters({"browser", "domain"})
    @BeforeTest
    public void setUpBrowserAndDomain(String browser, String domain) {
        this.currentBrowser = browser;
        this.currentDomain = domain;
    }

    @BeforeTest
    public void setUp() {
        if ("Chrome".equals(currentBrowser)) {
            driver = setChromeDriver();
        }
        //else if browsers here
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
