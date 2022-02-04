package com.stellagosa.leetcode.leetcode1_99.leetcode_13;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:24
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = solution.romanToInt("MCMXCIV");
        System.out.println(num);
    }

    public int romanToInt(String s) {
        int num = 0;
        int value = getValue(s.charAt(0));
        int next;
        for (int i = 1; i < s.length(); i++) {
            next = getValue(s.charAt(i));
            num += value < next ? -value : value;
            value = next;
        }
        return num + value;
    }

    private int getValue(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

}
