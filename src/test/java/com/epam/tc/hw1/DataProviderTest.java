package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    @DataProvider
    public static Object[][] sumLongCorrectData() {
        return new Object[][]{
                {12345, 54321, 66666},
                {-543, -92, -635},
                {0, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] sumDoubleCorrectData() {
        return new Object[][]{
                {12345.1, 54321.2, 66666.3},
                {-543.4, -92.2, -635.6},
                {0.0, 0.0, 0.0}
        };
    }

    @DataProvider
    public static Object[][] subLongCorrectData() {
        return new Object[][]{
                {12345, 54321, -41976},
                {-543, -92, -451},
                {0, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] subDoubleCorrectData() {
        return new Object[][]{
                {12345.1, 54321.2, -41976.1},
                {-543.4, -92.2, -451.2},
                {0.0, 0.0, 0.0}
        };
    }

    @DataProvider
    public static Object[][] multLongCorrectData() {
        return new Object[][]{
                {12345, 54321, 670592745},
                {-543, -92, 49956},
                {0, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] multDoubleCorrectData() {
        return new Object[][]{
                {12.5, 24.2, 302.5},
                {-543.4, -92.221, 50112.8914},
                {0.0, 0.0, 0.0}
        };
    }

    @DataProvider
    public static Object[][] divLongCorrectData() {
        return new Object[][]{
                {144, 2, 72},
                {-542, -3, 180}
        };
    }

    @DataProvider
    public static Object[][] divDoubleCorrectData() {
        return new Object[][]{
                {24.2, 2.0, 12.1},
                {-987.5, -0.5, 1975.0}
        };
    }

}
