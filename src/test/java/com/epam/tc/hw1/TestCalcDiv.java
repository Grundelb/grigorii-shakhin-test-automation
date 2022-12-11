package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalcDiv {


    @Test(groups = "mult and div", dataProvider = "divLongCorrectData", dataProviderClass = DataProviderTest.class)
    public void divTwoDigits(long firstDigit, long secondDigit, long result) {
        Calculator calculator = new Calculator();

        var act = calculator.div(firstDigit, secondDigit);

        Assert.assertEquals(act, result, "Error in long div method");

    }

    @Test(groups = "mult and div", dataProvider = "divDoubleCorrectData", dataProviderClass = DataProviderTest.class)
    public void divTwoDoubleDigits(double firstDigit, double secondDigit, double result) {
        Calculator calculator = new Calculator();

        var act = calculator.div(firstDigit, secondDigit);

        Assert.assertEquals(act, result, 0.001, "Error in double div method");
    }

    @Test(groups = "mult and div", expectedExceptions = NumberFormatException.class)
    public void divTwoDigitsDevideByZero() {
        Calculator calculator = new Calculator();

        var act = calculator.div(0L, 0L);

    }

    @Test(groups = "mult and div", expectedExceptions = NumberFormatException.class)
    public void divTwoDoubleDigitsDevideByZero() {
        Calculator calculator = new Calculator();
        try {
            var act = calculator.div(0.0, 0.0);
            Assert.fail("Exception expected");
        } catch (NumberFormatException e) {
            // add output for checkstyle plugin
            System.out.println("passed");
        }


    }

}
