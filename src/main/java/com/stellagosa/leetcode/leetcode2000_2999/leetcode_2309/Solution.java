package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2309;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2023/1/27 22:13
 * @Description: 兼具大小写的最好英文字母
 */
public class Solution {

    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        for (char ch = 'Z'; ch >= 'A'; ch--) {
            if (set.contains(ch) && set.contains(Character.toLowerCase(ch))) {
                return String.valueOf(ch);
            }
        }
        return "";
    }
}
