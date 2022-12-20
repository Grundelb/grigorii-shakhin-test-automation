package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class WebDriverSetup {
    protected WebDriver driver;

    @BeforeClass
    protected void setDriver() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        //set waits
        new WebDriverWait(driver, 10, 1000);
    }

    @AfterClass
    protected void teardown() {
        //Close Browser
        if (driver != null) {
            driver.quit();
        }
    }
}
