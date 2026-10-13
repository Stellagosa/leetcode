package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3727;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 3727.最大交替平方和
 * @date 10/13/2026 8:01 PM Tuesday
 */
public class Solution {

    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans -= nums[i];
        }
        for (int i = nums.length / 2; i < nums.length; i++) {
            ans += nums[i];
        }
        return ans;
    }

    // public long maxAlternatingSum(int[] nums) {
    //     int[] array = Arrays.stream(nums).boxed()
    //             .sorted(Comparator.comparing(Math::abs))
    //             .mapToInt(Integer::intValue)
    //             .toArray();
    //
    //     long ans = 0;
    //     for (int i = 0; i < array.length / 2; i++) {
    //         ans -= (long) array[i] * array[i];
    //     }
    //     for (int i = array.length / 2; i < array.length; i++) {
    //         ans += (long) array[i] * array[i];
    //     }
    //     return ans;
    // }

}
