package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2032;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/12/29 13:43
 * @Description: 至少在两个数组中出现的值
 */
public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] flag = new int[101];
        List<Integer> res = new LinkedList<>();

        for (int num : nums1) {
            flag[num] = 1;
        }

        for (int num : nums2) {
            if (flag[num] == 1) {
                res.add(num);
                flag[num] = -1;
            }
            if (flag[num] == 0) {
                flag[num] = 2;
            }
        }

        for (int num : nums3) {
            if (flag[num] == 1 || flag[num] == 2) {
                res.add(num);
                flag[num] = -1;
            }
        }
        return res;
    }
}
