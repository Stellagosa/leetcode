package com.stellagosa.leetcode.leetcode_1816;

/**
 * 一条句子，截断前k个单词，单词之间都是空格分割
 *
 * @Author: Stellagosa
 * @Date: 2021/12/6 10:17
 */
public class Solution {

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        String res = truncateSentence(s, 4);
        System.out.println(res);
    }


    /**
     * 时间：100%
     * 空间：99.76%
     * @param s 句子
     * @param k 前k个单词
     * @return 前k个单词的句子
     */
    public static String truncateSentence(String s, int k) {
        return s.substring(0, lockLocation(s, k));
    }

    public static int lockLocation(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                k--;
            }
            if (k <= 0) return i;
        }
        return s.length();
    }

//    public static String truncateSentence(String s, int k) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch == ' ') {
//                k--;
//            }
//            if(k > 0) {
//                builder.append(ch);
//            } else {
//                break;
//            }
//        }
//        return builder.toString();
//    }

//    public static String truncateSentence(String s, int k) {
//        String[] strings = s.split(" ");
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < k && i < strings.length; i++) {
//            builder.append(strings[i]).append(" ");
//        }
//        builder.deleteCharAt(builder.length() - 1);
//        return builder.toString();
//    }
}
