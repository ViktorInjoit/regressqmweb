package com.quickblox.qmdev.tests;

import com.quickblox.qmdev.pages.LogInWithPhone;
import com.quickblox.qmdev.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class LinksCheckingsOnWelcome extends BaseTest{

    private SoftAssert softAssert;

    private WelcomePage welcomePage;
    private LogInWithPhone logInWithPhone;

    @BeforeTest
    public void initializingPagesAndVariables() {
        softAssert = new SoftAssert();

        welcomePage = new WelcomePage(getWebDriver());
//        welcomePage = new WelcomePage(getWebDriverWait());

        logInWithPhone = new LogInWithPhone(getWebDriver());
//        logInWithPhone = new LogInWithPhone(getWebDriverWait());
    }

    /**
     * Checking footer links, such as Quickblox, appstore and android
     * */
    @Test(enabled = true, timeOut = 1000, dataProvider = "newProvider", threadPoolSize = 2)
    public void checkingFooterLinks() {

        By QB_GET_STARTED = findByXpath(".//*[@class='btn extra large']");
        By QB_START_BUILDING = findByXpath(".//*[@id='signup-submit']");

        By ITUNES = findByXpath(".//*[@alt='Free Download']");
        By APPLE_DOWNLOAD_NOW = findByXpath(".//*[@class='button_add']");

        By PLAY_MARKET_DOWNLOAD = findByXpath(".//*[@class='price buy id-track-click id-track-impression']/span[contains(text(),'Установить')]");

        welcomePage.clickTheQBButton();
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
//        waitUntilElementVisible(QB_GET_STARTED);
        waitUntilElementToBeClickable(QB_GET_STARTED);
        click(QB_GET_STARTED);
        waitUntilElementVisible(QB_START_BUILDING);
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs.get(0));

        welcomePage.clickTheiOSButton();
        ArrayList<String> tabs1 = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs1.get(1));
//        waitUntilElementVisible(ITUNES);
        waitUntilElementToBeClickable(ITUNES);
//        click(ITUNES);
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs1.get(0));

        welcomePage.clickTheAndroidButton();
        ArrayList<String> tabs2 = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs2.get(1));
//        waitUntilElementVisible(ANDROID_BUTTON);
        waitUntilElementToBeClickable(PLAY_MARKET_DOWNLOAD);
        click(PLAY_MARKET_DOWNLOAD);
        getWebDriver().close();
        getWebDriver().switchTo().window(tabs2.get(0));
    }

    @Test (enabled = false)
    public void verifyingPhoneNumberForm() {


//        String parentHandle = getWebDriver().getWindowHandle();
        welcomePage.pressLogInWithPhoneNumber();
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
//        for (String winHandle : getWebDriver().getWindowHandles()) {
//            getWebDriver().switchTo().window(winHandle);

//            getWebDriverWait().until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON)).click();
//            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(APPEARED_ERROR));
//            waitUntilElementVisible(SUBMIT_BUTTON);
//            welcomePage.type(APPEARED_PHONE_INPUT_FORM, "11111");

//        }
        logInWithPhone.inputPhoneNumberAndGetError();

        getWebDriver().close();
        getWebDriver().switchTo().window(tabs.get(0));

        softAssert.assertAll();
    }
}
