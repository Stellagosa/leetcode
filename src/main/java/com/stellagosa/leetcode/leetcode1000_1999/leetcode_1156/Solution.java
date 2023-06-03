package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1156;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/3 上午 09:45
 * @Description: 单字符重复子串的最大长度
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRepOpt1("aabaaabaaaba"));
    }

    public int maxRepOpt1(String text) {
        // 统计各个字符出现次数
        int[] chs = new int[26];
        for (char ch : text.toCharArray()) {
            chs[ch - 'a']++;
        }
        int n = text.length();
        int cnt = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            char ch = text.charAt(i);
            while (j < n && text.charAt(j) == ch) {
                j++;
            }
            if (j - i < chs[ch - 'a'] && j < n) {
                cnt = Math.max(j - i, cnt);
            }
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            cnt = Math.max(cnt, Math.min(k - i, chs[text.charAt(i) - 'a']));
            i = j;
        }
        return cnt;
    }

//    public int maxRepOpt1(String text) {
//        // 统计各个字符出现次数
//        Map<Character, Integer> map = new HashMap<>();
//        for (char ch : text.toCharArray()) {
//            map.merge(ch, 1, Integer::sum);
//        }
//        int n = text.length();
//        int cnt = 0;
//        for (int i = 0; i < n; ) {
//            int j = i;
//            while (j < n && text.charAt(j) == text.charAt(i)) {
//                j++;
//            }
//            if (j - i < map.getOrDefault(text.charAt(i), 0) && j < n) {
//                cnt = Math.max(j - i, cnt);
//            }
//            int k = j + 1;
//            while (k < n && text.charAt(k) == text.charAt(i)) {
//                k++;
//            }
//            cnt = Math.max(cnt, Math.min(k - i, map.getOrDefault(text.charAt(i), 0)));
//            i = j;
//        }
//        return cnt;
//    }

}
