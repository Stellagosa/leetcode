package com.stellagosa.leetcode.leetcode100_999.leetcode_875;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/7 11:12
 * @Description: 爱吃香蕉的珂珂
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {312884470};
        System.out.println(solution.minEatingSpeed(arr, 968709470));
    }

    // TAG 二分查找
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = (left + right) / 2;
            int times = eatBananaTimes(piles, mid);
            if (times > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int eatBananaTimes(int[] piles, int k) {
        if (k == 0) return Integer.MAX_VALUE;
        int count = 0;
        for (int pile : piles) {
            // count += pile % k == 0 ? pile / k : (pile / k) + 1;
            count += ((pile - 1) / k) + 1;
        }
        return count;
    }
}
