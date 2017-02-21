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
    private final By USER_ON_LEFT_SIDE_TEST_USER_3 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 3']");
    private final By USER_ON_LEFT_SIDE_TEST_USER_4 = findByXPath("//*[@class='dialog_body']/span[text()='Test User 4']");

    private final By CREATE_NEW_GROUP_CHAT_WITH_CURRENT_USER = findByXPath("//*[@alt='Create a new group chat']");
    private final By SELECT_ONE_MORE_USER_FOR_CHAT = findByXPath("//*[@class='form-checkbox']");
    private final By CREATE_PRIVATE_CHAT = findByXPath("//*[@class='btn btn_popup btn_popup_group']");
    private final By PUBLIC_CHAT = findByXPath("//*[@class='contact l-flexbox']/div/div/span[text()='Test User 2, Test User 3, Test User 4']");
    private final By DELETE_CHAT = findByXPath("//*[@alt='Remove chat']");

    private final By SEND_REQUEST_TO_ADD_USER = findByXPath("//*[@class='send-request j-sendRequest']"); //is common

    private final By REJECT_REQUEST_BUTTON = findByXPath("//*[@class='request-button request-button_cancel j-requestCancel']");
    private final By SEND_REQUEST_AGAIN_BUTTON_CHAT_SENDER = findByXPath("//*[@class='message message_service l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/button[@class='btn btn_request_again j-requestAgain']");
    private final By ACCEPT_REQUEST_BUTTON = findByXPath("//*[@class='request-button request-button_ok j-requestConfirm']");
    //    private final By CHAT_FIELD = findByClass("l-message j-message"); //is common
    private final By CHAT_FIELD = findByCss(".textarea"); //is common

    private final By SEND_MESSAGE_BUTTON = findByXPath("//*[@data-balloon='Send message']"); //is common
    //    private final By LAST_RECEIVED_MESSAGE_WITHOUT_BORDER = findByXPath("//*[@class='message l-flexbox l-flexbox_alignstretch without_border'][last()-1]");

    private final By CONTEXT_MENU_DELETE_USER = findByXPath("//*[@class='deleteContact list-actions-action']");

    private final By OK_POPUP_BUTTON = findById("deleteContactConfirm");
    private final By SEND_REQUEST_AGAIN_BUTTON_CHAT_RECEIVER = findByXPath("//*[@class='message message_service l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/button[@class='btn btn_request_again btn_request_again_delete j-requestAgain']");



    /**
     * Requests and collaborating
     */
    public void sendAddRequestToUser() {
        click(SEND_REQUEST_TO_ADD_USER);
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
        waitUntilElementToBeClickable(USER_ON_LEFT_SIDE);
    }

    public void typeInChat() {
        click(USER_ON_LEFT_SIDE);
        type(CHAT_FIELD, "Hello for test user!");
        pause(3000);
        new Actions(driver).moveToElement(driver.findElement(SEND_MESSAGE_BUTTON)).click().perform();
        click(SEND_MESSAGE_BUTTON);
        pause(5000);
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
        click(OK_POPUP_BUTTON);
        pause(1500);
    }

    public void verifyingDeletedUser() {
        click(USER_ON_LEFT_SIDE);
    }

    /**
     * <p>
     * Public chats collaborating
     * </p>
     */
    public void searchForUsers3And4AndSendRequestsToThem() {

    }

    public void sendRequestToUser() {
        click(SEND_REQUEST_TO_ADD_USER);
        pause(1000);
    }

    public void user3AcceptsRequest() {
        click(ACCEPT_REQUEST_BUTTON);
        pause(2000);
    }

    public void user4Acceptsrequest() {
        click(ACCEPT_REQUEST_BUTTON);
        pause(2000);
    }

    public void user2CreatesChatWithUser3And4() {
        click(USER_ON_LEFT_SIDE_TEST_USER_3);
        new Actions(driver).moveToElement(driver.findElement(CREATE_NEW_GROUP_CHAT_WITH_CURRENT_USER)).click().perform();
        click(CREATE_NEW_GROUP_CHAT_WITH_CURRENT_USER);
        click(SELECT_ONE_MORE_USER_FOR_CHAT);
        click(CREATE_PRIVATE_CHAT);
        pause(4000);
    }

    public void user2TypesInChat() {
        click(PUBLIC_CHAT);
        type(CHAT_FIELD, "Hey everybody!");
        click(SEND_MESSAGE_BUTTON);
    }

    public void user3TypesInChat() {
        type(CHAT_FIELD, "Hello!");
        click(SEND_MESSAGE_BUTTON);
    }

    public void user4TypesInChatAndDeletesChat() {
        type(CHAT_FIELD, "I am fourth user");
        click(SEND_MESSAGE_BUTTON);
    }

    public void user2DeletesChatAndContacts() {
        click(PUBLIC_CHAT);
        click(DELETE_CHAT);
        new Actions(driver).moveToElement(driver.findElement(USER_ON_LEFT_SIDE_TEST_USER_3)).contextClick().perform();
        click(CONTEXT_MENU_DELETE_USER);
        click(OK_POPUP_BUTTON);
    }

    public void user3DeletesChat() {

    }

    public void user4DeletesChat() {

    }
}
