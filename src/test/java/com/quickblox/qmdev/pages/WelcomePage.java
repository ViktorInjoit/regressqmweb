package com.quickblox.qmdev.pages;

import com.quickblox.qmdev.pages.users.TestUser1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private SoftAssert softAssert = new SoftAssert();

    private TestUser1 testUser1 = new TestUser1(testEmail1, testPass, tempPass);

//    public final By HOME = findById("home");

    private final By LOGIN_WITH_PHONE_NUMBER_BUTTON = findByXPath(".//*[@class='btn l-welcome_btn l-welcome_btn_green j-twitterDigits'][contains(text(),'connect with phone number')]");
    private final By LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON = findById("loginQB");
    private final By EMAIL_FIELD = findById("login-email");
    private final By PASS_FIELD = findById("login-password");
    private final By LOG_IN = findById("loginForm");

    private final By LOG_IN_FACEBOOK_BUTTON = findById("loginFB");
    private final By LOGIN_FORM_FACEBOOK = findById("email");
    private final By PASSWORD_FORM_FACEBOOK = findById("pass");
    private final By SUBMIT_BUTTON_FACEBOOK = findById("u_0_2");

    private final By QUICKBLOX_LOGO_BUTTON = findByXPath(".//*[@class='i-mini_logo']");
    private final By IOS_APP_FOOTER_BUTTON = findByXPath(".//*[@class='i-appstore']");
    private final By ANDROID_APP_FOOTER_BUTTON = findByXPath(".//*[@class='i-android']");

    private final By QB_GET_STARTED = findByXPath(".//*[@class='btn extra large']");
    private final By QB_START_BUILDING = findByXPath(".//*[@id='signup-submit']");

    private final By ITUNES = findByXPath("//*[@class='lockup product application']//span[text()='View in iTunes']");

    private final By PLAY_MARKET_QM = findByXPath("//*[@class='document-subtitle primary']");

    private final By PHONE_NUMBER_APPEARED_ERROR = findByXPath(".//*[@class='input-error']");
    private final By LOG_IN_APPEARED_ERROR = findByXPath("//*[@class='text_error is-error']");

    private final String LOGIN_FACEBOOK = "injoittest@gmail.com";
    private final String PASSWORD_FACEBOOK = "injoit00";

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
        waitUntilElementVisible(PHONE_NUMBER_APPEARED_ERROR);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    /**
     * <p> Pressing the "Log in by email or social" button
     *</p>*/
    public void pressLogInByEmailOrSocial() {
        click(LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON);
    }

    /**<p> Note that users should be stored in the DB before testing
     * Note: before using these methods invoke pressLogInByEmailOrSocial() this method first
     * </>*/
    public WelcomePage logInViaEmailUser1() {
        clearAndType(EMAIL_FIELD, testUser1.getEmail());
        clearAndType(PASS_FIELD, testUser1.getTestPass());
        click(LOG_IN);
        if (isElementPresented(LOG_IN_APPEARED_ERROR)) {
            clearAndType(PASS_FIELD, testUser1.getTempPass());
            click(LOG_IN);
            return this;
        }
        return this;
    }

//    public WelcomePage logInViaEmailUser2() {
//        clearAndType(EMAIL_FIELD, testEmail2);
//        clearAndType(PASS_FIELD, testPass);
//        click(LOG_IN);
//        return new WelcomePage(driver, wait);
//    }
//
//    public WelcomePage logInViaEmailUser3() {
//        clearAndType(EMAIL_FIELD, testEmail3);
//        clearAndType(PASS_FIELD, testPass);
//        click(LOG_IN);
//        return new WelcomePage(driver, wait);
//    }
//
//    public WelcomePage logInViaEmailUser4() {
//        clearAndType(EMAIL_FIELD, testEmail4);
//        clearAndType(PASS_FIELD, testPass);
//        click(LOG_IN);
//        return new WelcomePage(driver, wait);
//    }

    /**<p>Log in via facebook
     * Note: before using this method invoke pressLogInByEmailOrSocial() this method first
     * </p>*/
    public WelcomePage logInViaFacebook() {
        click(LOG_IN_FACEBOOK_BUTTON);
        pause(1000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        clearAndType(LOGIN_FORM_FACEBOOK, LOGIN_FACEBOOK);
        clearAndType(PASSWORD_FORM_FACEBOOK, PASSWORD_FACEBOOK);
        click(SUBMIT_BUTTON_FACEBOOK);
        pause(3000);
        driver.switchTo().window(tabs.get(0));
        return new WelcomePage(driver, wait);
    }

    /**<p>Negative check log in via email
     * @param email is actual from DB
     * @param password could be any kind (empty or with wrong symbols)</p>*/
    public void negativeLogInViaEmailWithEmptyPasswordField() {
        //with empty password field
        clearAndType(EMAIL_FIELD, testUser1.getEmail());
        clearAndType(PASS_FIELD, "");
        click(LOG_IN);
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), "is required");
        refreshPage();
    }

    public void negativeLogInViaEmailWith3CharactersPassword() {
        clearAndType(EMAIL_FIELD, testUser1.getEmail());
        clearAndType(PASS_FIELD, "123");
        click(LOG_IN);
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), "Error");
        refreshPage();
    }

    public void negativeLogInViaEmailwith8CharactersPassword() {
        clearAndType(EMAIL_FIELD, testUser1.getEmail());
        clearAndType(PASS_FIELD, "12345670");
        click(LOG_IN);
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), "The email or password is incorrect");
        refreshPage();
    }

    public void negativeLogInViaEmailWith10CharactersPassword() {
        clearAndType(EMAIL_FIELD, testUser1.getEmail());
        clearAndType(PASS_FIELD, "1234567890");
        click(LOG_IN);
        softAssert.assertEquals(getText(LOG_IN_APPEARED_ERROR), "The email or password is incorrect");
        softAssert.assertAll();
        refreshPage();
    }



    /**<p>Just footer buttons</p>*/
    public void checkingTheQBButton() {
        click(QUICKBLOX_LOGO_BUTTON);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitUntilElementToBeClickable(QB_GET_STARTED);
        click(QB_GET_STARTED);
        waitUntilElementVisible(QB_START_BUILDING);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void clickTheiOSButton() {
        click(IOS_APP_FOOTER_BUTTON);
        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        waitUntilElementToBeClickable(ITUNES);
        click(ITUNES);
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }

    public void clickTheAndroidButton() {
        click(ANDROID_APP_FOOTER_BUTTON);
        pause(1000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        waitUntilElementToBeClickable(PLAY_MARKET_QM);
        click(PLAY_MARKET_QM);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }
}
