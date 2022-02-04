package com.stellagosa.leetcode.leetcode100_999.leetcode_689;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 7:06
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 2, 2, 2, 4};
        int[] res = maxSumOfThreeSubarrays(nums, 2);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        int sum1 = 0, max1 = 0, max1Idx1 = 0;
        int sum2 = 0, max12 = 0, max12Idx1 = 0, max12Idx2 = 0;
        int sum3 = 0, max123 = 0;

        for (int i = 2 * k; i < nums.length; i++) {
            sum1 += nums[i - 2 * k];
            sum2 += nums[i - k];
            sum3 += nums[i];

            if (i >= 3 * k - 1) {
                if (sum1 > max1) {
                    max1 = sum1;
                    max1Idx1 = i - 3 * k + 1;
                }
                if (max1 + sum2 > max12) {
                    max12 = max1 + sum2;
                    max12Idx1 = max1Idx1;
                    max12Idx2 = i - 2 * k + 1;
                }
                if (max12 + sum3 > max123) {
                    max123 = max12 + sum3;
                    res[0] = max12Idx1;
                    res[1] = max12Idx2;
                    res[2] = i - k + 1;
                }
                sum1 -= nums[i - 3 * k + 1];
                sum2 -= nums[i - 2 * k + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return res;
    }


//    private static int max;
//    private static int maxP;
//    private static int maxQ;
//    private static int maxR;
//
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 2, 2, 2, 2, 2};
//        int[] res = maxSumOfThreeSubarrays(nums, 2);
//        for (int re : res) {
//            System.out.println(re);
//        }
//    }
//
//    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        // 记录从key开始的长度为k的子数组的和
//        Map<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//
//        int count = 0;
//        for (int i = 0; i < k; i++) {
//            count += nums[i];
//        }
//        map.put(0, count);
//
//        for (int i = 1; i <= n - k; i++) {
//            count -= nums[i - 1];
//            count += nums[i + k - 1];
//            map.put(i, count);
//        }
//
//        int p = 0;
//        int q = p + k;
//        int r = q + k;
//
//        maxP = p;
//        maxQ = q;
//        maxR = r;
//        max = 0;
//        for (int i = 0; i <= n - 3 * k; i++) {
//            for (int j = 0; j <= n - 2 * k; j++) {
//                for (int l = 0; l <= n - k; l++) {
//                    check(map, i, j, l, k, n);
//                }
//            }
//        }
//        return new int[]{maxP, maxQ, maxR};
//    }
//
//    private static void check(Map<Integer, Integer> map, int p, int q, int r, int k, int n) {
//        if (q - p >= k && r - q >= k && r <= n - k) {
//            int count = map.get(p) + map.get(q) + map.get(r);
//            if (count > max) {
//                max = count;
//                maxP = p;
//                maxQ = q;
//                maxR = r;
//            }
//
//        }
//    }
}
