package com.stellagosa.leetcode.leetcode1_100.leetcode_37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:35
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        ["5","3","4","6","7","8","9","1","2"],
//        ["6","7","2","1","9","5","3","4","8"],
//        ["1","9","8","3","4","2","5","6","7"],
//        ["8","5","9","7","6","1","4","2","3"],
//        ["4","2","6","8","5","3","7","9","1"],
//        ["7","1","3","9","2","4","8","5","6"],
//        ["9","6","1","5","3","7","2","8","4"],
//        ["2","8","7","4","1","9","6","3","5"],
//        ["3","4","5","2","8","6","1","7","9"]
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    boolean stop = false;
    boolean[][] xVisited = new boolean[9][9];
    boolean[][] yVisited = new boolean[9][9];
    boolean[][] nineVisited = new boolean[9][9];
    List<List<Integer>> unVisited = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    xVisited[i][board[i][j] - '0' - 1] = true;
                    yVisited[j][board[i][j] - '0' - 1] = true;
                    nineVisited[(i / 3) * 3 + j / 3][board[i][j] - '0' - 1] = true;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    unVisited.add(list);
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int index) {
        if (index == unVisited.size()) {
            stop = true;
            return;
        }
        List<Integer> first = unVisited.get(index);
        int m = first.get(0);
        int n = first.get(1);
        for (char k = '1'; k <= '9' && !stop; k++) {
            if (!xVisited[m][k - '0' - 1] && !yVisited[n][k - '0' - 1] && !nineVisited[(m / 3) * 3 + n / 3][k - '0' - 1]) {
                board[m][n] = k;
                xVisited[m][k - '0' - 1] = true;
                yVisited[n][k - '0' - 1] = true;
                nineVisited[(m / 3) * 3 + n / 3][k - '0' - 1] = true;
                dfs(board, index + 1);
//                board[m][n] = '.';
                xVisited[m][k - '0' - 1] = false;
                yVisited[n][k - '0' - 1] = false;
                nineVisited[(m / 3) * 3 + n / 3][k - '0' - 1] = false;
            }
        }
    }
}
