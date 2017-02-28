package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LogInsTest extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    private String err_msg_empty_field = "is required";
    private String err_msg_error = "Error";
    private String err_msg_invalid_pass = "The email or password is incorrect";

    private final By LOG_IN_APPEARED_ERROR = findByXPath("//*[@class='text_error is-error']");

    @Test (priority = 10, enabled = true)
    public void logInByEmail() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.logOutByEmail();
    }

    @Test(priority = 11, enabled = true)
    public void logInByFacebook() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaFacebook();

        userLoggedInPage.logOutByFacebook();
    }

    @Test(priority = 12, enabled = true)
    public void logInByEmailNegative() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();

        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailWithEmptyPasswordField();
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), err_msg_empty_field);
        refreshPage();

        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailWith3CharactersPassword();
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), err_msg_error);
        refreshPage();

        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailwith8CharactersPassword();
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), err_msg_invalid_pass);
        refreshPage();

        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.negativeLogInViaEmailWith10CharactersPassword();
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), err_msg_invalid_pass);

        softAssert.assertAll();
    }
}
