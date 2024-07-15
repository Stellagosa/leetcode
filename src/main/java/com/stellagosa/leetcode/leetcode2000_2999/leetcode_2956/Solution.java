package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2956;

/**
 * @author Stellagosa
 * @description 找到两个数组中的公共元素
 * @date 2024/7/16 6:34 星期二
 */
public class Solution {


    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] flag1 = new boolean[101];
        boolean[] flag2 = new boolean[101];
        for (int num : nums1) {
            flag1[num] = true;
        }
        for (int num : nums2) {
            flag2[num] = true;
        }
        int count1 = 0, count2 = 0;
        for (int num : nums1) {
            count1 += flag2[num] ? 1 : 0;
        }
        for (int num : nums2) {
            count2 += flag1[num] ? 1 : 0;
        }
        return new int[]{count1, count2};
    }

    // public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    //     Set<Integer> set1 = new HashSet<>();
    //     Set<Integer> set2 = new HashSet<>();
    //     for (int num : nums1) {
    //         set1.add(num);
    //     }
    //     for (int num : nums2) {
    //         set2.add(num);
    //     }
    //     int count1 = 0, count2 = 0;
    //     for (int num : nums1) {
    //         if (set2.contains(num)) {
    //             count1++;
    //         }
    //     }
    //     for (int num : nums2) {
    //         if (set1.contains(num)) {
    //             count2++;
    //         }
    //     }
    //     return new int[]{count1, count2};
    // }

}
