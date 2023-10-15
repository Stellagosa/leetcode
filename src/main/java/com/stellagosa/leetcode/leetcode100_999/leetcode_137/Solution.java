package com.stellagosa.leetcode.leetcode100_999.leetcode_137;

/**
 * @author Stellagosa
 * @description 只出现一次的数字Ⅱ
 * @date 2023/10/15 8:10 星期日
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    // public int singleNumber(int[] nums) {
    //     int result = 0;
    //     for (int i = 0; i < 32; ++i) {
    //         int temp = 0;
    //         for (int num : nums) {
    //             temp += (num >> i) & 1;
    //         }
    //         result |= (temp % 3) << i;
    //     }
    //     return result;
    // }

    // public int singleNumber(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.merge(num, 1, Integer::sum);
    //     }
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (entry.getValue() == 1) return entry.getKey();
    //     }
    //     return 0;
    // }

}
