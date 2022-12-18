package com.epam.tc.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExercise2 {

    static WebDriver driver;

    @BeforeMethod
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new WebDriverWait(driver, 10, 1000);
    }

    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkExercice() {
        SoftAssertions softly = new SoftAssertions();

        //Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //Assert Browser title
        softly.assertThat(driver.getTitle()).contains("Home Page");

        //Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //Assert Username is loggined
        softly.assertThat(driver.findElement(By.id("user-name")).getText())
                .isEqualTo("ROMAN IOVLEV");

        //Open through the header menu Service -> Different Elements Page

    }
}
