package com.stellagosa.leetcode.leetcode100_999.leetcode_318;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 最大单词长度乘积
 * @date 2023/11/6 12:17 星期一
 */
public class Solution {

    // ab和aaab的hash值相同，但最终结果肯定使用的aaab
    // 所以对于相同hash，只需记录长度最长的就可以了
    public int maxProduct(String[] words) {
        int n = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int hash = 0;
            for (char ch : word.toCharArray()) {
                hash |= (1 << (ch - 'a'));
            }
            map.merge(hash, word.length(), Math::max);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
                if ((entry1.getKey() & entry2.getKey()) == 0) {
                    max = Math.max(max, entry1.getValue() * entry2.getValue());
                }
            }
        }
        return max;
    }

    // public int maxProduct(String[] words) {
    //     int n = words.length;
    //     int[] hash = new int[n];
    //     for (int i = 0; i < n; ++i) {
    //         for (char ch : words[i].toCharArray()) {
    //             hash[i] |= (1 << (ch - 'a'));
    //         }
    //     }
    //
    //     int max = 0;
    //     for (int i = 0; i < n; ++i) {
    //         for (int j = i + 1; j < n; ++j) {
    //             if ((hash[i] & hash[j]) == 0) {
    //                 max = Math.max(max, words[i].length() * words[j].length());
    //             }
    //         }
    //     }
    //     return max;
    // }

}
