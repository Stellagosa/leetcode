package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2540;

/**
 * @author Stellagosa
 * @description 最小公共值
 * @date 5/19/2026 2:03 PM Tuesday
 */
public class Solution {

    public int GetCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        return -1;
    }

}
