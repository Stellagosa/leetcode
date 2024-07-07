package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1958;

/**
 * @author Stellagosa
 * @description 检查操作是否合法
 * @date 2024/7/7 8:55 星期日
 */
public class Solution {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int n = board.length;
        for (int i = 0; i < direction.length; i++) {
            int[] dir = direction[i];
            int curPosX = rMove;
            int curPosY = cMove;
            boolean flag = false;
            while (true) {
                int nextPosX = curPosX + dir[0];
                int nextPosY = curPosY + dir[1];
                if (nextPosX < 0 || nextPosY < 0 || nextPosX >= n || nextPosY >= n) {
                    break;
                }
                if (board[nextPosX][nextPosY] == '.') {
                    break;
                }
                if (!flag && board[nextPosX][nextPosY] == color) {
                    break;
                }
                if (!flag && board[nextPosX][nextPosY] != color) {
                    flag = true;
                }
                if (flag && board[nextPosX][nextPosY] == color) {
                    return true;
                }
                curPosX = nextPosX;
                curPosY = nextPosY;
            }
        }
        return false;
    }

}
