package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {

    @Test(priority = 20, enabled = true)
    public void searchTopLeftField() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.searchFieldOnPage();
        refreshPage();
    }

    @Test(priority = 21, dependsOnMethods = "searchTopLeftField", enabled = true)
    public void searchForFriendsRedButtonClick() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.searchForFriendsRedButton();
        refreshPage();
    }

    @Test(priority = 22, dependsOnMethods = "searchTopLeftField", enabled = true)
    public void checkContactsButton() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);
        userLoggedInPage.searchContactsButton();
        userLoggedInPage.logOutByEmail();
    }
}
