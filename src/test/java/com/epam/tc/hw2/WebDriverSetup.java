package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class WebDriverSetup {
    protected WebDriver driver;
    private final int timeOutWaits = 10;
    protected SoftAssertions softly;

    @BeforeClass
    protected void setDriver() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @AfterClass
    protected void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    protected void createSoftAssert() {
        softly = new SoftAssertions();
    }

    @AfterMethod
    protected void completeSoftAssert() {
        softly.assertAll();
        if (softly != null) {
            softly = null;
        }
    }

    protected WebElement waitForElementLocatedBy(WebDriver driver, By locator) {
        return new WebDriverWait(driver, timeOutWaits)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
