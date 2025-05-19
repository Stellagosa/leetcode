package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3024;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 三角形类型
 * @date 2025/5/19 16:14 星期一
 */
public class Solution {

    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) return "none";
        if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
        if (nums[0] == nums[1] || nums[1] == nums[2]) return "isosceles";
        return "scalene";
    }
}
