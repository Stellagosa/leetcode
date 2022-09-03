package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2022/9/4 6:52
 * @Description: 二进制矩阵中的特殊位置
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{0, 0}, {0, 0}, {1, 0}};
        System.out.println(solution.numSpecial(mat));
    }

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowNumOneCount = new int[m];
        int[] colNumOneCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowNumOneCount[i] += mat[i][j];
                colNumOneCount[j] += mat[i][j];
            }
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowNumOneCount[i] == 1 && colNumOneCount[j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

//    public int numSpecial(int[][] mat) {
//        int m = mat.length, n = mat[0].length;
//        int[] rowNumOneCount = new int[m];
//        int[] colNumOneCount = new int[n];
//        List<List<Integer>> numOneLoc = new ArrayList<>();
//
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//                if (mat[i][j] == 1) {
//                    rowNumOneCount[i]++;
//                    colNumOneCount[j]++;
//                    List<Integer> list = new ArrayList<>();
//                    list.add(i);
//                    list.add(j);
//                    numOneLoc.add(list);
//                }
//            }
//        }
//
//        int res = 0;
//
//        for (List<Integer> loc : numOneLoc) {
//            if (rowNumOneCount[loc.get(0)] == 1 && colNumOneCount[loc.get(1)] == 1) {
//                res++;
//            }
//        }
//        return res;
//    }

//    public int numSpecial(int[][] mat) {
//        Map<Integer, Integer> rowZeroCount = new HashMap<>();
//        Map<Integer, Integer> colZeroCount = new HashMap<>();
//        List<List<Integer>> numOneLoc = new ArrayList<>();
//
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//                if (mat[i][j] == 0) {
//                    rowZeroCount.merge(i, 1, Integer::sum);
//                    colZeroCount.merge(j, 1, Integer::sum);
//                } else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(i);
//                    list.add(j);
//                    numOneLoc.add(list);
//                }
//            }
//        }
//
//        int res = 0;
//
//        for (List<Integer> loc : numOneLoc) {
//            if (rowZeroCount.get(loc.get(0)) == mat[loc.get(0)].length - 1 &&
//                    colZeroCount.get(loc.get(1)) == mat.length - 1) {
//                res++;
//            }
//        }
//        return res;
//    }
}
