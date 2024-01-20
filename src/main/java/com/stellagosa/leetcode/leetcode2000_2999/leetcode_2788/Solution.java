package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2788;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stellagosa
 * @description 按分隔符拆分字符串
 * @date 2024/1/20 12:58 星期六
 */
public class Solution {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int p = 0, q = 0;
            while (p < chars.length) {
                if (chars[p] == separator) {
                    if (p != q) {
                        result.add(String.valueOf(chars, q, p - q));
                    }
                    p++;
                    q = p;
                } else {
                    p++;
                }
            }
            if (p != q) {
                result.add(String.valueOf(chars, q, p - q));
            }
        }
        return result;
    }

}
