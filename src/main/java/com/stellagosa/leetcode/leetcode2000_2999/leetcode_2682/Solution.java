package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2682;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/16 7:49
 * @Description: 找出转圈游戏输家
 */
public class Solution {

    public int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        int index = 0;
        int time = 1;
        while (true) {
            arr[index]++;
            if (arr[index] == 2) break;
            index = (index + time * k) % n;
            time++;
        }
        int count = 0;
        for (int i : arr) {
            if (i == 0) count++;
        }
        int[] result = new int[count];

        for (int pos = 0, j = 0; pos < n && j < count; pos++) {
            if (arr[pos] == 0) {
                result[j] = pos + 1;
                j++;
            }
        }
        return result;
    }
}
