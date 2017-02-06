package com.quickblox.qmdev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage {

//    private WebDriverWait webDriverWait;

    public WelcomePage(WebDriver driver) {
        super(driver);
//        webDriverWait = new WebDriverWait(this.driver, 60);
    }

//    public WelcomePage(WebDriverWait webDriverWait) {
//        super(webDriverWait);
//    }

//    @Override
//    public WebDriverWait getWebDriverWait() {
//        return webDriverWait;
//    }

    private By LOGIN_WITH_PHONE_NUMBER_BUTTON = findByXpath(".//*[@class='btn l-welcome_btn l-welcome_btn_green j-twitterDigits'][contains(text(),'connect with phone number')]");
    private By LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON = findById("loginQB");
    private By EMAIL_FIELD = findById("login-email");
    private By PASS_FIELD = findById("login-password");
    private By LOG_IN = findById("loginForm");

    private By QUICKBLOX_LOGO_BUTTON = findByXpath(".//*[@class='i-mini_logo']");
    private By IOS_APP_FOOTER_BUTTON = findByXpath(".//*[@class='i-appstore']");
    private By ANDROID_APP_FOOTER_BUTTON = findByXpath(".//*[@class='i-android']");


    //test data
    private String testEmail1 = "user1@dmail.com";
    private String testEmail2 = "user2@dmail.com";
    private String testEmail3 = "user3@dmail.com";
    private String testEmail4 = "user4@dmail.com";
    private String testPass = "12345678";



    /**Phone number button click*/
    public void pressLogInWithPhoneNumber() {
        click(LOGIN_WITH_PHONE_NUMBER_BUTTON);
    }

//    final By APPEARED_ERROR = findByXpath(".//*[@class='input-error'][contains(text(),'Неверный номер телефонa')]");
//    public String getErrorMessage() {
//        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(APPEARED_ERROR)))).getText();
//    }

    /**
     * <p> Pressing the "Log in by email or social button
     *</p>*/
    public void pressLogInByEmailOrSocial() {
        click(LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON);
    }

    /**<p> Note that users should be stored in the DB before testing</>*/
    public WelcomePage logInViaEmail() {
        clearAndType(EMAIL_FIELD, testEmail1);
        clearAndType(PASS_FIELD, testPass);
        click(LOG_IN);
        return new WelcomePage(getWebDriver());
    }

    public void clickTheQBButton() {
        click(QUICKBLOX_LOGO_BUTTON);
    }

    public void clickTheiOSButton() {
        click(IOS_APP_FOOTER_BUTTON);
    }

    public void clickTheAndroidButton() {
        click(ANDROID_APP_FOOTER_BUTTON);
    }

}
