package com.epam.tc.hw3.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(xpath = "//*[text()[contains(.,'Water')]]/input")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]/input")
    private WebElement windCheckbox;
    @FindBy(xpath = "//*[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadioButton;
    @FindBy(className = "colors")
    private WebElement colorsDropDownMenu;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowOptionColors;
    @FindBy(xpath = "//li[text()[contains(.,'Water: condition changed to true')]]")
    private WebElement containWaterLog;
    @FindBy(xpath = "//li[text()[contains(.,'Wind: condition changed to true')]]")
    private WebElement containWindLog;
    @FindBy(xpath = "//li[text()[contains(.,'metal: value changed to  Selen')]]")
    private WebElement containSelenLog;
    @FindBy(xpath = "//li[text()[contains(.,'Colors: value changed to Yellow')]]")
    private WebElement containYellowLog;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
    }

    public void setupDifferentElementPage() {
        waitForElementLocatedBy(driver, waterCheckbox);
        waterCheckbox.click();
        windCheckbox.click();
        selenRadioButton.click();
        colorsDropDownMenu.click();
        yellowOptionColors.click();
    }

    public List<WebElement> verifyLogs() {
        List<WebElement> list = new ArrayList<>();
        list.add(containSelenLog);
        list.add(containWaterLog);
        list.add(containWindLog);
        list.add(containYellowLog);
        return list;
    }

}
