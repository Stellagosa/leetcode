package com.stellagosa.leetcode.leetcode1_100.leetcode_51;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:38
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = '.';
            }
        }
        List<List<String>> lists = new ArrayList<>();
        dfs(lists, res, n, 0);
        return lists;
    }

    private void dfs(List<List<String>> lists, char[][] res, int n, int index) {
        if (index == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(res[i]));
            }
            lists.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(res, index, i, n)) {
                res[index][i] = 'Q';
                dfs(lists, res, n, index + 1);
                res[index][i] = '.';
            }
        }
    }

    private boolean check(char[][] res, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (res[i][k] == 'Q' && k != j) return false;
            if (res[k][j] == 'Q' && k != i) return false;
        }
        int p = i - 1;
        int q = j - 1;
        while (p >= 0 && q >= 0) {
            if (res[p][q] == 'Q') return false;
            p--;
            q--;
        }
        p = i + 1;
        q = j + 1;
        while (p < n && q < n) {
            if (res[p][q] == 'Q') return false;
            p++;
            q++;
        }
        p = i + 1;
        q = j - 1;
        while (p < n && q >= 0) {
            if (res[p][q] == 'Q') return false;
            p++;
            q--;
        }
        p = i - 1;
        q = j + 1;
        while (p >= 0 && q < n) {
            if (res[p][q] == 'Q') return false;
            p--;
            q++;
        }


        return true;
    }
}
