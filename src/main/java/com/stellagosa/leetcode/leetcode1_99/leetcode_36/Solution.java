package com.stellagosa.leetcode.leetcode1_99.leetcode_36;

/**
 * @author Stellagosa
 * @description 有效的数独
 * @date 2026/2/24 21:43 星期二
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                            {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}
        };

        solution.isValidSudoku(board);
    }

    // 暴力
    public boolean isValidSudoku(char[][] board) {
        int[] flag1 = new int[9]; // 小9格
        for (int i = 0; i < 9; i++) {
            int flag2 = 0; // 水平
            int flag3 = 0; // 垂直
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    // 判断对应位是否是1
                    // 是1，说明已经出现过，返回 false
                    if ((flag2 & (1 << num)) > 0) return false;
                    flag2 |= (1 << num);

                    // 小9格
                    // 根据i、j的值判断是哪一个flag1
                    int index = (i / 3) * 3 + (j / 3);
                    if ((flag1[index] & (1 << num)) > 0) return false;
                    flag1[index] |= (1 << num);
                }
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if ((flag3 & (1 << num)) > 0) return false;
                    flag3 |= (1 << num);
                }
            }
        }
        return true;
    }
}
