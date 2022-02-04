package com.stellagosa.leetcode.leetcode100_999.leetcode_884;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/28 11:20
 * @Description: 两句话中的不常见单词
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] strings = solution.uncommonFromSentences(s1, s2);
        Arrays.stream(strings).forEach(System.out::println);
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (String s : split1) {
            if (set1.contains(s)) {
                set2.remove(s);
            } else {
                set1.add(s);
                set2.add(s);
            }
        }
        for (String s : split2) {
            if (set1.contains(s)) {
                set2.remove(s);
            } else {
                set1.add(s);
                set2.add(s);
            }
        }
        return set2.toArray(new String[0]);
    }
}
