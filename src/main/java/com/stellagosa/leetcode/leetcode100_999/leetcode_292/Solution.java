package com.stellagosa.leetcode.leetcode100_999.leetcode_292;

/**
 * @author Stellagosa
 * @description Nim 游戏
 * @date 2024/2/4 10:58 星期日
 */
public class Solution {

    public boolean canWinNum(int n) {
        return (n & 3) != 0;
    }

    // public boolean canWinNim(int n) {
    //     return n % 4 != 0;
    // }

}
