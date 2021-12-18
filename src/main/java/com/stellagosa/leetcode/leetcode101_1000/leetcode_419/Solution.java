package com.stellagosa.leetcode.leetcode101_1000.leetcode_419;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/18 11:22
 * @Description: 甲板上的战舰
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
