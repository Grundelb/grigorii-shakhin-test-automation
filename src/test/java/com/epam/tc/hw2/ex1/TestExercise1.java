package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestExercise1 {
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

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        softly.assertThat(driver.findElement(By.partialLinkText("HOME")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("CONTACT FORM")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("SERVICE")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("METALS & COLORS")).isDisplayed());

        //Assert that there are 4 images on the Index Page and they are displayed
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        softly.assertThat(driver.findElement(By.cssSelector(".icons-benefit.icon-practise"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector(".icons-benefit.icon-custom"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector(".icons-benefit.icon-multi"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector(".icons-benefit.icon-base"))
                .isDisplayed());

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .getText()).isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']" +
                "/parent::div/following-sibling::span[@class = 'benefit-txt']")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .getText()).isEqualTo("To be flexible and\ncustomizable");
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .getText()).isEqualTo("To be multiplatform");
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-base']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .getText()).isEqualTo("Already have good base\n(about 20 internal and\n" +
                "some external projects),\nwish to get more…");
        softly.assertThat(driver.findElement(By.xpath("//span[@class='icons-benefit icon-base']" +
                        "/parent::div/following-sibling::span[@class = 'benefit-txt']"))
                .isDisplayed());

        //Assert that there is the iframe with “Frame Button” exist
        jse.executeScript("window.scrollBy(0,-500)");
        softly.assertThat(driver.findElement(By.id("frame")).isDisplayed());

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softly.assertThat(driver.findElement(By.id("frame-button")).isDisplayed());

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        softly.assertThat(driver.findElement(By.partialLinkText("Home")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("Contact form")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("Service")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("Metals & Colors")).isDisplayed());
        softly.assertThat(driver.findElement(By.partialLinkText("Elements packs")).isDisplayed());

        softly.assertAll();
    }
}

