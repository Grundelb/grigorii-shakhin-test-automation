package com.epam.tc.hw3.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(css = ".icons-benefit.icon-practise")
    private WebElement practiseIcon;
    @FindBy(css = ".icons-benefit.icon-custom")
    private WebElement customIcon;
    @FindBy(css = ".icons-benefit.icon-multi")
    private WebElement multiIcon;
    @FindBy(css = ".icons-benefit.icon-base")
    private WebElement baseIcon;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-practise']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement practiseText;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-custom']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement customText;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-multi']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement multiText;
    @FindBy(xpath = "//span[@class='icons-benefit icon-base']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement baseText;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public void switchToFrame() {
        driver.switchTo().frame(frame);
    }

    public void switchToHomePage() {
        driver.switchTo().defaultContent();
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getIconsHomePage() {
        List<WebElement> iconsList = new ArrayList<>();
        iconsList.add(practiseIcon);
        iconsList.add(customIcon);
        iconsList.add(multiIcon);
        iconsList.add(baseIcon);
        return iconsList;
    }

    public List<String> getTextsIconsHomePage() {
        List<String> textsList = new ArrayList<>();
        textsList.add(practiseText.getText());
        textsList.add(customText.getText());
        textsList.add(multiText.getText());
        textsList.add(baseText.getText());
        return textsList;
    }
}
