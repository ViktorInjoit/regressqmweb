package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.BasePage;
import com.quickblox.qmdev.pages.LogInWithPhone;
import com.quickblox.qmdev.pages.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class LinksCheckingsOnWelcome extends BasePage{

    private SoftAssert softAssert;

    private WelcomePage welcomePage;
    private LogInWithPhone logInWithPhone;

    public LinksCheckingsOnWelcome(WebDriver webDriver) {
        super(webDriver);
    }

    public LinksCheckingsOnWelcome() {
        super();
    }

    @BeforeTest
    public void initializingPagesAndVariables() {
        softAssert = new SoftAssert();

        welcomePage = new WelcomePage(getWebDriver());
        logInWithPhone = new LogInWithPhone(getWebDriver());
    }

    /**
     * Checking footer links, such as Quickblox, appstore and android
     * */
    @Test(enabled = false)
    public void checkingFooterLinks() {

        By QB_GET_STARTED = findByXpath(".//*[@class='btn extra large']");
        By QB_START_BUILDING = findByXpath(".//*[@id='signup-submit']");

        By ITUNES = findByXpath(".//*[@alt='Free Download']");
        By APPLE_DOWNLOAD_NOW = findByXpath(".//*[@class='button_add']");

        welcomePage.clickTheQBButton();
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        waitUntilElementVisible(QB_GET_STARTED);
        waitUntilElementToBeClickable(QB_GET_STARTED);
        click(QB_GET_STARTED);
        waitUntilElementVisible(QB_START_BUILDING);
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs.get(0));

        welcomePage.clickTheiOSButton();
        ArrayList<String> tabs1 = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs1.get(1));
        waitUntilElementVisible(ITUNES);
        waitUntilElementToBeClickable(ITUNES);
        click(ITUNES);
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs1.get(0));

        welcomePage.clickTheAndroidButton();
        ArrayList<String> tabs2 = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs2.get(1));
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs2.get(0));
    }

    @Test(enabled = true)
    public void verifyingPhoneNumberForm() {
            welcomePage.pressLogInWithPhoneNumber();
            ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
            getWebDriver().switchTo().window(tabs.get(1));
            getWebDriver().switchTo().frame(getWebDriver().findElement(findByCss(".digits-embed")));
            click(findByXpath("//button[@type='submit']"));
            pause(5000);
        }

}
