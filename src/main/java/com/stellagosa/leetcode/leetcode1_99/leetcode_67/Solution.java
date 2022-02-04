package com.stellagosa.leetcode.leetcode1_99.leetcode_67;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/4 10:29
 * @Description: 二进制求和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();

        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();

        int i = num1.length - 1;
        int j = num2.length - 1;

        boolean flag = false;

        while (flag || i >= 0 || j >= 0) {
            char item1, item2;
            if (i < 0) {
                item1 = '0';
            } else {
                item1 = num1[i];
            }
            if (j < 0) {
                item2 = '0';
            } else {
                item2 = num2[j];
            }

            if (flag) {
                if (item1 == '1' && item2 == '1') {
                    builder.append('1');
                    flag = true;
                } else if ((item1 == '1' && item2 == '0') || (item1 == '0' && item2 == '1')) {
                    builder.append('0');
                    flag = true;
                } else {
                    builder.append('1');
                    flag = false;
                }
            } else {
                if (item1 == '1' && item2 == '1') {
                    builder.append('0');
                    flag = true;
                } else if ((item1 == '1' && item2 == '0') || (item1 == '0' && item2 == '1')) {
                    builder.append('1');
                    flag = false;
                } else {
                    builder.append('0');
                    flag = false;
                }
            }
            i--;
            j--;
        }
        return builder.reverse().toString();
    }
}
