package com.stellagosa.leetcode.leetcode100_999.leetcode_275;

/**
 * @author Stellagosa
 * @description H指数Ⅱ
 * @date 2023/10/30 19:32 星期一
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] citations = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] citations = {0, 0, 4, 4};
        System.out.println(solution.hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations[0] > n) return n;
        if (citations[n - 1] <= 0) return 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return n - left;
    }

}
