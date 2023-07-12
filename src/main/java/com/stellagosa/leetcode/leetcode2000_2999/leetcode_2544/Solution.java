package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2544;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/12 10:06
 * @Description: 交替数字和
 */
public class Solution {

    public int alternateDigitSum(int n) {
        int flag = 1;
        int result = 0;
        while (n > 0) {
            result += flag * (n % 10);
            flag = -flag;
            n /= 10;
        }
        return -flag * result;
    }
}
