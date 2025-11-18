package com.stellagosa.leetcode.leetcode100_999.leetcode_717;

/**
 * @author Stellagosa
 * @description 1比特与2比特字符
 * @date 2025/11/18 10:42 星期二
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (bits[len - 1] == 1) return false;
        int i = 0;
        while (i < len) {
            if (i == len - 1) return true;
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return false;
    }

}
