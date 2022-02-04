package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1154;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/21 9:17
 * @Description: 一年中的第几天
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfYear("2012-01-02"));
    }

    public int dayOfYear(String date) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int res = day;
        if (((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) && month > 2) {
            res++;
        }
        while (month > 1) {
            res += arr[month - 2];
            month--;
        }
        return res;
    }


    // public int dayOfYear(String date) {
    //     String[] dates = date.split("-");
    //     int year = Integer.parseInt(dates[0]);
    //     int month = Integer.parseInt(dates[1]);
    //     int day = Integer.parseInt(dates[2]);
    //
    //     // 1 3 5 7 8 10 12  31天
    //     // 4 6 9 11  30天
    //     // 2  28/29天
    //
    //     int res = day;
    //
    //     boolean leapYear = isLeapYear(year);
    //     while (month > 1) {
    //         res += getDay(month - 1, leapYear);
    //         month--;
    //     }
    //     return res;
    // }
    //
    // private int getDay(int month, boolean isLeapYear) {
    //     int res = 0;
    //     switch (month) {
    //         case 1:
    //         case 3:
    //         case 5:
    //         case 7:
    //         case 8:
    //         case 10:
    //         case 12:
    //             res = 31;
    //             break;
    //         case 4:
    //         case 6:
    //         case 9:
    //         case 11:
    //             res = 30;
    //             break;
    //         case 2:
    //             res = isLeapYear ? 29 : 28;
    //     }
    //     return res;
    // }
    //
    // // 闰年 是4的倍数并且不是100的倍数，是100倍数的必须是400的倍数
    // private boolean isLeapYear(int year) {
    //     return year % 4 == 0 && year % 100 != 0 || year % 100 == 0 && year % 400 == 0;
    // }

    // 不能用 LocalDate ....
    // public int dayOfYear(String date) {
    //     String[] dates = date.split("-");
    //     int year = Integer.parseInt(dates[0]);
    //     int month = Integer.parseInt(dates[1]);
    //     int day = Integer.parseInt(dates[2]);
    //
    //     LocalDate localDate = LocalDate.of(year, month, day);
    //
    //     return localDate.getDayOfYear();
    // }
}
