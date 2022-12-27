package com.epam.tc.hw3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String credentionalsUserName = "Roman";
    private final String credentionalsUserPassword = "Jdi1234";
    private final String scrollToTheFooter = "window.scrollBy(0,500)";
    private final String scrollToTheHeader = "window.scrollBy(0,-500)";

    @FindBy(id = "user-icon")
    private WebElement dropdownUserIcon;
    @FindBy(id = "name")
    private WebElement fieldUserName;
    @FindBy(id = "password" )
    private WebElement fieldUserPassword;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userNameHeaderView;
    @FindBy(partialLinkText = "HOME")
    private WebElement homeHeaderMenu;
    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement contactFormHeaderMenu;
    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderMenu;
    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalsAndColorsHeaderMenu;
    @FindBy(css = ".icons-benefit.icon-practise")
    private WebElement iconPractise;
    @FindBy(css = ".icons-benefit.icon-custom")
    private WebElement iconCustom;
    @FindBy(css = ".icons-benefit.icon-multi")
    private WebElement iconMulti;
    @FindBy(css = ".icons-benefit.icon-base")
    private WebElement iconBase;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-practise']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement textPractise;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-custom']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement textCustom;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-multi']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement textMulti;
    @FindBy(xpath = "//span[@class='icons-benefit icon-base']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement textBase;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @FindBy(partialLinkText = "Home")
    private WebElement homeLeftMenu;
    @FindBy(partialLinkText = "Contact form")
    private WebElement contactFormLeftMenu;
    @FindBy(partialLinkText = "Service")
    private WebElement serviceLeftMenu;
    @FindBy(partialLinkText = "Metals & Colors")
    private WebElement metalAndColorsLeftMenu;
    @FindBy(partialLinkText = "Elements packs")
    private WebElement elementsPacksLeftMenu;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void login(String login,String password) {
        waitForElementLocatedBy(driver, dropdownUserIcon);
        dropdownUserIcon.click();


        waitForElementLocatedBy(driver, fieldUserName);
        driver.findElement(fieldUserName).click();
        driver.findElement(fieldUserName).sendKeys(credentionalsUserName);
        driver.findElement(fieldUserPassword).click();
        driver.findElement(fieldUserPassword).sendKeys(credentionalsUserPassword);
        driver.findElement(loginButton).click();
    }

    protected WebElement waitForElementLocatedBy(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, timeOutWaits)
                .until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

}
