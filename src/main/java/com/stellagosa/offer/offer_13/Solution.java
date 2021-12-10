package com.stellagosa.offer.offer_13;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 22:06
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = solution.movingCount(5, 4, 0);
        System.out.println(num);
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] nums = new boolean[m][n];

        if (sum(0, 0) <= k) {
            nums[0][0] = true;
        }

        decide(nums, k, m, n, 0, 1);
        decide(nums, k, m, n, 1, 0);

        int t = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j]) {
                    t++;
                }
            }
        }
        return t;
    }

    public void decide(boolean[][] nums, int k, int m, int n, int to_i, int to_j) {
        if (to_i < m && to_j < n && to_i > -1 && to_j > -1 && !nums[to_i][to_j]) {
            if (sum(to_i, to_j) <= k) {
                nums[to_i][to_j] = true;
                decide(nums, k, m, n, to_i + 1, to_j);
                decide(nums, k, m, n, to_i, to_j + 1);
                // decide(nums, k, m, n, to_i - 1, to_j);
                // decide(nums, k, m, n, to_i, to_j - 1);
            }
        }
    }

    public int sum(int i, int j) {
        return i / 10 + i % 10 + j / 10 + j % 10;
    }
}
