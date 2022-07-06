package com.stellagosa.leetcode.leetcode100_999.leetcode_648;

import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/7 5:46
 * @Description:
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((o1, o2) -> o1.length() - o2.length());

        StringBuilder builder = new StringBuilder();

        String[] split = sentence.split(" ");

        for (String word : split) {
            boolean flag = false;
            for (String s : dictionary) {
                if (word.startsWith(s)) {
                    builder.append(s).append(" ");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                builder.append(word).append(" ");
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
