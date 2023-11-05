package com.stellagosa.leetcode.leetcode100_999.leetcode_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 重复的DNA序列
 * @date 2023/11/5 11:13 星期日
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        solution.findRepeatedDnaSequences(s);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 10) return list;
        Map<Integer, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int pre = 0;
        for (int i = 0; i < 10; ++i) {
            pre <<= 2;
            pre = pre | get(array[i]);
        }
        map.put(pre, 1);
        for (int i = 10; i < array.length; ++i) {
            pre = pre & 0b111_111_111_111_111_111;
            pre <<= 2;
            pre |= get(array[i]);
            map.merge(pre, 1, Integer::sum);
            if (map.get(pre) == 2) {
                list.add(s.substring(i - 9, i + 1));
            }
        }
        return list;
    }

    private int get(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    // public List<String> findRepeatedDnaSequences(String s) {
    //     Map<String, Integer> map = new HashMap<>();
    //     List<String> list = new ArrayList<>();
    //     for (int i = 0; i < s.length() - 9; ++i) {
    //         String sub = s.substring(i, i + 10);
    //         map.merge(sub, 1, Integer::sum);
    //         if (map.get(sub) == 2) {
    //             list.add(sub);
    //         }
    //     }
    //     return list;
    // }

}
