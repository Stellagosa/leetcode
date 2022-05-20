package com.stellagosa.leetcode.leetcode100_999.leetcode_350;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 13:08
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution solution = new Solution();
        Arrays.stream(solution.intersection(nums1, nums2)).forEach(System.out::println);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                if (count == 1) {
                    map.remove(num);
                } else {
                    map.put(num, count - 1);
                }
                res.add(num);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
