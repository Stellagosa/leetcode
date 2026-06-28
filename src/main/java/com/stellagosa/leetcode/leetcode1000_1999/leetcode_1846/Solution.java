package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1846;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 减小和重新排列数组后的最大元素
 * @date 6/28/2026 9:28 AM Sunday
 */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

}
