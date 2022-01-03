package com.stellagosa.leetcode.leetcode_1185;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/3 14:21
 * @Description: 一周中的第几天
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
    }

    // 1970年12月31号是星期四
    public String dayOfTheWeek(int day, int month, int year) {
        String[] res = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        count += 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            count += months[i];
        }
        if (month > 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            count += 1;
        }
        count += day;

        return res[(count + 3) % 7];
    }

//    public String dayOfTheWeek(int day, int month, int year) {
//        String[] res = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        LocalDate date = LocalDate.of(year, month, day);
//        DayOfWeek week = date.getDayOfWeek();
//        return res[week.getValue() - 1];
//    }

}
