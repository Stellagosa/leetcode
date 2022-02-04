package com.stellagosa.leetcode.leetcode100_999.leetcode_451;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:52
 */
public class Main {
    public static void main(String[] args) {
        String s = "free";
        // Solution solution = new Solution();
        // String sort = solution.frequencySort(s);
        // System.out.println(sort);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int max = 0;
        char c = 0;
        StringBuilder builder = new StringBuilder();
        int length = map.keySet().size();
        for (int i = 0; i < length; i++) {
            for (Character ch : map.keySet()) {
                Integer num = map.get(ch);
                if (num > max) {
                    max = num;
                    c = ch;
                }
            }
            while (max > 0) {
                builder.append(c);
                max--;
            }
            map.remove(c);
        }
        System.out.println(builder.toString());
    }
}
