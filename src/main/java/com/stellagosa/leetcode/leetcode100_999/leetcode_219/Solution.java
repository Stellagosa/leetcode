package com.stellagosa.leetcode.leetcode100_999.leetcode_219;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/19 10:25
 * @Description: 存在重复元素Ⅱ
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1, 1};
        System.out.println(solution.containsNearbyDuplicate(nums, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     Set<Integer> set = new HashSet<>();
    //     int n = nums.length;
    //     for (int i = 0; i <= k && i < n; i++) {
    //         if (!set.add(nums[i])) {
    //             return true;
    //         }
    //     }
    //     // 前k+1个添加到set中
    //     for (int i = k + 1; i < n; i++) {
    //         set.remove(nums[i - k - 1]);
    //         if (!set.add(nums[i])) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
