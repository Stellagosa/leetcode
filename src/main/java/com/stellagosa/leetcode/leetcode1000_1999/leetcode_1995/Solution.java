package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1995;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/29 10:03
 * @Description: 统计特殊四元组
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,3,5};
        System.out.println(solution.countQuadruplets(nums));
    }
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
