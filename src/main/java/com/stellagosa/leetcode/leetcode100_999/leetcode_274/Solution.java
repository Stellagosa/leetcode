package com.stellagosa.leetcode.leetcode100_999.leetcode_274;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description H指数
 * @date 2023/10/29 7:41 星期日
 */
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counts[n]++;
            } else {
                counts[citation]++;
            }
        }

        int cnt = 0;
        for (int i = n; i >= 0; --i) {
            cnt += counts[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }

    // public int hIndex(int[] citations) {
    //     Arrays.sort(citations);
    //     int h = 0;
    //     for (int i = 0; i < citations.length; ++i) {
    //         if (citations[i] > h && citations.length - i > h) {
    //             h = Math.min(citations[i], citations.length - i);
    //         } else {
    //             break;
    //         }
    //     }
    //     return h;
    // }

}
