package tests.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestListener implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) {
        System.out.printf("Test started: %s \n",result.getName());
    }
    public void onTestSuccess(org.testng.ITestResult result) {
        System.out.printf("Test success: %s \n",result.getName());
    }
    public void onTestFailure(org.testng.ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
        System.out.printf("Test failure: %s \n", result.getName());
    }
    public void onTestSkipped(org.testng.ITestResult result) {
        System.out.printf("Test skipped: %s \n", result.getName());
    }
    public void onStart(ITestContext iTestContext) {
    }
    public void onFinish(ITestContext iTestContext) {
    }

}

