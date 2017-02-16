package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.WelcomePage;
import org.testng.annotations.Test;


public class LinksCheckingsOnWelcomeTest extends BaseTest{


    /**<p>
     * Checking phone number form appeared
     * </p>*/
    @Test(priority = 1, enabled = true)
    public void verifyingPhoneNumberForm() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.pressLogInWithPhoneNumber();
    }

    /**<p>
     * Checking footer links, such as Quickblox, appstore and android
     * </p>*/
    @Test (priority = 2, enabled = true)
    public void checkingFooterLinks() {
        WelcomePage welcomePage = new WelcomePage(driver, wait);
        welcomePage.visit();
        welcomePage.checkingTheQBButton();
        welcomePage.clickTheiOSButton();
        welcomePage.clickTheAndroidButton();
    }
}
