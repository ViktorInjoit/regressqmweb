package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.Test;


public class LogInsTest extends BaseTest {


    @Test (priority = 10, enabled = true)
    public void logInByEmail() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        refreshPage();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.logOutByEmail();
    }

    @Test(priority = 11, enabled = true)
    public void logInByFacebook() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaFacebook();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.logOutByFacebook();
    }

    @Test(priority = 12, enabled = true)
    public void logInByEmailNegative() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailWithEmptyPasswordField();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailWith3CharactersPassword();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailwith8CharactersPassword();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailWith10CharactersPassword();
    }
}
