package com.stellagosa.leetcode.leetcode100_999.leetcode_349;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 12:29
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Solution solution = new Solution();
        Arrays.stream(solution.intersection(nums1, nums2)).forEach(System.out::println);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
