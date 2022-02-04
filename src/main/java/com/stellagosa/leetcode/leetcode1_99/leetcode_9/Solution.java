package com.stellagosa.leetcode.leetcode1_99.leetcode_9;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/3 21:05
 * @Description: 回文数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(11));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }

    // public boolean isPalindrome(int x) {
    //     if (x < 0) return false;
    //     StringBuilder builder = new StringBuilder();
    //     builder.append(x);
    //     StringBuilder reverse = builder.reverse();
    //     return String.valueOf(x).equals(reverse.toString());
    // }
}
