package com.stellagosa.leetcode.leetcode100_999.leetcode_668;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/18 14:49
 * @Description: 乘法表中第k小的数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(10, 10, 28));
    }

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = (mid / n) * n;
            for (int i = (mid / n) + 1; i <= m; i++) {
                count += mid / i;
            }
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
