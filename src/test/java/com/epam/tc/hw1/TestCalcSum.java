package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.withPrecision;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCalcSum extends AbstractCalcTest {

    @Test(groups = "sub and sum", dataProvider = "sumLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void sumTwoDigits(long firstDigit, long secondDigit, long result) {

        var act = calculator.sum(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in long sum method")
                .isEqualTo(result);
    }

    @Test(groups = "sub and sum", dataProvider = "sumDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void sumTwoDoubleDigits(double firstDigit, double secondDigit, double result) {

        var act = calculator.sum(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in double sub method")
                .isEqualTo(result, withPrecision(0.001));
    }

}
