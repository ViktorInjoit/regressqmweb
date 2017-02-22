package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserChats;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsersCollaboratingTest extends BaseTest {


    private SoftAssert softAssert;

    @BeforeClass
    public void initializations() {
        softAssert = new SoftAssert();
    }

    @Test (priority = 40, enabled = true)
    public void user1SendsRequestToUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.searchingForFriendsRedButton();
        userLoggedInPage.searchingforUser2();

        softAssert.assertEquals(getText(FOUND_USER),"Test User 2");

        UserChats userChats = new UserChats(driver, wait);
        userChats.sendAddRequestToUser();

        softAssert.assertEquals(getText(REQUEST_SENT), "Request Sent");
        softAssert.assertAll();
    }

    @Test (priority = 41, enabled = true)
    public void user2RejectsRequestFromUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserChats userChats = new UserChats(driver, wait);
        userChats.rejectRequestToAddUser();
    }

    @Test (priority = 42, enabled = true)
    public void user1SendsRequestToUser2Again() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserChats userChats = new UserChats(driver, wait);
        userChats.sendRequestAgain();
    }

    @Test (priority = 43, enabled = true)
    public void user2AcceptsRequestFromUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserChats userChats = new UserChats(driver, wait);
        userChats.acceptRequest();
    }

    @Test (priority = 44, enabled = true)
    public void user1TypesInPrivateChatToUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserChats userChats = new UserChats(driver, wait);
        userChats.typeInPrivateChat();
    }

    @Test (priority = 45, enabled = true)
    public void user2AcceptsTheMessageFromUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserChats userChats = new UserChats(driver, wait);
        userChats.messageVerify();

        waitUntilElementLocated(LAST_RECEIVED_MESSAGE);
        softAssert.assertEquals(getText(LAST_RECEIVED_MESSAGE), "Hello for test user!");
        softAssert.assertAll();
    }

    @Test (priority = 46, enabled = true)
    public void user1DeletesUser2FromContacts() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserChats userChats = new UserChats(driver, wait);
        userChats.deleteUserFromContacts(); //check pauses
    }

    @Test (priority = 47, enabled = true)
    public void user2VerifiesDeletedUser1() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();
        UserChats userChats = new UserChats(driver, wait);
        userChats.verifyingDeletedUser();

        waitUntilElementLocated(YOU_HAVE_BEEN_DELETED);
        softAssert.assertEquals(getText(YOU_HAVE_BEEN_DELETED), "You have been deleted from the contact list");
        softAssert.assertAll();
    }
}
