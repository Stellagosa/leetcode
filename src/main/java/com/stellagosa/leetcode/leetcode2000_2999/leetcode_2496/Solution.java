package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2496;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/23 16:42
 * @Description: 数组中字符串的最大值
 */
public class Solution {

    public int maximumValue(String[] strs) {
        int max = -1;
        for(String str:strs) {
            char[] arr = str.toCharArray();
            int num = 0;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] >= 'a' && arr[i] <= 'z') {
                    num = arr.length;
                    break;
                } else {
                    num *= 10;
                    num += arr[i] - '0';
                }
            }
            max = Math.max(max, num);
        }
        return max;
    }
}
