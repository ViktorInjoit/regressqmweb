package com.quickblox.qmdev.pages;

import com.quickblox.qmdev.initializations.Wrappers;
import com.quickblox.qmdev.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends Wrappers{

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

    //test data
    public final String testEmail1 = "user1@dmail.com";
    public final String testEmail2 = "user2@dmail.com";
    public final String testEmail3 = "user3@dmail.com";
    public final String testEmail4 = "user4@dmail.com";
    public final String testPass = "12345678";
    public final String tempPass = "123456789";
}
