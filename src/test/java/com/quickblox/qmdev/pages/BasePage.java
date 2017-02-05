package com.quickblox.qmdev.pages;

import com.quickblox.qmdev.initializations.Wrappers;
import com.quickblox.qmdev.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends BaseTest{

    public String openedBrowser = BaseTest.getCurrentBrowser();
    public String currentDomain = BaseTest.getCurrentDomain();


    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
//        this.webDriverWait = getWebDriverWait();
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    @Override
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
