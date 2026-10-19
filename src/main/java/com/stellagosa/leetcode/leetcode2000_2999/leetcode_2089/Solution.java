package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2089;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 2089.找出数组排序后的目标下标
 * @date 10/19/2026 8:45 AM Monday
 */
public class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        int small_count = 0;
        int count = 0;
        for (int num : nums) {
            if (num < target) {
                small_count++;
            } else if (num == target) {
                count++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ans.add(small_count + i);
        }
        return ans;
    }

}
