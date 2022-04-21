package com.stellagosa.leetcode.leetcode100_999.leetcode_819;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/4/17 17:15
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String paragraph = "Bob.";
        String[] banned = {};
        System.out.println(solution.mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();

        char[] chars = paragraph.toCharArray();
        boolean mode = false; // 是否开始读取单词
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (mode) {
                // 已经开始读取单词了，遇到空格或标点或最后一个字母结束
                if (ch == ' ' || ch == '!' || ch == '?' || ch == '\'' || ch == ',' || ch == ';' || ch == '.') {
                    String word = paragraph.substring(index, i);
                    word = word.toLowerCase();
                    if (!set.contains(word)) {
                        map.merge(word, 1, Integer::sum);
                    }
                    mode = false;
                } else if (i == chars.length - 1) {
                    String word = paragraph.substring(index, i + 1);
                    word = word.toLowerCase();
                    if (!set.contains(word)) {
                        map.merge(word, 1, Integer::sum);
                    }
                    mode = false;
                }
            } else {
                // 还没有开始读取单词，遇到非空格或标点才开始读取单词
                if (ch == ' ' || ch == '!' || ch == '?' || ch == '\'' || ch == ',' || ch == ';' || ch == '.') {
                    continue;
                } else {
                    index = i;
                    mode = true;
                }
            }
        }

        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }
}
