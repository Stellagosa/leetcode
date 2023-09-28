package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2251;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 花期内花的数目
 * @date 2023/9/28 7:24 星期四
 */
public class Solution {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int len = flowers.length;
        int[] arr1 = new int[len]; // 花开放时间
        int[] arr2 = new int[len]; // 花闭合时间
        for (int i = 0; i < len; i++) {
            arr1[i] = flowers[i][0];
            arr2[i] = flowers[i][1];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = people.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int a1 = search1(arr1, people[i]); // 查找开放花朵
            int a2 = search2(arr2, people[i]); // 查找闭合花朵
            result[i] = a1 - a2; // 当前开放花朵
        }
        return result;
    }

    // <= target 的个数
    private int search1(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        if (target < arr[l]) return 0;
        if (target > arr[r]) return r + 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    // < target 的个数
    private int search2(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        if (target < arr[l]) return 0;
        if (target > arr[r]) return r + 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

}
