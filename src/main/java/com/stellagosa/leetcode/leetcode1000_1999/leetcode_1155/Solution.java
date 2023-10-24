package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1155;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 掷骰子等于目标和的方法数
 * @date 2023/10/24 6:35 星期二
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRollsToTarget(4, 6, 12));
    }

    public int numRollsToTarget(int n, int k, int target) {
        if (n * k < target) return 0;
        int mod = 1000000007;
        int[] nums1 = new int[k];
        Arrays.fill(nums1, 1);
        for (int i = 2; i <= n; ++i) {
            int[] nums2 = new int[i * k - i + 1];
            for (int j = 0; j < i * k - i + 1; ++j) {
                for (int l = Math.min(j, nums1.length - 1); l >= 0 && l >= j - k + 1; --l) {
                    nums2[j] = (nums2[j] + nums1[l]) % mod;
                }
            }
            nums1 = nums2;
        }
        return nums1[target - n];
    }


    // 超出时间限制
    // private int result;
    // private final int mod = 1000000007;
    //
    // public int numRollsToTarget(int n, int k, int target) {
    //     dfs(n, k, target);
    //     return result;
    // }
    //
    // private void dfs(int n, int k, int target) {
    //     // 不可能存在
    //     if (target < 0 || n * k < target || n > target) {
    //         return;
    //     }
    //     if (n == 0 && target == 0) {
    //         result++;
    //         result %= mod;
    //         return;
    //     }
    //     for (int i = 1; i <= k; ++i) {
    //         dfs(n - 1, k, target - i);
    //     }
    // }

}
