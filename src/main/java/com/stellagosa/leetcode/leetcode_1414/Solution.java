package com.stellagosa.leetcode.leetcode_1414;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/3 20:40
 * @Description: 和为K的最少斐波那契数字数目
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(10));
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        while (nums.get(nums.size() - 1) < k) {
            nums.add(nums.get(nums.size() - 1) + nums.get(nums.size() - 2));
        }
        if (nums.get(nums.size() - 1) == k) return 1;

        int res = 0;
        int index = nums.size() - 1;
        while (index >= 0 && k > 0) {
            if (k >= nums.get(index)) {
                k -= nums.get(index);
                res++;
            }
            index--;
        }
        return res;
    }
}
