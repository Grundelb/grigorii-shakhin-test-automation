package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.WebDriverSetup;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TestExercise1 extends WebDriverSetup {
    private final String openMainPage = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String dropdownUserIconLocator = "user-icon";
    private final By dropdownUserIcon = By.id(dropdownUserIconLocator);
    private final String fieldUserNameLocator = "name";
    private final By fieldUserName = By.id(fieldUserNameLocator);
    private final String credentionalsUserName = "Roman";
    private final String credentionalsUserPassword = "Jdi1234";
    private final String fieldUserPasswordLocator = "password";
    private final By fieldUserPassword = By.id(fieldUserPasswordLocator);
    private final String loginButtonLocator = "login-button";
    private final By loginButton = By.id(loginButtonLocator);
    private final String userNameHeaderViewLocator = "user-name";
    private final By userNameHeaderView = By.id(userNameHeaderViewLocator);
    private final By homeHeaderMenu = By.partialLinkText("HOME");
    private final By contactFormHeaderMenu = By.partialLinkText("CONTACT FORM");
    private final By serviceHeaderMenu = By.partialLinkText("SERVICE");
    private final By metalsAndColorsHeaderMenu = By.partialLinkText("METALS & COLORS");
    private final String scrollToTheFooter = "window.scrollBy(0,500)";
    private final String iconPractiseLocator = ".icons-benefit.icon-practise";
    private final By iconPractise = By.cssSelector(iconPractiseLocator);
    private final String iconCustomLocator = ".icons-benefit.icon-custom";
    private final By iconCustom = By.cssSelector(iconCustomLocator);
    private final String iconMultiLocator = ".icons-benefit.icon-multi";
    private final By iconMulti = By.cssSelector(iconMultiLocator);
    private final String iconBaseLocator = ".icons-benefit.icon-base";
    private final By iconBase = By.cssSelector(iconBaseLocator);
    private final String textPractiseLocator = "//span"
            + "[@class='icons-benefit icon-practise']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']";
    private final By textPractise = By.xpath(textPractiseLocator);
    private final String textCustomLocator = "//span"
            + "[@class='icons-benefit icon-custom']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']";
    private final By textCustom = By.xpath(textCustomLocator);
    private final String textMultiLocator = "//span"
            + "[@class='icons-benefit icon-multi']"
            + "/parent::div/following-sibling::span"
            + "[@class = 'benefit-txt']";
    private final By textMulti = By.xpath(textMultiLocator);
    private final String textBaseLocator = "//span[@class='icons-benefit icon-base']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']";
    private final By textBase = By.xpath(textBaseLocator);
    private final String scrollToTheHeader = "window.scrollBy(0,-500)";
    private final String frameLocator = "frame";
    private final By frame = By.id(frameLocator);
    private final String frameButtonLocator = "frame-button";
    private final By frameButton = By.id(frameButtonLocator);
    private final By homeLeftMenu = By.partialLinkText("Home");
    private final By contactFormLeftMenu = By.partialLinkText("Contact form");
    private final By serviceLeftMenu = By.partialLinkText("Service");
    private final By metalAndColorsLeftMenu = By.partialLinkText("Metals & Colors");
    private final By elementsPacksLeftMenu = By.partialLinkText("Elements packs");


    @Test
    public void checkExercice() {
        SoftAssertions softly = new SoftAssertions();

        //Open test site by URL
        driver.get(openMainPage);
        //Assert Browser title
        softly.assertThat(driver.getTitle()).contains("Home Page");

        //Perform login
        driver.findElement(dropdownUserIcon).click();
        driver.findElement(fieldUserName).click();
        driver.findElement(fieldUserName).sendKeys(credentionalsUserName);
        driver.findElement(fieldUserPassword).click();
        driver.findElement(fieldUserPassword).sendKeys(credentionalsUserPassword);
        driver.findElement(loginButton).click();

        //Assert Username is loggined
        String actualUserName = driver.findElement(userNameHeaderView).getText();

        softly.assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        softly.assertThat(driver.findElement(homeHeaderMenu).isDisplayed());
        softly.assertThat(driver.findElement(contactFormHeaderMenu).isDisplayed());
        softly.assertThat(driver.findElement(serviceHeaderMenu).isDisplayed());
        softly.assertThat(driver.findElement(metalsAndColorsHeaderMenu).isDisplayed());

        //Assert that there are 4 images on the Index Page and they are displayed
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

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(driver.findElement(textPractise)
                .getText()).isEqualTo("To include good practices"
                + "\nand ideas from successful\nEPAM project");
        softly.assertThat(driver.findElement(iconPractise).isDisplayed());
        softly.assertThat(driver.findElement(textCustom)
                .getText()).isEqualTo("To be flexible and"
                + "\ncustomizable");
        softly.assertThat(driver.findElement(textCustom)
                .isDisplayed());
        softly.assertThat(driver.findElement(textMulti)
                .getText()).isEqualTo("To be multiplatform");
        softly.assertThat(driver.findElement(textMulti)
                .isDisplayed());
        softly.assertThat(driver.findElement(textBase)
                .getText()).isEqualTo("Already have good base\n(about 20 internal and\n"
                + "some external projects),\nwish to get more…");
        softly.assertThat(driver.findElement(textBase)
                .isDisplayed());

        //Assert that there is the iframe with “Frame Button” exist
        jse.executeScript(scrollToTheHeader);
        softly.assertThat(driver.findElement(frame).isDisplayed());

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(frameLocator);
        softly.assertThat(driver.findElement(frameButton).isDisplayed());

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        softly.assertThat(driver.findElement(homeLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(contactFormLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(serviceLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(metalAndColorsLeftMenu).isDisplayed());
        softly.assertThat(driver.findElement(elementsPacksLeftMenu).isDisplayed());

        softly.assertAll();
    }
}

