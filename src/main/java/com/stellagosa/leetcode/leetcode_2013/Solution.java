package com.stellagosa.leetcode.leetcode_2013;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/26 14:46
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        String[] command = {
                "add", "add", "add", "add", "add", "add", "add", "add", "add", "add",
                "add", "add", "add", "add", "add", "add", "add", "add", "add", "add",
                "add", "add", "add", "add", "add", "add", "add", "add", "add", "add",
                "add", "add", "add", "add", "add", "add", "add", "add", "add", "add",
                "add", "add", "add", "add", "add", "add", "add", "add", "add", "add",
                "add", "add", "add", "add", "add", "add", "add", "add", "add", "add",
                "count"
        };

        int[][] arr = {
                {0, 1}, {1, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1}, {0, 1},
                {1, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1}, {0, 1}, {1, 0},
                {1, 1}, {0, 1}, {1, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1}, {0, 1}, {1, 0}, {1, 1},
                {0, 1000}, {1000, 0}, {1000, 1000}, {0, 1000}, {1000, 0}, {1000, 1000}, {0, 1000}, {1000, 0}, {1000, 1000}, {0, 1000},
                {1000, 0}, {1000, 1000}, {0, 1000}, {1000, 0}, {1000, 1000}, {0, 1000}, {1000, 0}, {1000, 1000}, {0, 1000}, {1000,0},
                {1000,1000},{0,1000},{1000,0},{1000,1000},{0,1000},{1000,0},{1000,1000},{0,1000},{1000,0},{1000,1000},
                {0,0}
        };

        DetectSquares squares = new DetectSquares();
        for (int i = 0; i < 60; i++) {
            squares.add(arr[i]);
        }
        System.out.println(squares.count(arr[60]));
    }
}
