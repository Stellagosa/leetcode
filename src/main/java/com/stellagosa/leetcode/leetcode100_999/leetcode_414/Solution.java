package com.stellagosa.leetcode.leetcode100_999.leetcode_414;

/**
 * @author Stellagosa
 * @description 第三大的数
 * @date 2026/2/26 11:14 星期四
 */
public class Solution {

    public int thirdMax(int[] nums) {
        // 动态数组保存最大值，len记录数组长度
        int[] arr = new int[3];
        int len = 0;
        for (int num : nums) {
            if (len == 3) {
                if (num <= arr[2]) {
                    continue;
                } else if (num < arr[1]) {
                    arr[2] = num;
                } else if (num == arr[1]) {
                    continue;
                } else if (num < arr[0]) {
                    arr[2] = arr[1];
                    arr[1] = num;
                } else if (num == arr[0]) {
                    continue;
                } else {
                    arr[2] = arr[1];
                    arr[1] = arr[0];
                    arr[0] = num;
                }
            } else if (len == 2) {
                if (num > arr[0]) {
                    arr[2] = arr[1];
                    arr[1] = arr[0];
                    arr[0] = num;
                    len = 3;
                } else if (num == arr[0]) {
                    continue;
                } else if (num > arr[1]) {
                    arr[2] = arr[1];
                    arr[1] = num;
                    len = 3;
                } else if (num == arr[1]) {
                    continue;
                } else {
                    arr[2] = num;
                    len = 3;
                }
            } else if (len == 1) {
                if (num > arr[0]) {
                    arr[1] = arr[0];
                    arr[0] = num;
                    len = 2;
                } else if (num == arr[0]) {
                    continue;
                } else {
                    arr[1] = num;
                    len = 2;
                }
            } else {
                arr[0] = num;
                len = 1;
            }
        }
        if (len == 3) return arr[2];
        return arr[0];
    }

}
