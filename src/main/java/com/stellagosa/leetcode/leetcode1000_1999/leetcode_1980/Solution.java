package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1980;

/**
 * @author Stellagosa
 * @description 找出不同的二进制字符串
 * @date 2026/3/9 15:15 星期一
 */
public class Solution {

    // 每行找一个不同的
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder builder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            builder.append((nums[i].charAt(i) - '0') ^ 1);
        }

        return builder.toString();
    }
}
