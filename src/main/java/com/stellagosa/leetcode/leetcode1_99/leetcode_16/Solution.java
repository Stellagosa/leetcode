package com.stellagosa.leetcode.leetcode1_99.leetcode_16;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/16 15:46
 * @Description: 最接近的三数之和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int best = 100000;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == target) return target;
                else if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                } else if (sum > target) {
                    end--;
                } else {
                    begin++;
                }

            }
        }
        return best;
    }
}
