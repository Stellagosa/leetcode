package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2744;

/**
 * @author Stellagosa
 * @description 最大字符串配对数目
 * @date 2024/1/17 6:35 星期三
 */
public class Solution {

    // 测试示例字符串长度为2，不用麻烦反转字符串
    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    result++;
                }
            }
        }
        return result;
    }

    // public int maximumNumberOfStringPairs(String[] words) {
    //     Set<String> set = new HashSet<>();
    //     int result = 0;
    //     for (String word : words) {
    //         char[] chars = word.toCharArray();
    //         int left = 0, right = chars.length - 1;
    //         while (left < right) {
    //             char temp = chars[left];
    //             chars[left] = chars[right];
    //             chars[right] = temp;
    //             left++;
    //             right--;
    //         }
    //         String reverseString = String.valueOf(chars);
    //         if (set.contains(reverseString)) {
    //             result++;
    //             set.remove(reverseString);
    //         } else {
    //             set.add(word);
    //         }
    //     }
    //     return result;
    // }
}
