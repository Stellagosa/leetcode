package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1344;

/**
 * @author Stellagosa
 * @description 时钟指针的夹角
 * @date 6/18/2026 8:00 AM June
 */
public class Solution {

    public double angleClock(int hour, int minutes) {
        hour = hour % 12;
        double temp = Math.abs(12 * minutes - 60 * hour - minutes);
        return temp > 360 ? (720-temp)/2:temp/2;
    }
}
