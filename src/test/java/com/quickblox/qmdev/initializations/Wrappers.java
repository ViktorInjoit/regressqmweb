package com.quickblox.qmdev.initializations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Wrappers {

    public final By REQUEST_SENT = findByXPath("//span[text()='Request Sent']");
    public final By LAST_RECEIVED_MESSAGE = findByXPath("//*[@class='message l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/div[text()='Hello for test user!']");
    public final By YOU_HAVE_BEEN_DELETED = findByXPath("//*[@class='message message_service l-flexbox l-flexbox_alignstretch'][last()]/div/div/div/h4[text()='You have been deleted from the contact list']");

    public final By SORRY_MESSAGE = findByXPath("//*[@id='searchList']/div[@class='note l-flexbox l-flexbox_column']/span[text()='Sorry...']");
    public final By FOUND_USER = findByXPath("//*[@class='l-flexbox_inline']/span[@data-id='23558117']");

    public final By CHANGE_PASSWORD_SUCCESS_MESSAGE = findByXPath("//*[@class='userProfile-success']");
    public final By OLD_PASSWORD_IS_INCORRECT_MESSAGE = findByXPath("//*[@id='popupPassword']/div[text()='Old password is incorrect']");

    public final By GLOBAL_SEARCH_BLUE_BUTTON = findByXPath("//*[@class='search btn btn_search without_M']");

    public abstract WebDriver getWebDriver();
    public abstract WebDriverWait getWebDriverWait();


    public By findByCss(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public By findById(String id) {
        return By.id(id);
    }

    public By findByXPath(String xpath) {
        return By.xpath(xpath);
    }

    public By findByClass(String className) {
        return By.className(className);
    }

    public void waitUntilElementToBeClickable(By locator) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementLocated(By locator) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementNotPresented(By locator) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public int getCountOfCssElements(String locator) {
        return getWebDriver().findElements(By.cssSelector(locator)).size();
    }

    public int getCountOfElements(By locator) {
        return getWebDriver().findElements(locator).size();
    }

    public void type(By field, String value) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(field)).sendKeys(value);
    }

    public void clearAndType(By field, String value) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(field)).clear();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(field)).sendKeys(value);
    }

    public void click(By element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void acceptAlert() {
        getWebDriverWait().until(ExpectedConditions.alertIsPresent());
        Alert alert = getWebDriver().switchTo().alert();
        alert.accept();
    }

    public Boolean isChecked(By locator) {
        return getWebDriver().findElement(locator).isSelected();
    }

    protected void interactWithCheckbox(By locator, Boolean condition) {
        WebElement checkbox = getWebDriver().findElement(locator);
        if (condition) {
            if (!isChecked(locator))
                getWebDriver().findElement(locator).click();
        } else {
            if (isChecked(locator))
                getWebDriver().findElement(locator).click();
        }
    }

    protected void selectByValue(By locator, String value) {
        Select select = new Select(getWebDriver().findElement(locator));
        select.selectByValue(value);
    }

    protected void selectByText(By locator, String text) {
        Select select = new Select(getWebDriver().findElement(locator));
        select.selectByVisibleText(text);
    }

    protected String getText(By element) {
        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    protected double getWidthAttribute(By element) {
        return Double.parseDouble(getWebDriver().findElement(element).getAttribute("width"));
    }

    protected double getWidth(By element) {
        return Double.parseDouble(getWebDriver().findElement(element).getAttribute("clientWidth"));
    }

    protected String getValue(By element) {
        return getWebDriver().findElement(element).getAttribute("value");
    }

    protected void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private Boolean isElementExists(By element) {
        return (getWebDriver().findElements(element).size() != 0);
    }

    protected Boolean isElementPresented(By element) {
        Boolean elementCondition = false;
        try {
            waitUntilElementLocated(element);
        } catch (Exception e) {
            return false;
        }

        if (isElementExists(element))
            elementCondition = getWebDriver().findElement(element).isDisplayed();

        return elementCondition;
    }

    protected void open(String url) {
        getWebDriver().get(url);
    }

    protected void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    protected void goBack() {
        getWebDriver().navigate().back();
    }


}
