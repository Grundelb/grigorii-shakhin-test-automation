package com.epam.tc.hw3.test;

import com.epam.tc.hw3.pages.HeaderMenuPage;
import com.epam.tc.hw3.pages.LeftMenuPage;
import com.epam.tc.hw3.pages.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;
import java.util.List;


public class TestsMainPage extends AbstractTest {

    MainPage mainPage;
    HeaderMenuPage headerMenuPage;
    LeftMenuPage leftMenuPage;
    private final String SCROLL_TO_THE_FOOTER = "window.scrollBy(0,500)";
    private final String SCROLL_TO_THE_HEADER = "window.scrollBy(0,-500)";


    @Test
    public void verifyBrowserTitle() {
        mainPage = new MainPage(driver);
        mainPage.openPage();
        String actualTitle = mainPage.getBrowserTitle();
        softly.assertThat(actualTitle).contains("Home Page");
    }

    @Test(priority = 2, description = "Assert Username is loggined")
    public void verifyUserName() {
        headerMenuPage = new HeaderMenuPage(driver);

        headerMenuPage.login();
        String actualUserName = headerMenuPage.getUserNameHeaderView();

        softly.assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");
    }

    @Test(priority = 3, description = "Assert that there are 4 items on the header section are displayed"
            + " and they have proper texts")
    public void verifyHeaderMenuElements() {
        headerMenuPage = new HeaderMenuPage(driver);

        softly.assertThat(headerMenuPage.verifyHeaderMenuElements()
                .listIterator().next().isDisplayed());
    }

    @Test(priority = 4, description = "Assert that there are 4 images on the Index Page and they are displayed")
    public void verifyImages() {
        mainPage = new MainPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript(SCROLL_TO_THE_FOOTER);

        softly.assertThat(mainPage.getIconsHomePage()
                .listIterator().next().isDisplayed());
    }

    @Test(priority = 5, description = "Assert that there are 4 texts "
            + "on the Index Page under icons and they have proper text"
            , dataProviderClass = DataProviderTest.class, dataProvider = "textIconsCorrectData")
    public void verifyTexts(List<String> result) {
        mainPage = new MainPage(driver);
        softly.assertThat(mainPage.getTextsIconsHomePage())
                .isEqualTo(result);
    }

    @Test(priority = 6, description = "Assert that there is the iframe with “Frame Button” exist "
            + "and check that there is “Frame Button” in the iframe")
    public void verifyFrame() {
        mainPage = new MainPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(SCROLL_TO_THE_HEADER);

        softly.assertThat(mainPage.getFrame().isDisplayed());

        mainPage.switchToFrame();

        softly.assertThat(mainPage.getFrameButton().isDisplayed());

        mainPage.switchToHomePage();
    }

    @Test(priority = 7, description = "Assert that there are 5 items "
            + "in the Left Section are displayed and they have proper text")
    public void verifyLeftMenuElements() {
        leftMenuPage = new LeftMenuPage(driver);
        softly.assertThat(leftMenuPage.verifyLeftMenu()
                .listIterator().next().isDisplayed());
    }

}