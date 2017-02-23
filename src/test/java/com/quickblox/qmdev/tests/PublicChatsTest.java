package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserChats;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PublicChatsTest extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    private String userMessage1 = "Hey everybody!";
    private String userMessage2 = "Hello from user 3!";
    private String userMessage3 = "Hey! it's fourth";

    @Test (priority = 60, enabled = true)
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

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 61, enabled = true)
    public void user3AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser3();

        userChats.acceptRequest();
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 62, enabled = true)
    public void user4AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser4();

        userChats.acceptRequest();
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 63, enabled = true)
    public void user2CreatesPublicChatWithUsers3And4() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();

        userChats.user2CreatesChatWithUser3And4();
        userChats.typeInPublicChat(userMessage1);
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 65, enabled = true)
    public void user3Types() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser3();

        userChats.typeInPublicChat(userMessage2);
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 66, enabled = true)
    public void user4Types() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser4();

        userChats.typeInPublicChat(userMessage3);
    }

    @AfterClass
    public void user2DeletesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser2();

        userChats.deleteChat();
        userChats.removeUser3FromFriendList();
        refreshPage();
        userChats.removeUser4FromFriendList();
        tearDown();
    }

    @AfterClass
    public void user3RemovesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser3();

        userChats.deleteChat();
        userChats.removeUser2FromFriendList();
        tearDown();
    }

    @AfterClass
    public void user4removesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser4();

        userChats.deleteChat();
        userChats.removeUser2FromFriendList();
        tearDown();
    }
}
