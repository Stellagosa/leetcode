package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3355;

/**
 * @author Stellagosa
 * @description 零数组变换Ⅰ
 * @date 2025/5/20 15:50 星期二
 */
public class Solution {

    // 差分数组
    // 对于每次查询，需要counts数组在区间[l, r]上，每个值自增1
    // 现在构建差分数组d，长度为 n + 1
    // d[0] = counts[0], d[1] = counts[1] - counts[0], d[2] = counts[2] - counts[1]... d[n - 1] = counts[n - 1] - counts[n-2]
    // counts[i] = d[0] + d[1] + d[2] + ... + d[i]
    // 现在对于任意一次查询[l,r]，则counts[l...r]自增1
    // 对于差分数组d来说，d[l] = counts[l] - counts[l-1], d[l + 1] = counts[l + 1] - counts[l], ... ,
    // d[r] = counts[r] - counts[r -1], d[r + 1] = counts[r + 1] - counts[r]
    // 只有 d[l] + 1, d[r + 1] - 1
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] d = new int[n + 1];
        for (int[] query : queries) {
            d[query[0]]++;
            d[query[1] + 1]--;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += d[i];
            if (nums[i] > count) return false;
        }
        return true;
    }


    // 超时 666/668
    // public boolean isZeroArray(int[] nums, int[][] queries) {
    //     int n = nums.length;
    //     int[] counts = new int[n];
    //
    //     for (int[] query : queries) {
    //         for (int j = query[0]; j <= query[1]; j++) {
    //             counts[j]++;
    //         }
    //     }
    //
    //     for (int i = 0; i < n; i++) {
    //         if (counts[i] < nums[i]) return false;
    //     }
    //     return true;
    // }


    // 超时 666/668
    // public boolean isZeroArray(int[] nums, int[][] queries) {
    //     Arrays.sort(queries, (Comparator.comparingInt(o -> o[0])));
    //
    //     int index = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == 0) continue;
    //         int count = 0;
    //         boolean flag = false;
    //         for (int j = index; j < queries.length; j++) {
    //             if (queries[j][0] > i) break;
    //             if (queries[j][0] <= i && queries[j][1] >= i) {
    //                 count++;
    //                 if (!flag) {
    //                     index = j;
    //                     flag = true;
    //                 }
    //             }
    //         }
    //         if (count < nums[i]) return false;
    //     }
    //     return true;
    // }

    // 超时  662/668
    // public boolean isZeroArray(int[] nums, int[][] queries) {
    //     for (int i = 0; i < nums.length; i++) {
    //         int count = 0;
    //         for (int j = 0; j < queries.length; j++) {
    //             if (queries[j][0] <= i  && queries[j][1] >= i) count++;
    //         }
    //         if (count< nums[i]) return false;
    //     }
    //     return true;
    // }

}
