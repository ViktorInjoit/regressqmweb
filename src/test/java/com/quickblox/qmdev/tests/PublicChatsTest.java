package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserChats;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PublicChatsTest extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    private final By USER_ON_LEFT_SIDE_TEST_USER_2 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 2']");
    private final By USER_ON_LEFT_SIDE_TEST_USER_3 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 3']");
    private final By USER_ON_LEFT_SIDE_TEST_USER_4 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 4']");

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
        welcomePage.logInViaEmail(testEmail2, testPass, tempPass);

        userLoggedInPage.searchingContactsButton("test user 3");
        userChats.sendAddRequestToUser();
        refreshPage();
        userLoggedInPage.searchingContactsButton("test user 4");
        userChats.sendAddRequestToUser();
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 61, enabled = true)
    public void user3AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail3, testPass, tempPass);

        userChats.acceptRequest();
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 62, enabled = true)
    public void user4AcceptsRequestFromUser2() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail4, testPass, tempPass);

        userChats.acceptRequest();
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 63, enabled = true)
    public void user2CreatesPublicChatWithUsers3And4() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail2, testPass, tempPass);

        userChats.user2CreatesChatWithUser3And4(USER_ON_LEFT_SIDE_TEST_USER_3);
        userChats.typeInPublicChat(userMessage1);
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 65, enabled = true)
    public void user3Types() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail3, testPass, tempPass);

        userChats.typeInPublicChat(userMessage2);
    }

    @Test (dependsOnMethods = "user2LogInsAndSendsRequestsToAddForUsers3And4", priority = 66, enabled = true)
    public void user4Types() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail4, testPass, tempPass);

        userChats.typeInPublicChat(userMessage3);
    }

    @AfterClass
    public void user2DeletesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail2, testPass, tempPass);

        userChats.deleteAllContactsAndChats();
        tearDown();
    }

    @AfterClass
    public void user3RemovesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail3, testPass, tempPass);

        userChats.deleteAllContactsAndChats();
        tearDown();
    }

    @AfterClass
    public void user4removesContactsAndChat() {
        setUp();
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserChats userChats = new UserChats(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmail(testEmail4, testPass, tempPass);

        userChats.deleteAllContactsAndChats();
        tearDown();
    }
}
