package com.stellagosa.leetcode.leetcode100_999.leetcode_868;

/**
 * @Author: Stellagosa
 * @Date: 2022/4/24 7:59
 * @Description: 二进制间距
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(22));
    }

    public int binaryGap(int n) {
        int max = 0;
        int pre = -1;
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    max = Math.max(max, index - pre);
                }
                pre = index;
            }
            n = n >> 1;
            index++;
        }
        return max;
    }
}
