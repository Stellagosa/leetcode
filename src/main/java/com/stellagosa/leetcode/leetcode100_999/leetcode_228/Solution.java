package com.stellagosa.leetcode.leetcode100_999.leetcode_228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 汇总区间
 * @date 2026/2/26 10:48 星期四
 */
public class Solution {

    // [0,2,3,4,6,8,9]
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int begin = 0;
        int n = nums.length;
        if (n < 1) return res;
        for (int i = 0; i < n; i++) {
            if (i - begin == nums[i] - nums[begin]) continue;
            if (i - 1 == begin) {
                res.add(String.valueOf(nums[begin]));
            } else {
                res.add(String.join("->",String.valueOf(nums[begin]), String.valueOf(nums[i - 1])));
            }
            begin = i;
        }
        if (begin == n - 1) {
            res.add(String.valueOf(nums[begin]));
        } else {
            res.add(String.join("->",String.valueOf(nums[begin]), String.valueOf(nums[n - 1])));
        }

        return res;
    }
}
