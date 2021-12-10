package com.stellagosa.leetcode.leetcode_1005;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 2, -4, -6, -11, -44, 5, 43, 90};
        int sum = largestSumAfterKNegations(nums, 3);
        System.out.println(sum);
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
//        int[] res = Arrays.stream(nums).boxed().sorted((a, b) -> Math.abs(b) - Math.abs(a)).mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        int min = Math.abs(nums[0]);
        int sum = 0;
        for (int value : nums) {
            if (value < 0 && k > 0) {
                sum += -value;
                k--;
            } else {
                sum += value;
            }

            if (Math.abs(value) < min) {
                min = Math.abs(value);
            }
        }

        return (k % 2 == 1) ? sum - 2 * min : sum;
    }
}
// count 负数的个数
// 1. count < k   k-count 偶数  全部数的绝对值的和
// 2. count < k   k-count 奇数  全部数的绝对值和减去最小那个数的绝对值
// 3. count = k  全部数的绝对值的和
// 4. count > k  也就是负数个数多余k个，那么这些负数中绝对值大的变成成正数，再求和

