package com.epam.tc.hw3.test;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviderTest {

    @DataProvider
    public Object[][] textIconsCorrectData() {
        List<String> data = new ArrayList<>();
        data.add("To include good practices"
                + "\nand ideas from successful\nEPAM project");
        data.add("To be flexible and"
                + "\ncustomizable");
        data.add("To be multiplatform");
        data.add("Already have good base\n(about 20 internal and\n"
                + "some external projects),\nwish to get more…");

        return new Object[][]{data.toArray()};
    }
}
