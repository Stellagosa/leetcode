package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3038;

/**
 * @author Stellagosa
 * @description 相同分数的最大操作数目Ⅰ
 * @date 2024/6/7 20:14 星期五
 */
public class Solution {

    public int maxOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] + nums[i - 1] != nums[0] + nums[1]) {
                break;
            }
            count++;
        }
        return count;
    }

    // public int maxOperations(int[] nums) {
    //     int i = 0, count = 0;
    //     while (i < nums.length - 1) {
    //         if (nums[i] + nums[i + 1] != nums[0] + nums[1]) {
    //             break;
    //         }
    //         i += 2;
    //         count++;
    //     }
    //     return count;
    // }

    // public int maxOperations(int[] nums) {
    //     int i = 2, len = nums.length;
    //     if (len < 2) return 0;
    //     int count = 1;
    //     int sum = nums[0] + nums[1];
    //     while (i < len - 1) {
    //         if (nums[i] + nums[i + 1] != sum) {
    //             break;
    //         }
    //         count++;
    //         i += 2;
    //     }
    //     return count;
    // }

}
