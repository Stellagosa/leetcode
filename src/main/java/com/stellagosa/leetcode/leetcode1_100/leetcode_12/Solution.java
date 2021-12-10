package com.stellagosa.leetcode.leetcode1_100.leetcode_12;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:22
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.intToRoman(1994);
        System.out.println(s);
    }

    public String intToRoman(int num) {

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < value.length; i++) {
            int sign = num / value[i];
            if (sign > 0) {
                builder.append(symbol[i].repeat(sign));
            }
            num = num - sign * value[i];
        }
        return builder.toString();
    }
}
