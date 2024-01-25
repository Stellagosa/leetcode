package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2859;

import java.util.List;

/**
 * @author Stellagosa
 * @description 计算K置位下标对应元素的和
 * @date 2024/1/25 13:16 星期四
 */
public class Solution {

    public int sumIndicesWithSetBits(List<Integer> nums, int k) {
        int[] temp = {0, 0b1, 0b11, 0b111, 0b1111, 0b1_1111, 0b11_1111,
                0b111_1111, 0b1111_1111, 0b1_1111_1111, 0b11_1111_1111};

        int result = 0;
        for (int i = temp[k]; i < nums.size(); i++) {
            int j = i;
            int cnt = 0;
            while (j > 0) {
                j &= j - 1;
                cnt++;
            }
            if (cnt == k) {
                result += nums.get(i);
            }
        }
        return result;
    }


}
