package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.Test;

public class UsersCollaboratingTest extends BaseTest {

    @Test (priority = 40, enabled = true)
    public void user1SendsRequestToUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.searchForFriendsRedButton();
        userLoggedInPage.sendAddRequestToUser();
    }

    @Test (priority = 41, enabled = true)
    public void user2RejectsRequestFromUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver,wait);
        userLoggedInPage.rejectRequestToAddUser();
    }

    @Test (priority = 42, enabled = true)
    public void user1SendsRequestToUser2Again() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.sendRequestAgain();
    }

    @Test (priority = 43, enabled = true)
    public void user2AcceptsRequestFromUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.acceptRequest();
    }

    @Test (priority = 44)
    public void user1TypesInPrivateChatToUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.typeInChat();
    }

    @Test (priority = 45, enabled = true)
    public void user2AcceptsTheMessageFromUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.messageVerify();
    }

    @Test (priority = 46, enabled = true)
    public void user1DeletesUser2FromContacts() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.deleteUserFromContacts();
    }

    @Test (priority = 47, enabled = true)
    public void user2VerifiesDeletedUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.verifyingDeletedUser();
    }
}
