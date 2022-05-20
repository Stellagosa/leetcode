package com.stellagosa.leetcode.leetcode100_999.leetcode_367;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/20 13:37
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        int begin = 1;
        while (num > 0) {
            num -= begin;
            begin += 2;
        }
        return num == 0;
    }

    // public boolean isPerfectSquare(int num) {
    //     int begin = 1;
    //     long count = 0;
    //     while (count < num) {
    //         count += begin;
    //         begin += 2;
    //     }
    //     return count == num;
    // }

    // public boolean isPerfectSquare(int num) {
    //     int left = 0, right = num;
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         long res = (long) mid * mid;
    //         if (res == num) return true;
    //         else if (res > num) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return false;
    // }
}
