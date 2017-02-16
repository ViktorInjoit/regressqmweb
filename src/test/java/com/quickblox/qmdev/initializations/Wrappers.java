package com.quickblox.qmdev.initializations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Wrappers {

    public abstract WebDriver getWebDriver();
    public abstract WebDriverWait getWebDriverWait();


    public By findByCss(String cssSelector){
        return By.cssSelector(cssSelector);
    }

    public By findById(String id){
        return By.id(id);
    }

    public By findByXPath(String xpath){
        return By.xpath(xpath);
    }

    public void waitUntilElementToBeClickable(By locator) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementLocated(By locator){
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementNotPresented(By locator){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilElementVisible(By locator){
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public int getCountOfCssElements(String locator){
        return getWebDriver().findElements(By.cssSelector(locator)).size();
    }

    public int getCountOfElements(By locator){
        return getWebDriver().findElements(locator).size();
    }

    public void type(By field, String value){
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(field)).sendKeys(value);
    }

    public void clearAndType(By field, String value){
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(field)).clear();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(field)).sendKeys(value);
    }

    public void click(By element){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void acceptAlert(){
        getWebDriverWait().until(ExpectedConditions.alertIsPresent());
        Alert alert = getWebDriver().switchTo().alert();
        alert.accept();
    }

    public Boolean isChecked(By locator){
        return getWebDriver().findElement(locator).isSelected();
    }

    protected void interactWithCheckbox(By locator, Boolean condition){
        WebElement checkbox = getWebDriver().findElement(locator);
        if(condition) {
            if (!isChecked(locator))
                getWebDriver().findElement(locator).click();
        }
        else{
            if (isChecked(locator))
                getWebDriver().findElement(locator).click();
        }
    }

    protected void selectByValue(By locator, String value){
        Select select = new Select(getWebDriver().findElement(locator));
        select.selectByValue(value);
    }

    protected void selectByText(By locator, String text){
        Select select = new Select(getWebDriver().findElement(locator));
        select.selectByVisibleText(text);
    }

    protected String getText(By element){
        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    protected double getWidthAttribute(By element){
        return Double.parseDouble(getWebDriver().findElement(element).getAttribute("width"));
    }

    protected double getWidth(By element){
        return Double.parseDouble(getWebDriver().findElement(element).getAttribute("clientWidth"));
    }

    protected String getValue(By element){
        return getWebDriver().findElement(element).getAttribute("value");
    }

    protected void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private Boolean isElementExists(By element){
        return (getWebDriver().findElements(element).size() != 0);
    }

    protected Boolean isElementPresented(By element){
        Boolean elementCondition = false;
        try{
            waitUntilElementLocated(element);
        }
        catch (Exception e){
            return false;
        }

        if(isElementExists(element))
            elementCondition = getWebDriver().findElement(element).isDisplayed();

        return  elementCondition;
    }

    protected void open(String url){
        getWebDriver().get(url);
    }
    protected void refreshPage(){
        getWebDriver().navigate().refresh();
    }
    protected void goBack(){
        getWebDriver().navigate().back();
    }
}
