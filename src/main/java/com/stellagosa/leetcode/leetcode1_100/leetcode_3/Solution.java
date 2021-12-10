package com.stellagosa.leetcode.leetcode1_100.leetcode_3;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:17
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("ababcbababab");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int start = 0;
        int end = 0;
        while (start < chars.length && end < chars.length) {
            boolean check = check(chars, start, end);
            if (check) {
                end++;
                max = Math.max(max, (end - start));
            } else {
                start++;
            }
        }
        return max;
    }

    private boolean check(char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }
        return true;
    }

//    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        int max = 0;
//        int i = 0;
//        int j = 0;
//        while (i < chars.length && j < chars.length) {
//            boolean check = check(chars, i, j);
//            if (check) {
//                j++;
//                max = Math.max(max, (j - i));
//            } else {
//                i++;
//            }
//        }
//        return max;
//    }

//    /**
//     * 检查是否有重复字符
//     *
//     * @param chars 完整的字符串
//     * @param start 需要检查的字符串开始位置
//     * @param end   需要检查的字符串的结束位置
//     * @return 有重复字符返回 false, 否则返回 true
//     */
//    private boolean check(char[] chars, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i <= end; i++) {
//            if (set.contains(chars[i])) {
//                return false;
//            }
//            set.add(chars[i]);
//        }
//        return true;
//    }

}
