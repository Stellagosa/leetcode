package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 子集中元素的最大数量
 * @date 6/27/2026 5:29 PM June
 */
public class Solution {

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int res = 1;
        if (map.containsKey(1)) {
            res = (map.get(1) & 1) == 1 ? map.get(1) : map.get(1) - 1;
        }

        map.remove(1);

        for (Integer num : map.keySet()) {
            if (num * num >= 1_000_000_000) continue;
            int len = 0;
            int x = num;
            while (map.get(x) != null && map.get(x) > 1) {
                len += 2;
                x *= x;
            }
            if (map.containsKey(x)) {
                len++;
            }else {
                len--;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
