package com.quickblox.qmdev.pages.userprofile;

import com.quickblox.qmdev.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class UserLoggedInPage extends BasePage {

    /**<p>
     * This page represents as already logged in user
     * </p>*/
    public UserLoggedInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private SoftAssert softAssert = new SoftAssert();

    private final By USER_ICON = findById("profile");
    private final By USER_PROFILE = findById("userProfile");

    private final By USER_SETTINGS = findById("userSettings");
    private final By CLOSE_SETTINGS_POPUP = findByXPath("//*[@class='i-close_settings j-close_settings']");
    private final By SETTINGS_HEADER = findByXPath("//*[@class='header_settings']");

    private final By LOG_OUT = findById("logout");
    private final By LOG_OUT_POPUP_BUTTON_CANCEL = findByXPath("//a[text()='Cancel'][following-sibling::a[@id='logoutConfirm']]");
    private final By LOG_OUT_POPUP_BUTTON_OK = findById("logoutConfirm");

    private final By LEFT_TOP_SEARCH = findByXPath("//*[@id='searchContacts']/input[@class='form-input-search without_M']");
    private final By SEARCH_FOR_FRIENDS_RED_BUTTON = findByXPath("//*[@class='btn-icon btn-icon_invite']");
    private final By FOUND_USER = findByXPath("//*[@class='l-flexbox_inline']/span[@data-id='23558117']");
    private final By SORRY_MESSAGE = findByXPath("//*[@id='searchList']/div[@class='note l-flexbox l-flexbox_column']/span[text()='Sorry...']");
    private final By GLOBAL_SEARCH_BLUE_BUTTON = findByXPath("//*[@class='search btn btn_search without_M']");
    private final By SEARCH_FIELD = findByXPath("//*[@id='globalSearch']/input[@class='form-input-search without_M']"); //is common
    private final By CLEAN_SEARCH_FIELD_BUTTON = findByXPath("//*[@id='globalSearch']/button[@class='clean-button j-clean-button']"); //is common

    private final By CONTACTS_BUTTON = findById("contacts");
    private final By SEARCH_FOR_FRIENDS_ON_CONTACTS_BUTTON = findByXPath("//*[@class='search btn btn_invite btn_invite_contacts btn_add']");

    private final By QB_FOOTER_BUTTON = findByXPath("//*[@alt='QuickBlox']");
    private final By QB_GET_STARTED = findByXPath(".//*[@class='btn extra large']");
    private final By QB_START_BUILDING = findByXPath(".//*[@id='signup-submit']");
    private final By IOS_APP_FOOTER_BUTTON = findByXPath("//*[@alt='download Q-municate iOS']");
    private final By ITUNES = findByXPath("//*[@class='lockup product application']//span[text()='View in iTunes']");
    private final By ANDROID_APP_FOOTER_BUTTON = findByXPath("//*[@alt='download Q-municate Android']");
    private final By PLAY_MARKET_QM = findByXPath("//*[@class='document-subtitle primary']");

    public void searchForFriendsRedButton() {
        click(SEARCH_FOR_FRIENDS_RED_BUTTON);
        new Actions(driver).moveToElement(driver.findElement(SEARCH_FIELD), 210, 15).click().perform();
        click(SEARCH_FIELD);
        clearAndType(SEARCH_FIELD, "Test User 2");
        click(CLEAN_SEARCH_FIELD_BUTTON);
        clearAndType(SEARCH_FIELD, "Test User 2");
        softAssert.assertEquals(getText(FOUND_USER),"Test User 2");
        softAssert.assertAll();
    }

    /**<p>
     * If no users appears on contact list then the global search should appears
     * </p>*/
    public void searchFieldOnPage() {
        waitUntilElementToBeClickable(LEFT_TOP_SEARCH);
        new Actions(driver).moveToElement(driver.findElement(LEFT_TOP_SEARCH), 149, 15).click().perform();
        type(LEFT_TOP_SEARCH, "Test User 2");
        if (driver.findElement(SORRY_MESSAGE).isDisplayed()) {
            click(GLOBAL_SEARCH_BLUE_BUTTON);
            waitUntilElementToBeClickable(FOUND_USER);
            new Actions(driver).moveToElement(driver.findElement(findByXPath("//*[@class='l-flexbox_inline']")), 210, 15).click().perform();
            softAssert.assertEquals(getText(FOUND_USER),"Test User 2");
        } else {
            //TODO logic for appeared contacts
        }
        softAssert.assertAll();
    }

    public void searchContactsButton() {
        click(CONTACTS_BUTTON);
        click(SEARCH_FOR_FRIENDS_ON_CONTACTS_BUTTON);
        type(SEARCH_FIELD, "test user");
        softAssert.assertEquals(getText(FOUND_USER), "Test User 2");
        softAssert.assertAll();
        click(CLEAN_SEARCH_FIELD_BUTTON);
        refreshPage();
    }

    public UserLoggedInPage openProfile() {
        new Actions(driver).moveToElement(driver.findElement(USER_ICON), 39, 35).click().perform();
        click(USER_ICON);
        click(USER_PROFILE);
        return this;
    }

    public void openSettingsPopup() {
        click(USER_ICON);
        click(USER_SETTINGS);
        new Actions(driver).moveToElement(driver.findElement(SETTINGS_HEADER), 232, 28).click().perform();
    }

    public void closeSettingsPopup() {
        click(CLOSE_SETTINGS_POPUP);
    }

    public void checkingQBButton() {
        click(QB_FOOTER_BUTTON);
        pause(1000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitUntilElementToBeClickable(QB_GET_STARTED);
        click(QB_GET_STARTED);
        waitUntilElementVisible(QB_START_BUILDING);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void checkingiOSButton() {
        click(IOS_APP_FOOTER_BUTTON);
        pause(1000);
        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        waitUntilElementToBeClickable(ITUNES);
        click(ITUNES);
        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }

    public void checkingAndroidButton() {
        click(ANDROID_APP_FOOTER_BUTTON);
        pause(1000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        waitUntilElementToBeClickable(PLAY_MARKET_QM);
        click(PLAY_MARKET_QM);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    public void logOutByEmail() {
        click(USER_ICON);
        click(LOG_OUT);
        new Actions(driver).moveToElement(driver.findElement(LOG_OUT_POPUP_BUTTON_OK)).click().perform();
        click(LOG_OUT_POPUP_BUTTON_OK);
    }

    public void logOutByFacebook() {
        refreshPage();
        new Actions(driver).moveToElement(driver.findElement(USER_ICON)).click().perform();
        click(USER_ICON);
        click(LOG_OUT);
        new Actions(driver).moveToElement(driver.findElement(LOG_OUT_POPUP_BUTTON_CANCEL), 39, 35).click().perform();
        click(LOG_OUT_POPUP_BUTTON_CANCEL);
        refreshPage();
        new Actions(driver).moveToElement(driver.findElement(USER_ICON)).click().perform();
        click(USER_ICON);
        click(LOG_OUT);
        new Actions(driver).moveToElement(driver.findElement(LOG_OUT_POPUP_BUTTON_OK)).click().perform();
        click(LOG_OUT_POPUP_BUTTON_OK);
    }
}
