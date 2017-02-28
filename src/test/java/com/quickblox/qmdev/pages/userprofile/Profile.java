package com.quickblox.qmdev.pages.userprofile;

import com.quickblox.qmdev.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.quickblox.qmdev.tests.BaseTest.getUniqueId;
import static com.quickblox.qmdev.tests.BaseTest.getUniqueValue;

public class Profile extends BasePage {

    public Profile(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By USER_NAME = findByXPath("//*[@class='userProfile-filename-wrap']/input[@placeholder='Your name']");
    private final By STATUS_FIELD = findByXPath("//*[@class='userProfile-status-field userProfile-edit']");
    private final By PHONE_NUMBER_FIELD = findByXPath("//*[@class='userProfile-phone editable-profile without_M']");

    private final By CHANGE_PASSWORD = findByXPath("//*[@class='btn_userProfile btn_changePassword']");
    private final By OLD_PASSWORD = findById("old-password");
    private final By NEW_PASSWORD = findById("new-password");
    private final By CHANGE_PASSWORD_BUTTON = findByXPath("//*[@class='btn btn_popup btn_popup_changepass without_M']");



//    public final By CHANGE_PASSWORD_SUCCESS_MESSAGE = findByXPath("//*[@class='userProfile-success']");

    private String testUserName = "Test User " + getUniqueValue();
    private String testStatus = "My test status" + getUniqueValue();
    private String testPhoneNumber = "11 1 " + getUniqueId();

    public void changeName() {
        click(USER_NAME);
        clearAndType(USER_NAME, testUserName);
    }

    public void changeStatus() {
//        click(STATUS_FIELD);
        new Actions(driver).moveToElement(driver.findElement(STATUS_FIELD), 230, 50).click().perform();
        clearAndType(STATUS_FIELD, testStatus);
    }

    public void changePhoneNumber() {
        clearAndType(PHONE_NUMBER_FIELD, testPhoneNumber);
    }

    public void rollbackAfterChangeNameStatusPhone() {
        click(USER_NAME);
        clearAndType(USER_NAME, "Test User 1");
        new Actions(driver).moveToElement(driver.findElement(STATUS_FIELD), 230, 50).click().perform();
        clearAndType(STATUS_FIELD, "");
        clearAndType(PHONE_NUMBER_FIELD, "");
    }

    public Profile changePassword(final String testPass, final String temporaryPass) {
        click(CHANGE_PASSWORD);
        type(OLD_PASSWORD, testPass);
        type(NEW_PASSWORD, temporaryPass);
        click(CHANGE_PASSWORD_BUTTON);
        if (isElementPresented(OLD_PASSWORD_IS_INCORRECT_MESSAGE)) {
            clearAndType(OLD_PASSWORD, temporaryPass);
            clearAndType(NEW_PASSWORD, testPass);
            click(CHANGE_PASSWORD_BUTTON);
            pause(2000);
//            waitUntilElementLocated(USER_NAME);
            return this;
        }
//        waitUntilElementLocated(USER_NAME);
        pause(2000);
        return this;
    }
}
