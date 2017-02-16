package com.quickblox.qmdev.pages.userprofile;

import com.quickblox.qmdev.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Settings extends BasePage {

    public Settings(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By WRITE_FEEDBACK = findByXPath("//*[@class='footer_settings_link']/span[text()='Write Feedback']");
    private final By ABOUT_BUTTON = findByXPath("//*[@class='footer_settings_link']/span[text()='About']");

    private final By GITHUB_SIGN_IN = findByXPath("//*[@value='Sign in']");
    private final By GET_THE_SOURCE = findByXPath("//*[@class='button']");

    public void clickWriteFeedback() {
        click(WRITE_FEEDBACK);
        pause(1000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitUntilElementToBeClickable(GITHUB_SIGN_IN);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void clickAbout() {
        click(ABOUT_BUTTON);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitUntilElementToBeClickable(GET_THE_SOURCE);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

}
