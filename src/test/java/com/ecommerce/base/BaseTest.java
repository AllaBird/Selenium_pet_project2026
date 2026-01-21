package com.ecommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;

    private WebDriverWait wait2;
    private WebDriverWait wait5;

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait2() {
        if (wait2 == null) {
            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        }

        return wait2;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();

        driver.get("https://askomdch.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();

        wait2 = null;
        wait5 = null;
    }
}
