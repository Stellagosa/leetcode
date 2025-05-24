package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2942;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 查找包含给定字符的单词
 * @date 2025/5/24 9:02 星期六
 */
public class Solution {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

}
