package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2643;

/**
 * @author Stellagosa
 * @description 一最多的行
 * @date 2025/3/22 8:12 星期六
 */
public class Solution {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max = 0, row = 0;
        for (int i = m - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += mat[i][j];
            }
            if (count >= max) {
                max = count;
                row = i;
            }
        }
        return new int[]{row, max};
    }

}
