package com.quickblox.qmdev.utils;

import com.quickblox.qmdev.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener implements ITestListener{

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test has been passed!!!");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test has failed!");
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getWebDriver();
        File output = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dstFile = new File(System.getProperty("user.dir")+"/reports", "screenshot"+Math.random()+".jpg");
        dstFile.getParentFile().mkdirs();
        try {
            Files.copy(output.toPath(), dstFile.toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
