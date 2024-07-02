package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2710;

/**
 * @author Stellagosa
 * @description 移除字符串中的尾随零
 * @date 2024/6/29 22:47 星期六
 */
public class Solution {

    public String removeTrailingZeros(String num) {
        char[] chars = num.toCharArray();
        int index = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                index = i;
                break;
            }
        }
        return num.substring(0, index + 1);
    }

    // public String removeTrailingZeros(String num) {
    //     StringBuilder builder = new StringBuilder();
    //     char[] chars = num.toCharArray();
    //     boolean flag = false;
    //     for (int i = chars.length - 1; i >= 0; i--) {
    //         if (!flag && chars[i] == '0') {
    //             continue;
    //         } else if (!flag && chars[i] != '0') {
    //             builder.append(chars[i]);
    //             flag = true;
    //         } else {
    //             builder.append(chars[i]);
    //         }
    //     }
    //     return builder.reverse().toString();
    // }

}
