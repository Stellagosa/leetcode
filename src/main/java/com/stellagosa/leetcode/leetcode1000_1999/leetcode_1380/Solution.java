package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1380;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/15 10:36
 * @Description: 矩阵中的幸运数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        solution.luckyNumbers(matrix).forEach(System.out::println);
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        for (int[] ints : matrix) {
            int min = Integer.MAX_VALUE;
            int index = -1; // 最小值所在位置
            // 查找一行中最小的
            for (int j = 0; j < n; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    index = j;
                }
            }

            boolean isMax = true;
            // 判断该最小值在该列中是不是最大的
            for (int[] value : matrix) {
                // 该列中存在比该最小值大的值
                if (value[index] > min) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                res.add(min);
            }
        }
        return res;
    }
}
