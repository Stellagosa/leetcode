package com.stellagosa.leetcode.leetcode100_999.leetcode_396;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/4/22 9:23
 * @Description: 旋转数组
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction(nums));
    }

    // F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
    // F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
    // F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
    // F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
    // F(1)相对于F(0)来说，前面三个数4，3，2分别多了一个，少了一个3*6
    // F(2)相对于F(1)来说，前面三个数6，4，3分别多了一个，少了一个3*2
    // F(3)类似
    // F(0) = 0*nums[0]+1*nums[1]+2*nums[2]+...+(n-2)*nums[n-2]+(n-1)*nums[n-1]
    // F(1) = 1*nums[0]+2*nums[1]+3*nums[2]+...+(n-1)*nums[n-2]+0*nums[n-1]
    // F(1)-F(0) = nums[0]+ nums[1]+...+nums[n-2]-(n-1)*nums[n-1]
    // S = sum(nums)
    // F(1)-F(0) = S-n*nums[n-1]
    // F(2)-F(1) = S-n*nums[n-2]
    // F(k)-F(k-1) = S-n*nums[n-k]

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f0 = 0;
        for (int i = 0; i < n; i++) {
            f0 += i * nums[i];
            sum += nums[i];
        }
        int max = f0;
        for (int i = 1; i < n; i++) {
            int fi = f0 + sum - n * nums[n - i];
            max = Math.max(fi, max);
            f0 = fi;
        }
        return max;
    }


    // 超时
    // public int maxRotateFunction(int[] nums) {
    //     int n = nums.length;
    //     int max = Integer.MIN_VALUE;
    //
    //     for (int i = 0; i < n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < n; j++) {
    //             count += nums[j] * ((i + j) % n);
    //         }
    //         max = Math.max(count, max);
    //     }
    //     return max;
    // }
}
