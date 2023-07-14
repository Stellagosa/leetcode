package com.stellagosa.leetcode.leetcode1_99.leetcode_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/15 6:20
 * @Description: 四数之和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2000000000, 1000000000, 0, 2000000000};
        List<List<Integer>> result = solution.fourSum(nums, 2000000000);
    }

    // target、nums[i]∈[-10^9,10*9],会溢出
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums);
        if ((long) nums[0] + nums[1] + nums[2] + nums[3] > target) return result;
        if ((long) nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4] < target) return result;

        // i,j,k,l分别表示第一、二、三、四个数的位置
        for (int i = 0; i < n - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 去除不可能的组合
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 去除不可能的组合
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int l = n - 1;
                for (int k = j + 1; k < n - 1; k++) {
                    // 去重
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    // 去除不可能的组合
                    if ((long) nums[i] + nums[j] + nums[k] + nums[k + 1] > target) break;
                    if ((long) nums[i] + nums[j] + nums[k] + nums[n - 1] < target) continue;

                    while (l > k && (long) nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    }

                    if (l <= k) break;

                    if ((long) nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

}
