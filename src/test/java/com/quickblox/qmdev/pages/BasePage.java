package com.quickblox.qmdev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.quickblox.qmdev.tests.BaseTest.currentDomain;

public abstract class BasePage{

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(this.webDriver, 15);
        this.webDriver.get(currentDomain);
    }

    public BasePage() {

    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public By findById(String id) {
        return By.id(id);
    }

    public By findByCss(String css) {
        return By.cssSelector(css);
    }

    public By findByXpath(String xpath) {
        return By.xpath(xpath);
    }

    public void waitUntilElementToBeClickable(By locator) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementNotPresented(By locator) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilElementVisible(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void type(By field, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(field)).sendKeys(value);
    }

    public void clearAndType(By field, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(field)).clear();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(field)).sendKeys(value);
    }

    public void click(By element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean isElementExists(By element) {
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element)).size() != 0;
//        return getWebDriver().findElements(element).size() != 0;
    }

    public boolean isElementPresented(By element) {
        boolean elementCondition = false;
        waitUntilElementToBeClickable(element);
        if (isElementExists(element)) {
            elementCondition = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
        }
        return elementCondition;
    }

    public void goBack() {
        getWebDriver().navigate().back();
    }

    public void refresh() {
        getWebDriver().navigate().refresh();
    }
}
