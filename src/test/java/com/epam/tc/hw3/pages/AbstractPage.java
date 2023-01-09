package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final int waitTimeoutSeconds = 10;

    protected abstract void openPage(
    );

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElementLocatedBy(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, waitTimeoutSeconds)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
