package com.quickblox.qmdev.pages.userprofile;

import com.quickblox.qmdev.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserChats extends BasePage {

    public UserChats(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By USER_ON_LEFT_SIDE = findByXPath("//*[@class='contact l-flexbox']"); //is common
    private final By USER_ON_LEFT_SIDE_TEST_USER_2 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 2']");
    private final By USER_ON_LEFT_SIDE_TEST_USER_3 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 3']");
    private final By USER_ON_LEFT_SIDE_TEST_USER_4 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 4']");

    private final By CREATE_NEW_GROUP_CHAT_WITH_CURRENT_USER = findByXPath("//*[@alt='Create a new group chat']");
    private final By SELECT_ONE_MORE_USER_FOR_CHAT = findByClass("form-checkbox");
    private final By CREATE_GROUP_CHAT_BUTTON = findByXPath("//*[@class='btn btn_popup btn_popup_group']");
    private final By PUBLIC_CHAT = findByXPath("//*[@class='contact l-flexbox']/div/div/span[text()='Test User 2, Test User 3, Test User 4']");
    private final By DELETE_CHAT_BUTTON = findByXPath("//*[@alt='Leave and remove chat']");
    private final By DELETE_CHAT_CONFIRM_BUTTON = findByCss(".j-deleteChatConfirm");

    private final By SEND_REQUEST_TO_ADD_USER = findByXPath("//*[@class='send-request j-sendRequest']"); //is common

    private final By REJECT_REQUEST_BUTTON = findByXPath("//*[@class='request-button request-button_cancel j-requestCancel']");
    private final By SEND_REQUEST_AGAIN_BUTTON_CHAT_SENDER = findByXPath("//*[@class='message message_service l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/button[@class='btn btn_request_again j-requestAgain']");
    private final By ACCEPT_REQUEST_BUTTON = findByXPath("//*[@class='request-button request-button_ok j-requestConfirm']");
    private final By CHAT_FIELD = findByCss(".textarea"); //is common

    private final By SEND_MESSAGE_BUTTON = findByXPath("//*[@data-balloon='Send message']"); //is common
    //    private final By LAST_RECEIVED_MESSAGE_WITHOUT_BORDER = findByXPath("//*[@class='message l-flexbox l-flexbox_alignstretch without_border'][last()-1]");

    private final By CONTEXT_MENU_DELETE_USER = findByXPath("//*[@class='deleteContact list-actions-action']");

//    private final By OK_POPUP_BUTTON_USER = findById("deleteContactConfirm");
    private final By OK_POPUP_BUTTON_USER = findByCss(".j-deleteContactConfirm");
    private final By SEND_REQUEST_AGAIN_BUTTON_CHAT_RECEIVER = findByXPath("//*[@class='message message_service l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/button[@class='btn btn_request_again btn_request_again_delete j-requestAgain']");


    private final By FOUND_CONTACTS = findByXPath("//*[@class='contact l-flexbox']");

    /**
     * Requests and collaborating
     */
    public void sendAddRequestToUser() {
        pause(1500);
        click(SEND_REQUEST_TO_ADD_USER);
        pause(1500);
    }

    public void rejectRequestToAddUser() {
        click(REJECT_REQUEST_BUTTON);
    }

    public void sendRequestAgain() {
        click(USER_ON_LEFT_SIDE);
        click(SEND_REQUEST_AGAIN_BUTTON_CHAT_SENDER);
        pause(1500);
    }

    public void acceptRequest() {
        click(ACCEPT_REQUEST_BUTTON);
        pause(3000);
    }

    public void typeInPrivateChat() {
        click(USER_ON_LEFT_SIDE);
        type(CHAT_FIELD, "Hello for test user!");
        new Actions(driver).moveToElement(driver.findElement(SEND_MESSAGE_BUTTON)).click().perform();
        click(SEND_MESSAGE_BUTTON);
        pause(3500);
    }

    public void messageVerify() {
        click(USER_ON_LEFT_SIDE);
        //verifying in test
    }

    public void deleteUserFromContacts() {
        click(USER_ON_LEFT_SIDE);
        pause(1000);
        new Actions(driver).moveToElement(driver.findElement(USER_ON_LEFT_SIDE)).contextClick().perform();
        pause(1000);
        click(CONTEXT_MENU_DELETE_USER);
        pause(1000);
        click(OK_POPUP_BUTTON_USER);
        pause(1500);
    }

    public void verifyingDeletedUser() {
        click(USER_ON_LEFT_SIDE);
        //verifying in test
    }

    /**
     * <p>
     * Public chats collaborating
     * </p>
     */

    public void user2CreatesChatWithUser3And4() {
        click(USER_ON_LEFT_SIDE_TEST_USER_3);
        new Actions(driver).moveToElement(driver.findElement(CREATE_NEW_GROUP_CHAT_WITH_CURRENT_USER)).click().perform();
        click(CREATE_NEW_GROUP_CHAT_WITH_CURRENT_USER);
        new Actions(driver).moveToElement(driver.findElement(SELECT_ONE_MORE_USER_FOR_CHAT)).click().perform();
        click(SELECT_ONE_MORE_USER_FOR_CHAT);
        click(CREATE_GROUP_CHAT_BUTTON);
        pause(3000);
    }

    public void typeInPublicChat(String message) {
        click(PUBLIC_CHAT);
        type(CHAT_FIELD, message);
        new Actions(driver).moveToElement(driver.findElement(SEND_MESSAGE_BUTTON)).click().perform();
        click(SEND_MESSAGE_BUTTON);
        pause(2000);
    }

    public void deleteChat() {
        click(PUBLIC_CHAT);
        click(DELETE_CHAT_BUTTON);
        pause(1000);
        new Actions(driver).moveToElement(driver.findElement(DELETE_CHAT_CONFIRM_BUTTON));
        click(DELETE_CHAT_CONFIRM_BUTTON);
        pause(2000);
    }

    public void deleteContacts() {
        int numberOfContacts = getCountOfElements(FOUND_CONTACTS);
        Object [] foundUsers = new Object[numberOfContacts];
    }

    public void removeUser2FromFriendList() {
        click(USER_ON_LEFT_SIDE_TEST_USER_2);
        new Actions(driver).moveToElement(driver.findElement(USER_ON_LEFT_SIDE_TEST_USER_2)).contextClick().perform();
        click(CONTEXT_MENU_DELETE_USER);
        new Actions(driver).moveToElement(driver.findElement(OK_POPUP_BUTTON_USER));
        click(OK_POPUP_BUTTON_USER);
    }

    public void removeUser3FromFriendList() {
        click(USER_ON_LEFT_SIDE_TEST_USER_3);
        new Actions(driver).moveToElement(driver.findElement(USER_ON_LEFT_SIDE_TEST_USER_3)).contextClick().perform();
        click(CONTEXT_MENU_DELETE_USER);
        new Actions(driver).moveToElement(driver.findElement(OK_POPUP_BUTTON_USER));
        click(OK_POPUP_BUTTON_USER);
    }

    public void removeUser4FromFriendList() {
        click(USER_ON_LEFT_SIDE_TEST_USER_4);
        new Actions(driver).moveToElement(driver.findElement(USER_ON_LEFT_SIDE_TEST_USER_4)).contextClick().perform();
        click(CONTEXT_MENU_DELETE_USER);
        new Actions(driver).moveToElement(driver.findElement(OK_POPUP_BUTTON_USER));
        click(OK_POPUP_BUTTON_USER);
    }
}
