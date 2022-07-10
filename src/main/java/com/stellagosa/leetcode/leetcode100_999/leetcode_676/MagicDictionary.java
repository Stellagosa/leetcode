package com.stellagosa.leetcode.leetcode100_999.leetcode_676;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/11 6:54
 * @Description: 实现一个魔法字典
 */
public class MagicDictionary {

    String[] dict;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        this.dict = dictionary;
    }

    public boolean search(String searchWord) {
        for (int i = 0; i < dict.length; i++) {
            if (dict[i].length() != searchWord.length()) continue;
            int count = 0;
            for (int j = 0; j < dict[i].length(); j++) {
                if (searchWord.charAt(j) != dict[i].charAt(j)) {
                    count++;
                }
                if (count > 1) break;
            }
            if (count == 1) return true;
        }
        return false;
    }
}
