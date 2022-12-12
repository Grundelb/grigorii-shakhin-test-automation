package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.withPrecision;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCalcMult extends AbstractCalcTest {

    @Test(groups = "mult and div", dataProvider = "multLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void multTwoDigits(long firstDigit, long secondDigit, long result) {

        var act = calculator.mult(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in long mult method")
                .isEqualTo(result);
    }

    @Test(groups = "mult and div", dataProvider = "multDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void multTwoDoubleDigits(double firstDigit, double secondDigit, double result) {

        var act = calculator.mult(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in double mult method")
                .isEqualTo(result, withPrecision(0.001));
    }

}
