package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2553;

/**
 * @author Stellagosa
 * @description 分割数组中数字的数位
 * @date 2026/5/11 8:16 星期一
 */
public class Solution {

    public int[] separateDigits(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n += lengthOfNum(num);
        }
        int[] res = new int[n];
        int i = n - 1, j = nums.length - 1;
        while (i >= 0 && j >= 0) {
            int num = nums[j];
            if (num == 0) {
                res[i] = 0;
                i--;
                j--;
            } else {
                while (num > 0) {
                    res[i] = num % 10;
                    num /= 10;
                    i--;
                }
                j--;
            }
        }
        return res;
    }
    private int lengthOfNum(int num) {
        if (num >= 10000) return 5;
        if (num >= 1000) return 4;
        if (num >= 100) return 3;
        if (num >= 10) return 2;
        return 1;
    }
}
