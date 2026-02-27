package com.stellagosa.leetcode.leetcode100_999.leetcode_496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 下一个更大元素Ⅰ
 * @date 2026/2/27 19:15 星期五
 */
public class Solution {

    // 单调栈处理 nums2
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[m];

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                if (stack.peek() > nums2[i]) {
                    map.put(nums2[i], stack.peek());
                } else {
                    while (!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
                    if (stack.isEmpty()) {
                        map.put(nums2[i], -1);
                    } else {
                        map.put(nums2[i], stack.peek());
                    }
                }
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < m; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<>(nums2.length);
//        for (int i = 0; i < nums2.length; i++) {
//            map.put(nums2[i], i);
//        }
//        int n = nums1.length;
//        int[] res = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            Integer index = map.get(nums1[i]);
//            boolean flag = false;
//            for (int j = index + 1; j < nums2.length; j++) {
//                if (nums2[j] > nums1[i]) {
//                    res[i] = nums2[j];
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                res[i] = -1;
//            }
//        }
//        return res;
//    }
}
