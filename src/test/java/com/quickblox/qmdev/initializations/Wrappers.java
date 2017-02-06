package com.quickblox.qmdev.initializations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Wrappers {

    public abstract WebDriver getWebDriver();
//    public abstract WebDriverWait getWebDriverWait();

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
        new WebDriverWait(getWebDriver(), 60).until(ExpectedConditions.elementToBeClickable(locator));
//        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementNotPresented(By locator) {
        new WebDriverWait(getWebDriver(), 60).until(ExpectedConditions.invisibilityOfElementLocated(locator));
//        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilElementVisible(By locator) {
        new WebDriverWait(getWebDriver(), 60).until(ExpectedConditions.visibilityOfElementLocated(locator));
//        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void type(By field, String value) {
        getWebDriver().findElement(field).sendKeys(value);
    }

    public void clearAndType(By field, String value) {
        getWebDriver().findElement(field).clear();
        getWebDriver().findElement(field).sendKeys(value);
    }

    public void click(By element) {
//        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).click();
        new WebDriverWait(getWebDriver(), 60).until(ExpectedConditions.elementToBeClickable(element)).click();
//        getWebDriver().findElement(element).click();
//        pause(200);
    }

    public void acceptAlert(){
        Alert alert = getWebDriver().switchTo().alert();
        alert.accept();
    }

//    private void pause(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }

    private boolean isElementExists(By element) {
        return getWebDriver().findElements(element).size() != 0;
    }

    public boolean isElementPresented(By element) {
        boolean elementCondition = false;
        waitUntilElementToBeClickable(element);
        if (isElementExists(element)) {
            elementCondition = getWebDriver().findElement(element).isDisplayed();
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
