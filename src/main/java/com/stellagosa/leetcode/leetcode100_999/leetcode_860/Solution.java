package com.stellagosa.leetcode.leetcode100_999.leetcode_860;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/22 7:56
 * @Description: 柠檬水找零
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (ten == 0) {
                five -= 3;
            } else {
                five--;
                ten--;
            }
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }
}
