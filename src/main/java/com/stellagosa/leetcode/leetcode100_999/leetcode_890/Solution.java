package com.stellagosa.leetcode.leetcode100_999.leetcode_890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/12 8:44
 * @Description: 查找和替换模式
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        List<String> list = solution.findAndReplacePattern(words, "abb");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word, pattern) && isMatch(pattern, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch1 = word.charAt(i);
            char ch2 = pattern.charAt(i);
            if (map.containsKey(ch2)) {
                if (map.get(ch2) != ch1) return false;
            } else {
                map.put(ch2, ch1);
            }
        }
        return true;
    }
}
