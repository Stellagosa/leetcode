package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3335;

/**
 * @author Stellagosa
 * @description 字符串转换后的长度Ⅰ
 * @date 2025/5/13 8:11 星期二
 */
public class Solution {

    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] next = new int[26];
            next[0] = count[25];
            next[1] = (count[0] + count[25]) % mod;
            for (int j = 2; j < 26; j++) {
                next[j] = count[j - 1];
            }
            count = next;
        }

        int res = 0;
        for (int i : count) {
            res = (res + i) % mod;
        }
        return res;
    }


//    public int lengthAfterTransformations(String s, int t) {
//        int mod = 1000000007;
//        int[] count = new int[26];
//        for (char ch : s.toCharArray()) {
//            count[ch - 'a']++;
//        }
//
//        long res = 0;
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] != 0) {
//                long len = dp((char) ('a' + i), t);
//                res += len * count[i] % mod;
//                res %= mod;
//            }
//        }
//        return (int) res;
//    }
//
//    // 计算字符 ch 经过 t 次变换后的长度
//    private long dp(char ch, int t) {
//        int mod = 1000000007;
//        if (t <= 'z' - ch) return 1;
//
//        // 全部转成字符 'a'
//        if (ch != 'a') {
//            return dp('a', t - ('z' - ch + 1)) + dp('a', t - ('z' - ch));
//        }
//
//        // 字符 'a' 经过 t 次转换后的长度
//        if (t < 26) return 1;
//
//        long[] dp = new long[t];
//        for (int i = 0; i < 25; i++) {
//            dp[i] = 1;
//        }
//        dp[25] = 2;
//        for (int i = 26; i < t; i++) {
//            dp[i] = dp[i - 26] + dp[i - 25];
//            dp[i] %= mod;
//        }
//        return dp[t - 1];
//    }


}
