package com.stellagosa.leetcode.leetcode100_999.leetcode_605;

/**
 * @author Stellagosa
 * @description 种花问题
 * @date 2023/9/29 7:44 星期五
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
                i++;
            }
        }
        return n <= 0;
    }

    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     int i = 0, len = flowerbed.length;
    //     while (i < len) {
    //         if (flowerbed[i] == 1) {
    //             i += 2;
    //         } else {
    //             if (i == len - 1 || flowerbed[i + 1] == 0) {
    //                 n--;
    //                 flowerbed[i] = 1;
    //                 i += 2;
    //             } else {
    //                 i++;
    //             }
    //         }
    //     }
    //     return n <= 0;
    // }

    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     for (int i = 0; i < flowerbed.length; i++) {
    //         if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
    //             n--;
    //             flowerbed[i] = 1;
    //         }
    //     }
    //     return n <= 0;
    // }

    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     if (flowerbed.length == 1) {
    //         return (flowerbed[0] == 0 && n <= 1) || (flowerbed[0] == 1 && n == 0);
    //     }
    //     int cnt = 0;
    //
    //     int i = 0, len = flowerbed.length;
    //
    //     while (i < len) {
    //         if (flowerbed[i] == 1) {
    //             i += 2;
    //             continue;
    //         }
    //
    //         if (i == 0) {
    //             if (flowerbed[i + 1] == 0) {
    //                 flowerbed[i] = 1;
    //                 cnt++;
    //                 i += 2;
    //             } else {
    //                 i += 3;
    //             }
    //             continue;
    //         }
    //
    //         if (i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
    //             flowerbed[i] = 1;
    //             cnt++;
    //             i += 2;
    //             continue;
    //         }
    //
    //         if (i == len - 1 && flowerbed[i - 1] == 0) {
    //             flowerbed[i] = 1;
    //             cnt++;
    //             break;
    //         }
    //         i++;
    //     }
    //     return cnt >= n;
    // }

}
