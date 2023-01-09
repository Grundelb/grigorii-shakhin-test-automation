package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.WebDriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestExerciseCheckDifferentElements extends WebDriverSetup {
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
    private final String differentElementsServiceElementLocator = "//a[text()='Different elements']";
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

    @Test(priority = 1, description = "Assert Browser title")
    public void verifyBrowserTitle() {
        driver.get(openMainPage);

        String actualTitle = driver.getTitle();

        softly.assertThat(actualTitle).contains("Home Page");
    }

    @Test(priority = 2, description = "Assert Username is loggined")
    public void verifyUserCredentionalsView() {
        waitForElementLocatedBy(driver, dropdownUserIcon);
        driver.findElement(dropdownUserIcon).click();
        waitForElementLocatedBy(driver, fieldUserName);
        driver.findElement(fieldUserName).click();
        driver.findElement(fieldUserName).sendKeys(credentionalsUserName);
        driver.findElement(fieldUserPassword).click();
        driver.findElement(fieldUserPassword).sendKeys(credentionalsUserPassword);
        driver.findElement(loginButton).click();

        String actualUserName = driver.findElement(userNameHeaderView).getText();

        softly.assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");
    }

    @Test(priority = 3, description = "Assert that"
            + "• for each checkbox there is an individual log row and value is corresponded to the status of checkbox"
            + "• for radio button there is a log row and value is corresponded to the status of radio button"
            + "• for dropdown there is a log row and value is corresponded to the selected value.")
    public void verifyDifferentElementsPage() {
        driver.findElement(serviceHeaderMenu).click();
        driver.findElement(differentElementsServiceElement).click();
        waitForElementLocatedBy(driver, waterCheckbox);
        driver.findElement(waterCheckbox).click();
        driver.findElement(windCheckbox).click();
        driver.findElement(selenRadioButton).click();
        driver.findElement(colorsDropDownMenu).click();
        driver.findElement(yellowOptionColors).click();

        softly.assertThat(driver.findElement(logsContainWater)
                .isDisplayed());
        softly.assertThat(driver.findElement(logsContainWind)
                .isDisplayed());
        softly.assertThat(driver.findElement(logsContainSelen)
                .isDisplayed());
        softly.assertThat(driver.findElement(logsContainYellow)
                .isDisplayed());
    }
}
