package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2559;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/2 下午 04:43
 * @Description: 统计范围内的元音字符串数
 */
public class Solution {

    static boolean[] isVowel = new boolean[26];

    static {
        if (!isVowel['a' - 'a']) {
            isVowel['a' - 'a'] = true;
            isVowel['e' - 'a'] = true;
            isVowel['i' - 'a'] = true;
            isVowel['o' - 'a'] = true;
            isVowel['u' - 'a'] = true;
        }
    }

    // 前缀和
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char firstChar = words[i].charAt(0);
            char lastChar = words[i].charAt(words[i].length() - 1);
            if (isVowel[firstChar - 'a'] && isVowel[lastChar - 'a']) {
                cnt[i + 1] = cnt[i] + 1;
            } else {
                cnt[i + 1] = cnt[i];
            }
        }
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = cnt[queries[i][1] + 1] - cnt[queries[i][0]];
        }
        return result;
    }


//    // 前缀和
//    public int[] vowelStrings(String[] words, int[][] queries) {
//        int n = words.length;
//        int[] cnt = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            char firstChar = words[i].charAt(0);
//            char lastChar = words[i].charAt(words[i].length() - 1);
//            if (check(firstChar) && check(lastChar)) {
//                cnt[i + 1] = cnt[i] + 1;
//            } else {
//                cnt[i + 1] = cnt[i];
//            }
//        }
//        int m = queries.length;
//        int[] result = new int[m];
//        for (int i = 0; i < m; i++) {
//            result[i] = cnt[queries[i][1] + 1] - cnt[queries[i][0]];
//        }
//        return result;
//    }
//
//    private boolean check(char ch) {
//        char[] chars = {'a', 'e', 'i', 'o', 'u'};
//        for (char c : chars) {
//            if (ch == c) return true;
//        }
//        return false;
//    }

}
