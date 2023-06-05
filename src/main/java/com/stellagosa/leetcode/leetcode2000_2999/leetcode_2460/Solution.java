package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2460;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/5 上午 08:49
 * @Description: 对数组执行操作
 */
public class Solution {

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        int p = 0, q = 0;
        while (p < nums.length) {
            // 找到第一个0的位置
            while (q < nums.length && nums[q] != 0) {
                q++;
            }
            p = q + 1;
            // 寻找q后面不为0的数
            while (p < nums.length && nums[p] == 0) {
                p++;
            }
            if (p == nums.length || q == nums.length) break;
            int temp = nums[q];
            nums[q] = nums[p];
            nums[p] = temp;
            q++;
        }
        return nums;
    }
}
