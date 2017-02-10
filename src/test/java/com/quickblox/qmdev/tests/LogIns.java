package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.BasePage;
import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.UserProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogIns extends BasePage {


    private WelcomePage welcomePage;
    private UserProfilePage userProfilePage;

    public LogIns(WebDriver webDriver) {
        super(webDriver);
    }

    @BeforeMethod
    public void initializingPages() {
        welcomePage = new WelcomePage(getWebDriver());
        userProfilePage = new UserProfilePage(getWebDriver());
    }

    @Test
    public void logInByEmail() {
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail();
        userProfilePage.logOut();
    }

    @Test
    public void logInByFacebook() {

    }

}
