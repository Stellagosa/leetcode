package com.stellagosa.leetcode.leetcode1_100.leetcode_28;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:29
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int location = solution.strStr("ab", "ab");
        System.out.println(location);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean decide = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.toCharArray()[i + j] != needle.toCharArray()[j]) {
                    decide = false;
                    break;
                }
            }
            if (decide) return i;
        }
        return -1;
    }

//    public int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//        if (haystack.length() < needle.length()) return -1;
//
//        char[] chars = haystack.toCharArray();
//        char[] array = needle.toCharArray();
//        int len = chars.length - array.length + 1;
//        int arrayLength = array.length;
//        for (int i = 0; i < len; i++) {
//            boolean decide = true;
//            for (int j = 0; j < arrayLength; j++) {
//                if (chars[i + j] != array[j]) {
//                    decide = false;
//                    break;
//                }
//            }
//            if (decide) return i;
//        }
//        return -1;
//    }


//    public int strStr(String haystack, String needle) {
//        int end = haystack.length() - needle.length();
//        for (int i = 0; i <= end; i++) {
//            boolean decide = true;
//            for (int j = 0; j < needle.length(); j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j)) {
//                    decide = false;
//                    break;
//                }
//            }
//            if (decide) return i;
//        }
//        return -1;
//    }
}
