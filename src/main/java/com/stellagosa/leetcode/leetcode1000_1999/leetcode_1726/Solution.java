package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1726;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 同积元组
 * @date 2023/10/19 8:38 星期四
 */
public class Solution {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            result += count * (count - 1);
        }
        return result << 2;
    }

}
