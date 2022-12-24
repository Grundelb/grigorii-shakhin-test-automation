package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.WebDriverSetup;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestExercise2 extends WebDriverSetup {
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
    private final By serviceHeaderMenu = By.partialLinkText("SERVICE");
    private final String differentElementsServiceElementLocator = "//span"
            + "[@class='caret']/parent::a/following-sibling::ul/li/a[text()='Different elements']";
    private final By differentElementsServiceElement = By.xpath(differentElementsServiceElementLocator);
    private final String waterCheckboxLocator = "//*[text()[contains(.,'Water')]]/input";
    private final By waterCheckbox = By.xpath(waterCheckboxLocator);
    private final String windCheckboxLocator = "//*[text()[contains(.,'Wind')]]/input";
    private final By windCheckbox = By.xpath(windCheckboxLocator);
    private final String selenRadioButtonLocator = "//*[text()[contains(.,'Selen')]]/input";
    private final By selenRadioButton = By.xpath(selenRadioButtonLocator);
    private final String colorsDropDownMenuLocator = "colors";
    private final By colorsDropDownMenu = By.className(colorsDropDownMenuLocator);
    private final String yellowOptionColorsLocator = "//option[text()='Yellow']";
    private final By yellowOptionColors = By.xpath(yellowOptionColorsLocator);
    private final String logsContainWaterLocator = "//li[text()[contains(.,'Water: condition changed to true')]]";
    private final By logsContainWater = By.xpath(logsContainWaterLocator);
    private final String logsContainWindLocator = "//li[text()[contains(.,'Wind: condition changed to true')]]";
    private final By logsContainWind = By.xpath(logsContainWindLocator);
    private final String logsContainSelenLocator = "//li[text()[contains(.,'metal: value changed to  Selen')]]";
    private final By logsContainSelen = By.xpath(logsContainSelenLocator);
    private final String logsContainYellowLocator = "//li[text()[contains(.,'Colors: value changed to Yellow')]]";
    private final By logsContainYellow = By.xpath(logsContainYellowLocator);

    @Test
    public void checkExercice2() {
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
        softly.assertThat(driver.findElement(userNameHeaderView).getText())
                .isEqualTo("ROMAN IOVLEV");

        //Open through the header menu Service -> Different Elements Page
        driver.findElement(serviceHeaderMenu).click();
        driver.findElement(differentElementsServiceElement)
                .click();

        //Select checkboxes
        driver.findElement(waterCheckbox).click();
        driver.findElement(windCheckbox).click();

        //Select radio
        driver.findElement(selenRadioButton).click();

        //Select in dropdown
        driver.findElement(colorsDropDownMenu).click();
        driver.findElement(yellowOptionColors).click();

        /*Assert that
             • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
             • for radio button there is a log row and value is corresponded to the status of radio button
             • for dropdown there is a log row and value is corresponded to the selected value.*/
        softly.assertThat(driver.findElement(logsContainWater)
                .isDisplayed());
        softly.assertThat(driver.findElement(logsContainWind)
                .isDisplayed());
        softly.assertThat(driver.findElement(logsContainSelen)
                .isDisplayed());
        softly.assertThat(driver.findElement(logsContainYellow)
                .isDisplayed());

        softly.assertAll();
    }
}
