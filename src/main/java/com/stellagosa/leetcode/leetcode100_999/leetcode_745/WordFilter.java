package com.stellagosa.leetcode.leetcode100_999.leetcode_745;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/14 7:58
 * @Description: 前缀和后缀搜索
 */
public class WordFilter {

    Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length() && j <= 7; j++) {
                for (int k = 1; k <= words[i].length() && k <= 7; k++) {
                    String pref = words[i].substring(0, j);
                    String suff = words[i].substring(words[i].length() - k);
                    map.put(pref + " " + suff, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + " " + suff, -1);
    }

}
