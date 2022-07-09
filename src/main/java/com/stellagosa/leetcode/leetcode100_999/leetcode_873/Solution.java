package com.stellagosa.leetcode.leetcode100_999.leetcode_873;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/9 9:19
 * @Description: 最长的斐波那契子序列的长度
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.lenLongestFibSubseq(arr));
    }

    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        for (int num : arr) {
            set.add(num);
        }

        int max = 0;

        for (int i = n - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1 && arr[j] * 2 > arr[i]; j--) {
                int curLen = 2;
                int num1 = arr[i];
                int num2 = arr[j];
                while ((num1 - num2) < num2 && set.contains(num1 - num2)) {
                    int temp = num1 - num2;
                    num1 = num2;
                    num2 = temp;
                    curLen++;
                }
                max = Math.max(max, curLen);
            }
        }
        return max <= 2 ? 0 : max;
    }

}
