package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1232;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 22:02
 */
public class Solution {
    public static void main(String[] args) {
        int[][] coordinates = new int[][]{
                {2, 1}, {4, 2}, {6, 3}
        };
        Solution solution = new Solution();
        System.out.println(solution.checkStraightLine(coordinates));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i - 1][1] - coordinates[i - 2][1]) * (coordinates[i][0] - coordinates[i - 1][0]) -
                    (coordinates[i][1] - coordinates[i - 1][1]) * (coordinates[i - 1][0] - coordinates[i - 2][0]) != 0)
                return false;
        }
        return true;
    }

//    public boolean checkStraightLine(int[][] coordinates) {
//        if (coordinates.length == 2) return true;
//
//        int x = coordinates[0][0];
//        int y = coordinates[0][1];
//        int x1 = coordinates[1][0];
//        int y1 = coordinates[1][1];
//        if (x == x1) {
//            for (int i = 1; i < coordinates.length; i++) {
//                if (x1 != coordinates[i][0]) return false;
//            }
//        } else {
//            double k = (double) (y1 - y) / (x1 - x);
//            double b = y - (double) x * (y1 - y) / (x1 - x);
//            for (int i = 2; i < coordinates.length; i++) {
//                int x2 = coordinates[i][0];
//                int y2 = coordinates[i][1];
//                if (y2 != k * x2 + b) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
