package com.quickblox.qmdev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInWithPhone extends WelcomePage {

    final By SUBMIT_BUTTON = findByXpath(".//*[@type='submit']");
    final By APPEARED_ERROR = findByXpath(".//*[@class='input-error'][contains(text(),'Неверный номер телефонa')]");

    public LogInWithPhone(WebDriver driver) {
        super(driver);
    }


    public void inputPhoneNumberAndGetError() {
        click(SUBMIT_BUTTON);
        waitUntilElementVisible(APPEARED_ERROR);
//        softAssert.assertTrue(welcomePage.getErrorMessage().equalsIgnoreCase("Неверный номер телефонa"));
    }
}
