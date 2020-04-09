package com.aby.c0769778_w2020_mad3125_midterm.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class HelperMethods {

    private static HelperMethods repoObj = new HelperMethods();
    public static HelperMethods getInstance() {
        return repoObj;
    }
    private HelperMethods()
    { }

    public LocalDate stringToDate(String aDate)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-yyyy");
        return formatter.parseLocalDate(aDate);
    }

    public String doubleFormatter(Double d)
    {
        return String.format("%.2f", d);
    }
}
