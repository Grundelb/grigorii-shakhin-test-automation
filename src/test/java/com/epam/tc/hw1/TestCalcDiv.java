package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.withPrecision;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCalcDiv extends AbstractCalcTest {

    @Test(groups = "mult and div", dataProvider = "divLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void divTwoDigits(long firstDigit, long secondDigit, long result) {

        var act = calculator.div(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in long div method")
                .isEqualTo(result);
    }

    @Test(groups = "mult and div", dataProvider = "divDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void divTwoDoubleDigits(double firstDigit, double secondDigit, double result) {

        var act = calculator.div(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in double div method")
                .isEqualTo(result, withPrecision(0.001));
    }

    @Test(groups = "mult and div")
    public void divTwoDigitsDevideByZero() {

        try {
            var act = calculator.div(0L, 0L);

            Assertions.fail("Exception 'NumberFormatException' is expected");

        } catch (NumberFormatException e) {
            //checkstyle
        }
    }

    @Test(groups = "mult and div")
    public void divTwoDoubleDigitsDevideByZero() {

        try {
            var act = calculator.div(0.0, 0.0);

            Assertions.fail("Exception 'NumberFormatException' is expected");

        } catch (NumberFormatException e) {
            //checkstyle
        }
    }

}
