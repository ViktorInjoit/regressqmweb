package com.quickblox.qmdev.initializations;

import org.openqa.selenium.By;

public abstract class TestDataAndSelectors extends Wrappers {


    protected final By REQUEST_SENT = findByXPath("//span[text()='Request Sent']");
    protected final By LAST_RECEIVED_MESSAGE = findByXPath("//*[@class='message l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/div[text()='Hello for test user!']");
    protected final By YOU_HAVE_BEEN_DELETED = findByXPath("//*[@class='message message_service l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/h4[text()='You have been deleted from the contact list']");

    protected final By SORRY_MESSAGE = findByXPath("//*[@id='searchList']/div[@class='note l-flexbox l-flexbox_column']/span[text()='Sorry...']");
    protected final By FOUND_USER = findByXPath("//*[@class='l-flexbox_inline']/span[@data-id='23558117']");

    protected final By CHANGE_PASSWORD_SUCCESS_MESSAGE = findByXPath("//*[@class='userProfile-success']");
    protected final By OLD_PASSWORD_IS_INCORRECT_MESSAGE = findByXPath("//*[@id='popupPassword']/div[text()='Old password is incorrect']");

    protected final By GLOBAL_SEARCH_BLUE_BUTTON = findByXPath("//*[@class='search btn btn_search without_M']");

    //test data
    protected final String testEmail1 = "user1@dmail.com";
    protected final String testEmail2 = "user2@dmail.com";
    protected final String testEmail3 = "user3@dmail.com";
    protected final String testEmail4 = "user4@dmail.com";
    protected final String testPass = "12345678";
    protected final String tempPass = "123456789";

}
