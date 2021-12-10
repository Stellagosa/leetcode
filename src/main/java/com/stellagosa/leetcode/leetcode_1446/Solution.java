package com.stellagosa.leetcode.leetcode_1446;

/**
 * 同一种字符组成的最长子字符串的长度
 *
 * @Author: Stellagosa
 * @Date: 2021/12/6 12:59
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aaasssjjjjjiiiwwwooooooosssssssaaaaaaiiiiiiiiddddddduuuuuuuuuuuuuu";
        System.out.println(maxPower(s));
    }

    /**
     * 时间： 100%
     * 空间： 99.63%
     *
     * @param s 字符串
     * @return 相同字符的子字符串的最大长度
     */
    public static int maxPower(String s) {
        int max = 1;
        char preCh = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == preCh) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
                preCh = cur;
            }
        }
        return Math.max(max, count);
    }


//    public static int maxPower(String s) {
//        int max = 0;
//        int pre = 0;
//        char preCh = ' ';
//        for (int i = 0; i < s.length(); i++) {
//            char cur = s.charAt(i);
//            if (cur != preCh) {
//                max = Math.max(i - pre, max);
//                preCh = cur;
//                pre = i;
//            }
//        }
//        // 最后一个子字符串长度
//        max = Math.max(s.length() - pre, max);
//        return max;
//    }
}
