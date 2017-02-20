package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class PublicChatsTest extends BaseTest {

    @Test (priority = 60, enabled = false)
    public void user2LogInsAndSendsRequestsToAdd() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.searchForUsers3And4AndSendRequestsToThem();
    }

    @Test (priority = 61, enabled = false)
    public void user3AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser3();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.user3AcceptsRequest();
    }

    @Test (priority = 62, enabled = false)
    public void user4AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser4();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.user4Acceptsrequest();
    }

    @Test (priority = 63, enabled = false)
    public void user2CreatesChatWithUsers3And4() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.user2CreatesChatWithUser3And4();
    }

    @Test (priority = 64, enabled = true)
    public void user2Types() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.user2TypesInChat();
    }

    @Test (priority = 65, enabled = true)
    public void user3Types() {

    }

    @Test (priority = 66, enabled = true)
    public void user4Types() {

    }

    @AfterClass
    public void user2DeletesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.user2DeletesChatAndContacts();
    }

    @AfterClass
    public void user3DeletesContactsAndChat() {

    }

    @AfterClass
    public void user4DeletesContactsAndChat() {

    }
}
