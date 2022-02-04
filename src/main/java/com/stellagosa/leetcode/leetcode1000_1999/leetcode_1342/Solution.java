package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1342;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/31 10:11
 * @Description: 将数字变成0的操作次数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
    }

    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        if (num % 2 == 0) return numberOfSteps(num / 2) + 1;
        else return numberOfSteps(num - 1) + 1;
    }
}
