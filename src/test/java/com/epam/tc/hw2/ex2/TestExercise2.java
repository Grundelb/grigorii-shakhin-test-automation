package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.WebDriverSetup;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestExercise2 extends WebDriverSetup {
    public TestExercise2() {
    }

    @Test
    public void checkExercice2() {
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

        //Open through the header menu Service -> Different Elements Page
        driver.findElement(By.partialLinkText("SERVICE")).click();
        driver.findElement(By.xpath("//span[@class='caret']/parent::a/following-sibling::ul/li/"
                        + "a[text()='Different elements']"))
                .click();

        //Select checkboxes
        driver.findElement(By.xpath("//*[text()[contains(.,'Water')]]/input")).click();
        driver.findElement(By.xpath("//*[text()[contains(.,'Wind')]]/input")).click();

        //Select radio
        driver.findElement(By.xpath("//*[text()[contains(.,'Selen')]]/input")).click();

        //Select in dropdown
        driver.findElement(By.className("colors")).click();
        driver.findElement(By.xpath("//option[text()='Yellow']")).click();

        /*Assert that
             • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
             • for radio button there is a log row and value is corresponded to the status of radio button
             • for dropdown there is a log row and value is corresponded to the selected value.*/
        softly.assertThat(driver.findElement(By.xpath("//li[text()[contains(.,'Water: condition changed to true')]]"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//li[text()[contains(.,'Wind: condition changed to true')]]"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//li[text()[contains(.,'metal: value changed to  Selen')]]"))
                .isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//li[text()[contains(.,'Colors: value changed to Yellow')]]"))
                .isDisplayed());
    }
}
