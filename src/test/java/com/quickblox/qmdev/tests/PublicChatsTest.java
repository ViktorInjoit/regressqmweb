package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserChats;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PublicChatsTest extends BaseTest {

    private SoftAssert softAssert;

    @BeforeClass
    public void initializations() {
        softAssert = new SoftAssert();
    }

    @Test (priority = 60, enabled = false)
    public void user2LogInsAndSendsRequestsToAddForUsers3And4() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();

        userLoggedInPage.searchingContactsButton();
        userLoggedInPage.searchingForUser3();
        userChats.sendAddRequestToUser();
        userLoggedInPage.searchignForUser4();
        userChats.sendAddRequestToUser();
    }

    @Test (priority = 61, enabled = false)
    public void user3AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser3();

        userChats.acceptRequest();
    }

    @Test (priority = 62, enabled = false)
    public void user4AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser4();

        userChats.acceptRequest();
    }

    @Test (priority = 63, enabled = false)
    public void user2CreatesPublicChatWithUsers3And4() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();


        userLoggedInPage.user2CreatesChatWithUser3And4();
    }

    @Test (priority = 64, enabled = true)
    public void user2Types() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();

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
