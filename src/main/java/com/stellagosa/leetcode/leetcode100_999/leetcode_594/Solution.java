package com.stellagosa.leetcode.leetcode100_999.leetcode_594;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 最长和谐子序列
 * @date 2025/6/30 16:03 星期一
 */
public class Solution {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer next = map.get(entry.getKey() + 1);
            if (next == null) continue;
            max = Math.max(max, entry.getValue() + next);
        }
        return max;
    }


    // public int findLHS(int[] nums) {
    //     Map<Integer, Integer> map = new TreeMap<>();
    //     for (int num : nums) {
    //         map.merge(num, 1, Integer::sum);
    //     }
    //     int max = 0;
    //     Map.Entry<Integer, Integer> cur = null;
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (cur == null) {
    //             cur = entry;
    //             continue;
    //         }
    //         if (cur.getKey() == entry.getKey() - 1) {
    //             max = Math.max(max, cur.getValue() + entry.getValue());
    //         }
    //         cur = entry;
    //     }
    //     return max;
    // }
}
