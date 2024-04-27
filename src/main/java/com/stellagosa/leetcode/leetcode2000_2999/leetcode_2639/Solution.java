package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2639;

/**
 * @author Stellagosa
 * @description 查询网格图中每一列的宽度
 * @date 2024/4/27 8:46 星期六
 */
public class Solution {

    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int[] nums : grid) {
                max = Math.max(max, stringSize(nums[i]));
            }
            ans[i] = max;
        }
        return ans;
    }

    private int stringSize(int x) {
        int d = 0;
        if (x < 0) {
            d = 1;
            x = -x;
        }
        int p = 10;
        for (int i = 1; i < 10; i++) {
            if (x < p) {
                return d + i;
            }
            p *= 10;
        }
        return 10 + d;
    }


}
