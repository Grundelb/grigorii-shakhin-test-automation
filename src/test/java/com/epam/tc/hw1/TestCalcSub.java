package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalcSub {

    @Test(groups = "sub and sum", dataProvider = "subLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void subTwoDigits(long firstDigit, long secondDigit, long result) {
        Calculator calculator = new Calculator();

        var act = calculator.sub(firstDigit, secondDigit);

        Assert.assertEquals(act, result, "Error in long sub method");

    }

    @Test(groups = "sub and sum", dataProvider = "subDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void subTwoDoubleDigits(double firstDigit, double secondDigit, double result) {
        Calculator calculator = new Calculator();

        var act = calculator.sub(firstDigit, secondDigit);

        Assert.assertEquals(act, result, 0.001, "Error in double sub method");

    }

}
