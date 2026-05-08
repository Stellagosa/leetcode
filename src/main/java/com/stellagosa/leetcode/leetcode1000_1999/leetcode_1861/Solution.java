package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1861;

/**
 * @author Stellagosa
 * @description 旋转盒子
 * @date 2026/5/8 11:03 星期五
 */
public class Solution {

    public static void main(String[] args) {
        char[][] boxGrid = {{'#','#','*','.','*','.'},
                            {'#','#','#','*','.','.'},
                            {'#','#','#','.','#','.'}};
        Solution solution = new Solution();
        solution.rotateTheBox(boxGrid);
    }

    // (i,j)->(j,m-i-1)
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n= boxGrid[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            int k = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                // res[j][i] = boxGrid[m-i-1][j];
                if (boxGrid[m-i-1][j] == '*') {
                    res[j][i] = '*';
                    while (k > j) {
                        res[k][i] = '.';
                        k--;
                    }
                    k--;
                } else if (boxGrid[m-i-1][j] == '#') {
                    res[k][i] = '#';
                    k--;
                }
            }
            while (k >= 0) {
                res[k][i] = '.';
                k--;
            }
        }
        return res;
    }
}
