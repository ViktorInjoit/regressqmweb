package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.Profile;
import com.quickblox.qmdev.pages.userprofile.Settings;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserOptionsTest extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test(priority = 30, enabled = true)
    public void checkProfile() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
    }

    @Test(priority = 31, dependsOnMethods = "checkProfile", enabled = true)
    public void checkName() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.changeName();
    }

    @Test(priority = 32, dependsOnMethods = "checkProfile", enabled = true)
    public void checkStatus() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.changeStatus();
    }

    @Test(priority = 33, dependsOnMethods = "checkProfile", enabled = true)
    public void checkPhoneNumber() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.changePhoneNumber();
        refreshPage();
    }

    @Test(priority = 34, dependsOnMethods = "checkProfile", enabled = true)
    public void checkSettings() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Settings settings = new Settings(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openSettingsPopup();
        settings.clickWriteFeedback();
        settings.clickAbout();
        userLoggedInPage.closeSettingsPopup();
    }

    @Test(priority = 35, dependsOnMethods = "checkProfile", enabled = true)
    public void checkingFooterButtons() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.checkingQBButton();
        userLoggedInPage.checkingiOSButton();
        userLoggedInPage.checkingAndroidButton();
    }

    @Test(priority = 36, dependsOnMethods = "checkProfile", enabled = true)
    public void editPassword() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.changePassword();
        softAssert.assertEquals(getText(CHANGE_PASSWORD_SUCCESS_MESSAGE), "Your password has been successfully changed");
        refreshPage();
        softAssert.assertAll();
    }

    @Test(priority = 37, dependsOnMethods = "checkProfile", enabled = true)
    public void editPasswordNegative() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.changePasswordNegative();
        softAssert.assertEquals(getText(OLD_PASSWORD_IS_INCORRECT_MESSAGE), "Old password is incorrect");
        refreshPage();
        softAssert.assertAll();
    }

    @AfterClass(enabled = true)
    public void rollbackAfterChangesNameStatusPhone() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.rollbackAfterChangeNameStatusPhone();
        tearDown();
    }

    @AfterClass(enabled = true)
    public void rollbackAfterPasswordEditing() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        Profile profile = new Profile(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail1, testPass, tempPass);

        userLoggedInPage.openProfile();
        profile.rollbackAfterEditingPassword();
        if (isElementPresented(OLD_PASSWORD_IS_INCORRECT_MESSAGE)) {
            softAssert.assertEquals(getText(OLD_PASSWORD_IS_INCORRECT_MESSAGE), "Old password is incorrect");
        }
        tearDown();
    }
}
