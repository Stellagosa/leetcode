package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2734;

/**
 * @author Stellagosa
 * @description 执行子串操作后的字典序最小字符串
 * @date 2024/6/27 11:39 星期四
 */
public class Solution {

    public String smallestString(String s) {
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' && !flag) {
                builder.append('a');
                continue;
            }
            if (chars[i] == 'a' && flag) {
                builder.append(s.substring(i));
                break;
            }
            builder.append((char) (chars[i] - 1));
            flag = true;
        }
        if (!flag) builder.setCharAt(builder.length() - 1, 'z');
        return builder.toString();
    }

}
