package com.epam.tc.hw3.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuPage extends AbstractPage {
    private final String credentionalsUserName = "Roman";
    private final String credentionalsUserPassword = "Jdi1234";

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement differentElementsServiceElement;
    @FindBy(id = "user-icon")
    private WebElement dropdownUserIcon;
    @FindBy(id = "name")
    private WebElement fieldUserName;
    @FindBy(id = "password")
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

    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameHeaderView() {
        return userNameHeaderView.getText();
    }

    public WebElement getHomeHeaderMenu() {
        return homeHeaderMenu;
    }

    public WebElement getContactFormHeaderMenu() {
        return contactFormHeaderMenu;
    }

    public WebElement getServiceHeaderMenu() {
        return serviceHeaderMenu;
    }

    public WebElement getMetalsAndColorsHeaderMenu() {
        return metalsAndColorsHeaderMenu;
    }

    @Override
    protected void openPage() {

    }

    public void login() {
        dropdownUserIcon.click();
        waitForElementLocatedBy(driver, fieldUserName);
        fieldUserName.click();
        fieldUserName.sendKeys(credentionalsUserName);
        fieldUserPassword.click();
        fieldUserPassword.sendKeys(credentionalsUserPassword);
        loginButton.click();
    }

    public List<WebElement> verifyHeaderMenuElements() {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(homeHeaderMenu);
        webElementList.add(contactFormHeaderMenu);
        webElementList.add(serviceHeaderMenu);
        webElementList.add(metalsAndColorsHeaderMenu);
        return webElementList;
    }

    public void openDifferentElementsPage() {
        serviceHeaderMenu.click();
        waitForElementLocatedBy(driver, differentElementsServiceElement);
        differentElementsServiceElement.click();
    }

}
