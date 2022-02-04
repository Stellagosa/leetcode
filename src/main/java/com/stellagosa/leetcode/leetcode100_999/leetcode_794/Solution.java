package com.stellagosa.leetcode.leetcode100_999.leetcode_794;

/**
 *
 * @Note 一个3X3可能性就这么多！！！！！！！！！！！！！！！！
 *
 * @Author: Stellagosa
 * @Date: 2021/12/9 7:59
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] board = new String[]{"XOX", "O O", "XOX"};
        System.out.println(solution.validTicTacToe(board));
    }

    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        for (String s : board) {
            if (s.equals(" ")) continue;
            if (s.length() > 3) return false;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'X') {
                    countX++;
                } else if (ch == 'O') {
                    countO++;
                }
            }
        }

        if (countO > countX) return false;
        if (countX > countO + 1) return false;

        // x o 相同个数或者相差1个
        // 不可能出现胜方
        if (countX < 3) return true;

        // 出现胜方
        boolean XWin = checkWin(board, 'X');
        boolean OWin = checkWin(board, 'O');
        if (XWin) {
            return !OWin && (countX == countO + 1);
        }
        if (OWin) {
            return countX == countO;
        }

        // 没有胜方
        return true;
    }

    private boolean checkWin(String[] borard, char win) {
        // 水平垂直赢的
        for (int i = 0; i < 3; i++) {
            if (borard[i].charAt(0) == win
                    && borard[i].charAt(1) == win
                    && borard[i].charAt(2) == win) {
                return true;
            }
            if (borard[0].charAt(i) == win
                    && borard[1].charAt(i) == win
                    && borard[2].charAt(i) == win) {
                return true;
            }
        }

        // 斜线赢的
        if (borard[0].charAt(0) == win
                && borard[1].charAt(1) == win
                && borard[2].charAt(2) == win) {
            return true;
        }
        return borard[0].charAt(2) == win
                && borard[1].charAt(1) == win
                && borard[2].charAt(0) == win;
    }
}

// 123  456  789
// 159 357
// 147 258 369
