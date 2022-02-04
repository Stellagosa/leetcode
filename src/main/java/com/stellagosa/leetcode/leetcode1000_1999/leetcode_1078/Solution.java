package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1078;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/26 20:16
 * @Description: Bigram 分词
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "alice is a good girl she is a good student";
        String[] res = solution.findOcurrences(text, "a", "good");
        for (String item : res) {
            System.out.println(item);
        }
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        if (split.length < 3) return new String[0];
        List<String> res = new ArrayList<>();
        for (int i = 2; i < split.length; i++) {
            if (split[i - 2].equals(first) && split[i - 1].equals(second)) {
                res.add(split[i]);
            }
        }
        return res.toArray(new String[0]);
    }
}
