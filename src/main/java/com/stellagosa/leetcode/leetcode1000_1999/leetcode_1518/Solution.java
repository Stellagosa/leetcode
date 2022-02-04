package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1518;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/17 11:39
 * @Description: 换酒问题
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(5, 5));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (true) {
            int pre = numBottles / numExchange; // 可以换的新酒
            int cur = numBottles % numExchange; // 剩余空酒瓶
            if (pre == 0) {
                break;
            } else {
                count += pre;
                numBottles = cur + pre;
            }
        }
        return count;
    }
}
