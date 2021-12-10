package com.stellagosa.leetcode.leetcode1_100.leetcode_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:12
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};

        long startTime = System.nanoTime();

        int[] ints = solution.twoSum(nums, 9);

        long endTime = System.nanoTime();
        System.out.println("[" + ints[0] + ", " + ints[1] + "]");
        System.out.println("程序执行时间：" + (endTime - startTime) + "纳秒");
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
}
