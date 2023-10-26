package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2520;

/**
 * @author Stellagosa
 * @description 统计能整除数字的位数
 * @date 2023/10/26 8:02 星期四
 */
public class Solution {

    public int countDigits(int num) {
        int count = 0;
        int temp = num;
        while (temp > 0) {
            int mod = temp % 10;
            if (num % mod == 0) {
                count++;
            }
            temp /= 10;
        }
        return count;
    }

}
