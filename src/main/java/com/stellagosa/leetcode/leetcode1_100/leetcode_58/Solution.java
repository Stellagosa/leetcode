package com.stellagosa.leetcode.leetcode1_100.leetcode_58;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/3 21:24
 * @Description: 最后一个单词的长度
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("abcdaee as  "));
    }

    // 调用函数
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    // 反向遍历
    // public int lengthOfLastWord(String s) {
    //     char[] array = s.toCharArray();
    //     int index = array.length - 1;
    //     while (index >= 0 && array[index] == ' ') {
    //         index--;
    //     }
    //
    //     if (index < 0) return 0;
    //     int cur = index;
    //
    //     while (index >= 0 && array[index] != ' ') {
    //         index--;
    //     }
    //     return cur - index;
    // }

    // 正向遍历
    // public int lengthOfLastWord(String s) {
    //     char[] array = s.toCharArray();
    //     boolean isBegin = false;
    //     int pre = 0;
    //     int cur = 0;
    //     int length = 0;
    //     for (int i = 0; i < array.length; i++) {
    //         if (array[i] == ' ') {
    //             if (isBegin) {
    //                 length = cur - pre + 1;
    //                 isBegin = false;
    //             }
    //         } else {
    //             if (!isBegin) {
    //                 isBegin = true;
    //                 pre = i;
    //             }
    //             cur = i;
    //         }
    //     }
    //
    //     if (isBegin) {
    //         length = cur - pre + 1;
    //     }
    //
    //     return length;
    // }
}














