package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2300;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 咒语和药水的成功对数
 * @date 2023/11/10 16:45 星期五
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        int[] result = solution.successfulPairs(spells, potions, 16L);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = search(potions, spells[i], success);
        }
        return result;
    }

    public int search(int[] arrays, int target, long success) {
        int left = 0, right = arrays.length - 1;
        if ((long) arrays[left] * target >= success) return arrays.length;
        if ((long) arrays[right] * target < success) return 0;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((long) arrays[mid] * target < success) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arrays.length - left;
    }

}
