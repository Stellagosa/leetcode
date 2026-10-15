package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2913;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Stellagosa
 * @description 2913.子数组不同元素数目的平方和
 * @date 10/15/2026 8:29 AM Thursday
 */
public class Solution {

    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                ans += set.size() * set.size();
            }
        }
        return ans;
    }


}
