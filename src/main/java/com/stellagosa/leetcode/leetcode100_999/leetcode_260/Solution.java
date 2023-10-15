package com.stellagosa.leetcode.leetcode100_999.leetcode_260;

/**
 * @author Stellagosa
 * @description 只出现一次的数字Ⅲ
 * @date 2023/10/16 5:19 星期一
 */
public class Solution {

    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        temp &= -temp;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & temp) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    // public int[] singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         if (set.contains(num)) {
    //             set.remove(num);
    //         } else {
    //             set.add(num);
    //         }
    //     }
    //     int n = set.size();
    //     int[] result = new int[n];
    //     Iterator<Integer> iterator = set.iterator();
    //     for (int i = 0; i < n; ++i) {
    //         result[i] = iterator.next();
    //     }
    //     return result;
    // }

}
