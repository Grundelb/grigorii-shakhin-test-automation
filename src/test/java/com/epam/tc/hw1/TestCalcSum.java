package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalcSum {

    @Test(groups = "sub and sum", dataProvider = "sumLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void sumTwoDigits(long firstDigit, long secondDigit, long result) {
        Calculator calculator = new Calculator();

        var act = calculator.sum(firstDigit, secondDigit);

        Assert.assertEquals(act, result, "Error in long sum method");

    }

    @Test(groups = "sub and sum", dataProvider = "sumDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void sumTwoDoubleDigits(double firstDigit, double secondDigit, double result) {
        Calculator calculator = new Calculator();

        var act = calculator.sum(firstDigit, secondDigit);

        Assert.assertEquals(act, result, 0.001, "Error in double sum method");

    }

}
