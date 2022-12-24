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
import org.testng.annotations.BeforeClass;

public abstract class WebDriverSetup {
    protected WebDriver driver;
    protected final int timeOutWaits = 10;
    protected SoftAssertions softly = new SoftAssertions();

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

    @AfterClass
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
