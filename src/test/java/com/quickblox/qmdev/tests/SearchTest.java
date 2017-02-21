package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import com.quickblox.qmdev.pages.userprofile.UserLoggedInPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SearchTest extends BaseTest {

    private SoftAssert softAssert;

    @BeforeClass
    public void initializations() {
        softAssert = new SoftAssert();
    }

    @Test(priority = 20, enabled = true)
    public void searchTopLeftField() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();

        userLoggedInPage.searchingForUsersFieldOnPage();
        if (driver.findElement(SORRY_MESSAGE).isDisplayed()) {
            click(GLOBAL_SEARCH_BLUE_BUTTON);
            waitUntilElementToBeClickable(FOUND_USER);
            new Actions(driver).moveToElement(driver.findElement(findByXPath("//*[@class='l-flexbox_inline']")), 210, 15).click().perform();
            softAssert.assertEquals(getText(FOUND_USER),"Test User 2");
        }
        refreshPage();
        softAssert.assertAll();
    }

    @Test(priority = 21, dependsOnMethods = "searchTopLeftField", enabled = true)
    public void searchForFriendsRedButtonClick() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();

        userLoggedInPage.searchingForFriendsRedButton();
        userLoggedInPage.searchingforUser2();
        userLoggedInPage.cleanSearchField();
        userLoggedInPage.searchingforUser2();

        softAssert.assertEquals(getText(FOUND_USER), "Test User 2");
        refreshPage();
        softAssert.assertAll();
    }

    @Test(priority = 22, dependsOnMethods = "searchTopLeftField", enabled = true)
    public void checkContactsButton() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver, wait);

        welcomePage.visit();
        welcomePage.pressLogInByEmailOrSocial();
        welcomePage.logInViaEmailUser1();

        userLoggedInPage.searchingContactsButton();
        softAssert.assertEquals(getText(FOUND_USER), "Test User 2");
        userLoggedInPage.cleanSearchField();
        refreshPage();
        userLoggedInPage.logOutByEmail();
        softAssert.assertAll();
    }
}
