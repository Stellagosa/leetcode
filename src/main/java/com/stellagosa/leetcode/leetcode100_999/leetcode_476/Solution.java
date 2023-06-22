package com.stellagosa.leetcode.leetcode100_999.leetcode_476;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/22 8:15
 * @Description:
 */
public class Solution {

    public int findComplement(int num) {
        int result = 0;
        int temp = 1;
        while (num > 0) {
            if (num % 2 == 0) {
                result += temp;
            }
            temp <<= 1;
            num >>= 1;
        }
        return result;
    }

}
