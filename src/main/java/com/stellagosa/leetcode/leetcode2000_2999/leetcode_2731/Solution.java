package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2731;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 移动机器人
 * @date 2023/10/10 7:59 星期二
 */
public class Solution {

    /**
     * 对于 pos[i]，小于 pos[i] 的数有 i 个，大于 pos[i] 的有 n-i-1 个，
     * 对于结果集来说，小于 pos[i] 的数，pos[i] 提供的影响是 pos[i],
     * 大于 pos[i] 的数，pos[i] 提供的影响是 -pos[i]。
     * 所以 pos[i] 提供的总影响为 i*pos[i]-(n-i-1)*pos[i]，即 (2*i-n+1)*pos[i]
     * <p>
     * 对 left 和 right 两个点，left+right=n-1，则两个点的总影响度为 (right-left)*(pos[right]-pos[left])。
     * 对于 n 为奇数，则位于最中间的点的影响度为 0，因为大于这个点和小于这个点的点的个数相同
     */
    public int sumDistance(int[] nums, String s, int d) {
        int mod = 1000000007;
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; ++i) {
            pos[i] = (long) nums[i] + (s.charAt(i) == 'R' ? d : -d);
        }

        long result = 0L;
        Arrays.sort(pos);
        // for (int i = 0; i < n; ++i) {
        //     result += (2L * i - n + 1) * pos[i];
        //     result %= mod;
        // }
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            result += (right - left) * (pos[right] - pos[left]);
            result %= mod;
        }
        return (int) result;
    }

    // public int sumDistance(int[] nums, String s, int d) {
    //     int mod = 1000000007;
    //     int n = nums.length;
    //     long[] pos = new long[n];
    //     for (int i = 0; i < n; ++i) {
    //         pos[i] = (long) nums[i] + (s.charAt(i) == 'R' ? d : -d);
    //     }
    //
    //     long result = 0L;
    //     Arrays.sort(pos);
    //     for (int i = 1; i < n; ++i) {
    //         result += (pos[i] - pos[i - 1]) * i % mod * (n - i);
    //         result %= mod;
    //     }
    //     return (int) result;
    // }

    // 超时
    // public int sumDistance(int[] nums, String s, int d) {
    //     int mod = 1000000007;
    //     int n = nums.length;
    //     d %= mod;
    //     for (int i = 0; i < n; ++i) {
    //         char ch = s.charAt(i);
    //         if (ch == 'R') {
    //             nums[i] = ((nums[i] % mod) + d) % mod;
    //         } else {
    //             nums[i] = ((nums[i] % mod) - d) % mod;
    //         }
    //     }
    //
    //     int result = 0;
    //     for (int i = 0; i < n; ++i) {
    //         for (int j = i + 1; j < n; ++j) {
    //             int dis = Math.abs(nums[i] - nums[j]) % mod;
    //             result = (result + dis) % mod;
    //         }
    //     }
    //     return result;
    // }

}
