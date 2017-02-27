package com.quickblox.qmdev.pages;

import com.quickblox.qmdev.initializations.TestDataAndSelectors;
import com.quickblox.qmdev.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends TestDataAndSelectors{

    protected String openedBrowser = BaseTest.getCurrentBrowser();
    public static String currentDomain = BaseTest.getCurrentDomain();


    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    public WebDriverWait getWebDriverWait() {
        return wait;
    }

    public WelcomePage openWelcomePage() {
        open(currentDomain);
        return new WelcomePage(driver, wait);
    }
}
