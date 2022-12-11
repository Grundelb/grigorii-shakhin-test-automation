package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalcMult {

    @Test(groups = "mult and div", dataProvider = "multLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void multTwoDigits(long firstDigit, long secondDigit, long result) {
        Calculator calculator = new Calculator();

        var act = calculator.mult(firstDigit, secondDigit);

        Assert.assertEquals(act, result, "Error in long mult method");

    }

    @Test(groups = "mult and div", dataProvider = "multDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void multTwoDoubleDigits(double firstDigit, double secondDigit, double result) {
        Calculator calculator = new Calculator();

        var act = calculator.mult(firstDigit, secondDigit);

        Assert.assertEquals(act, result, 0.001, "Error in double mult method");

    }

}
