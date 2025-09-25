package com.example.demo.example;

public class NextDay {

    // SL1
    public static boolean isLeap(int year) {
        // SL2: Correct leap year condition
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // SL3
    public static int daysInMonth(int year, int month) {
        // SL4
        if (month == 2) {
            // SL5: Returns days for Feb (uses isLeap)
            return isLeap(year) ? 29 : 28;
        }
        // SL6
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // SL7: Returns 30 days
            return 30;
        } else {
            // SL8: Returns 31 days
            return 31;
        }
    }

    // SL9
    public static String getNextDate(int year, int month, int day) {

        int d = day;
        int m = month;
        int y = year;

        // SL10: Increment day
        d++;

        // SL11: Get max days in current month (calls daysInMonth)
        int maxDays = daysInMonth(y, m);

        // SL12: Check if day exceeded maxDays
        if (d > maxDays) {
            // SL13: Reset day to 1
            d = 1;
            // SL14: Increment month
            m++;
            // SL15: Check if month exceeded 12
            if (m > 12) {
                // SL16: Reset month to 1
                m = 1;
                // SL17: Increment year
                y++;
            }
        }
        // SL18: Return formatted date string
        return y + "-" + m + "-" + d;
    }

    public static void main(String[] args) {
        System.out.println("Original Program Examples:");
        System.out.println("Next date for 2023-04-30 is: " + getNextDate(2023, 4, 30)); // Expected: 2023-5-1
        System.out.println("Next date for 2000-02-28 is: " + getNextDate(2000, 2, 28)); // Expected: 2000-2-29
        System.out.println("Next date for 2023-12-31 is: " + getNextDate(2023, 12, 31)); // Expected: 2024-1-1
        System.out.println("Next date for 2100-02-28 is: " + getNextDate(2100, 2, 28)); // Expected: 2100-3-1
    }
}