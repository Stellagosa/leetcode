package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1170;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/10 上午 08:31
 * @Description: 比较字符串最小字母出现频次
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] queries = {
                "wonrzb", "crmgpa", "pjesvvwfzp", "xkrs", "aryfywxpn", "cz", "g", "h", "iqqyow", "bzxm",
                "nowayui", "qibsarionn", "cfvfiuifot", "wg", "ofms", "ewfnwlil", "kwxmhrllu", "vfzmnpy", "jqrcfe", "mfmwjs",
        };
        String[] words = {
                "gtwhaesaeo", "vhgfajicc", "kajawvcuwd", "bkiprvch", "hzngiikrh", "mvdentgx", "lrlcqczqbi", "werveeven", "h", "z", "zz"
        };
        int[] result = solution.numSmallerByFrequency(queries, words);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 每个字符串最长10个字符，所有最小字符出现频次最多也就10次
        int[] minCharCount = new int[12];
        for (String word : words) {
            minCharCount[minCharCount(word)]++;
        }

        // 后缀和
        for (int i = 9; i >= 0; i--) {
            minCharCount[i] += minCharCount[i + 1];
        }

        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int count = minCharCount(queries[i]);
            result[i] = minCharCount[count + 1];
        }
        return result;
    }

    private int minCharCount(String str) {
        char minChar = 'z';
        int minCharNum = 0;
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            if (ch < minChar) {
                minChar = ch;
                minCharNum = 1;
            } else if (ch == minChar) {
                minCharNum++;
            }
        }
        return minCharNum;
    }


    // public int[] numSmallerByFrequency(String[] queries, String[] words) {
    //     int[] arr1 = minCharCount(queries);
    //     int[] arr2 = minCharCount(words);
    //     int m = queries.length;
    //     int[] result = new int[m];
    //     Arrays.sort(arr2);
    //
    //     for (int i = 0; i < m; i++) {
    //         result[i] = search(arr2, arr1[i]);
    //     }
    //     return result;
    // }
    //
    // /**
    //  * 查找有序数组中小于num的数的个数
    //  *
    //  * @param arr 递增有序数组
    //  * @param num 待查数
    //  * @return 数组中的位置
    //  */
    // private int search(int[] arr, int num) {
    //     int left = 0, right = arr.length - 1;
    //
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         if (arr[mid] > num) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return arr.length - left;
    // }
    //
    // /**
    //  * 返回字符串数组中，每个字符串中最小字母出现频次
    //  *
    //  * @param arr 待处理字符串
    //  * @return 字符串中最小字符出现频次
    //  */
    // private int[] minCharCount(String[] arr) {
    //     int m = arr.length;
    //     int[] result = new int[m];
    //
    //     for (int i = 0; i < m; i++) {
    //         char minChar = 'z';
    //         int minCharNum = 0;
    //         for (int j = 0; j < arr[i].length(); j++) {
    //             char ch = arr[i].charAt(j);
    //             if (ch < minChar) {
    //                 minChar = ch;
    //                 minCharNum = 1;
    //             } else if (ch == minChar) {
    //                 minCharNum++;
    //             }
    //         }
    //         result[i] = minCharNum;
    //     }
    //     return result;
    // }
}
