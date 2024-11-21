package com.stellagosa.leetcode.leetcode100_999.leetcode_661;

/**
 * @author Stellagosa
 * @description 图片平滑器
 * @date 2024/11/18 8:33 星期一
 */
public class Solution {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = average(i, j, img);
            }
        }
        return res;
    }

    private int average(int i, int j, int[][] img) {
        int sum = 0;
        int count = 0;
        int m = img.length;
        int n = img[0].length;
        for (int k = i - 1; k <= i + 1; k++) {
            if (k < 0 || k >= m) continue;
            for (int l = j - 1; l <= j + 1; l++) {
                if (l < 0 || l >= n) continue;
                sum += img[k][l];
                count++;
            }
        }
        return sum / count;
    }

}
