package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.withPrecision;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCalcSub extends AbstractCalcTest {

    @Test(groups = "sub and sum", dataProvider = "subLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void subTwoDigits(long firstDigit, long secondDigit, long result) {

        var act = calculator.sub(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in long sub method")
                .isEqualTo(result);
    }

    @Test(groups = "sub and sum", dataProvider = "subDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void subTwoDoubleDigits(double firstDigit, double secondDigit, double result) {

        var act = calculator.sub(firstDigit, secondDigit);

        Assertions.assertThat(act).as("The issue in double sub method")
                .isEqualTo(result, withPrecision(0.001));
    }

}
