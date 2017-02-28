package com.quickblox.qmdev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By LOGIN_WITH_PHONE_NUMBER_BUTTON = findByXPath(".//*[@class='btn l-welcome_btn l-welcome_btn_green j-twitterDigits'][contains(text(),'connect with phone number')]");
    private final By LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON = findById("loginQB");
    private final By EMAIL_FIELD = findById("login-email");
    private final By PASS_FIELD = findById("login-password");
    private final By LOG_IN_BUTTON = findById("loginForm");

    private final By LOG_IN_FACEBOOK_BUTTON = findById("loginFB");
    private final By LOGIN_FORM_FACEBOOK = findById("email");
    private final By PASSWORD_FORM_FACEBOOK = findById("pass");
    private final By SUBMIT_BUTTON_FACEBOOK = findById("u_0_2");

    private final By QUICKBLOX_LOGO_FOOTER_BUTTON = findByXPath(".//*[@class='i-mini_logo']");
    private final By IOS_APP_FOOTER_BUTTON = findByXPath(".//*[@class='i-appstore']");
    private final By ANDROID_APP_FOOTER_BUTTON = findByXPath(".//*[@class='i-android']");

    private final By QB_GET_STARTED = findByXPath(".//*[@class='btn extra large']");
    private final By ITUNES = findByXPath("//*[@class='lockup product application']//span[text()='View in iTunes']");
    private final By PLAY_MARKET_QM = findByXPath("//*[@class='document-subtitle primary']");

    private final By PHONE_NUMBER_APPEARED_ERROR = findByXPath(".//*[@class='input-error']");


    public void visit() {
        open(currentDomain);
    }

    /**<p>Phone number button click
     * Then press the submit button</p>*/
    public void pressLogInWithPhoneNumber() {
        click(LOGIN_WITH_PHONE_NUMBER_BUTTON);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().frame(driver.findElement(findByCss(".digits-embed")));
        click(findByXPath("//button[@type='submit']"));
        waitUntilElementLocated(PHONE_NUMBER_APPEARED_ERROR);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    /**
     * <p> Pressing the "Log in by email or social" button
     *</p>*/
    public void pressLogInByEmailOrSocial() {
        click(LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON);
    }

    /**<p>
     * Note: that users should be stored in the DB before testing
     * Note: before using these methods invoke pressLogInByEmailOrSocial() this method first
     * </>*/
    public WelcomePage logInViaEmail(final String testEmail, final String testPass, final String temporaryPass) {
        clearAndType(EMAIL_FIELD, testEmail);
        clearAndType(PASS_FIELD, testPass);
        click(LOG_IN_BUTTON);
        if (isElementPresented(LOG_IN_BUTTON)) {
            clearAndType(PASS_FIELD, temporaryPass);
            click(LOG_IN_BUTTON);
            return this;
        }
        return this;
    }

    /**<p>Log in via facebook
     * Note: before using this method invoke pressLogInByEmailOrSocial() this method first
     * </p>*/
    public WelcomePage logInViaFacebook() {
        click(LOG_IN_FACEBOOK_BUTTON);
        pause(1000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String LOGIN_FACEBOOK = "injoittest@gmail.com";
        clearAndType(LOGIN_FORM_FACEBOOK, LOGIN_FACEBOOK);
        String PASSWORD_FACEBOOK = "injoit00";
        clearAndType(PASSWORD_FORM_FACEBOOK, PASSWORD_FACEBOOK);
        click(SUBMIT_BUTTON_FACEBOOK);
        pause(3000);
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    /**<p>Negative check log in via email
     * </p>*/
    public void negativeLogInViaEmailWithEmptyPasswordField() {
        logInViaEmail(testEmail1, "", "");
    }

    public void negativeLogInViaEmailWith3CharactersPassword() {
        logInViaEmail(testEmail1, "123", "123");
    }

    public void negativeLogInViaEmailwith8CharactersPassword() {
        logInViaEmail(testEmail1, "12345670", "12345670");
    }

    public void negativeLogInViaEmailWith10CharactersPassword() {
        logInViaEmail(testEmail1, "12345670", "12345670");
    }



    /**<p>
     * Just footer buttons
     * </p>*/
    private void checkingFooterButtons(final By footerButton, final By elementOnOtherPage) {
        click(footerButton);
        pause(1000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitUntilElementToBeClickable(elementOnOtherPage);
        click(elementOnOtherPage);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void checkingTheQBButton() {
        checkingFooterButtons(QUICKBLOX_LOGO_FOOTER_BUTTON, QB_GET_STARTED);
    }

    public void checkingTheiOSButton() {
        checkingFooterButtons(IOS_APP_FOOTER_BUTTON, ITUNES);
    }

    public void checkingTheAndroidButton() {
        checkingFooterButtons(ANDROID_APP_FOOTER_BUTTON, PLAY_MARKET_QM);
    }
}
