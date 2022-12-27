package com.epam.tc.hw3.test;

import com.epam.tc.hw3.page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsMainPage {

    private WebDriver driver;
    SoftAssertions softly = new SoftAssertions();

    @Test
    public void verifyBrowserTitle() {
                .openPage()
        String actualTitle = .getTitle();
        softly.assertThat(actualTitle).contains("Home Page");
    }

    @Test(priority = 2, description = "Assert Username is loggined")
    public void verifyUserCredentionalsView() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login("login", "password");
        String actualUserName = mainPage.verifyUserName();

        softly.assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");
    }

    @Test(priority = 3, description = "Assert that there are 4 items on the header section are displayed"
            + " and they have proper texts")
    public void verifyHeaderMenuElements() {
        MainPage mainPage = new MainPage(driver);
        mainPage.contactFormHeaderMenu
        softly.assertThat(mainPage.contactFormHeaderMenu

                softly.assertThat(driver.findElement(contactFormHeaderMenu)
                        .isDisplayed());
        softly.assertThat(driver.findElement(serviceHeaderMenu)
                .isDisplayed());
        softly.assertThat(driver.findElement(metalsAndColorsHeaderMenu)
                .isDisplayed());
    }

    @Test(priority = 3, description = "Assert that there are 4 images on the Index Page and they are displayed")
    public void verifyImages() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript(scrollToTheFooter);

        softly.assertThat(driver.findElement(iconPractise)
                .isDisplayed());
        softly.assertThat(driver.findElement(iconCustom)
                .isDisplayed());
        softly.assertThat(driver.findElement(iconMulti)
                .isDisplayed());
        softly.assertThat(driver.findElement(iconBase)
                .isDisplayed());
    }

    @Test(priority = 3, description = "Assert that there are 4 texts "
            + "on the Index Page under icons and they have proper text")
    public void verifyTexts() {
        String actualTextPractise = driver.findElement(textPractise).getText();

        softly.assertThat(actualTextPractise).isEqualTo("To include good practices"
                + "\nand ideas from successful\nEPAM project");
        softly.assertThat(driver.findElement(iconPractise).isDisplayed());

        String actualTextCustom = driver.findElement(textCustom).getText();

        softly.assertThat(actualTextCustom).isEqualTo("To be flexible and"
                + "\ncustomizable");
        softly.assertThat(driver.findElement(textCustom)
                .isDisplayed());

        String actualTextMulti = driver.findElement(textMulti).getText();

        softly.assertThat(actualTextMulti).isEqualTo("To be multiplatform");
        softly.assertThat(driver.findElement(textMulti)
                .isDisplayed());

        String actualTextBase = driver.findElement(textBase).getText();

        softly.assertThat(actualTextBase).isEqualTo("Already have good base\n(about 20 internal and\n"
                + "some external projects),\nwish to get more…");
        softly.assertThat(driver.findElement(textBase)
                .isDisplayed());
    }

    @Test(priority = 4, description = "Assert that there is the iframe with “Frame Button” exist "
            + "and check that there is “Frame Button” in the iframe")
    public void verifyFrame() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollToTheHeader);

        softly.assertThat(driver.findElement(frame).isDisplayed());

        driver.switchTo().frame(frameLocator);

        softly.assertThat(driver.findElement(frameButton).isDisplayed());

        driver.switchTo().defaultContent();
    }

    @Test(priority = 4, description = "Assert that there are 5 items "
            + "in the Left Section are displayed and they have proper text")
    public void verifyLeftMenuElements() {
        softly.assertThat(driver.findElement(homeLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(contactFormLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(serviceLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(metalAndColorsLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(elementsPacksLeftMenu).isDisplayed());
    }

    @BeforeMethod
    protected void initializePage(){
        MainPage mainPage = new MainPage(driver);
    }

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

}