package com.quickblox.qmdev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage extends BasePage {

//    private WebDriverWait webDriverWait;

    public UserProfilePage(WebDriver driver) {
        super(driver);
//        this.webDriverWait = new WebDriverWait(driver, 60);
    }

//    @Override
//    public WebDriverWait getWebDriverWait() {
//        return webDriverWait;
//    }

    private By USER_ICON = findByXpath(".//*[@data-id='23558113']");
    private By LOG_OUT = findById("logout");
    private By LOG_OUT_POPUP_CANCEL = findByXpath(".//*[@class='popup-control-button popup-control-button_cancel']");
    private By LOG_OUT_POPUP_OK = findById("logoutConfirm");
    private By LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON = findById("loginQB");

    private By IOS_APP_FOOTER_BUTTON = findByXpath(".//*[@class='footer-apps-ios']");
    private By ANDROID_APP_FOOTER_BUTTON = findByXpath(".//*[@href='https://play.google.com/store/apps/details?id=com.quickblox.q_municate']");

    public void logOut() {
        click(USER_ICON);
        click(LOG_OUT);
        click(LOG_OUT_POPUP_CANCEL);

        click(USER_ICON);
        click(LOG_OUT);
        click(LOG_OUT_POPUP_OK);
        isElementPresented(LOGIN_BY_EMAIL_OR_SOCIAL_BUTTON);
    }
}
