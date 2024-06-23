package com.stellagosa.leetcode.leetcode100_999.leetcode_520;

/**
 * @author Stellagosa
 * @description 检测大写字母
 * @date 2024/6/23 9:10 星期日
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            if (flag == 0 && chars[i] >= 'A' && chars[i] <= 'Z') {
                flag = 1;
            } else if (flag == 0 && chars[i] >= 'a' && chars[i] <= 'z') {
                flag = 2;
            } else if (flag == 1 && chars[i] >= 'A' && chars[i] <= 'Z') {
                flag = 3;
            } else if (flag == 1 && chars[i] >= 'a' && chars[i] <= 'z') {
                flag = 2;
            } else if (flag == 2 && chars[i] >= 'A' && chars[i] <= 'Z') {
                return false;
            } else if (flag == 2 && chars[i] >= 'a' && chars[i] <= 'z') {
                flag = 2;
            } else if (flag == 3 && chars[i] >= 'A' && chars[i] <= 'Z') {
                flag = 3;
            } else if (flag == 3 && chars[i] >= 'a' && chars[i] <= 'z') {
                return false;
            }
        }
        return true;
    }

}
