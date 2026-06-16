package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3612;

/**
 * @author Stellagosa
 * @description 用特殊操作处理字符串Ⅰ
 * @date 6/16/2026 9:47 PM June
 */
public class Solution {

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >='a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch == '*') {
                if (!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (ch == '#') {
                sb.append(sb);
            } else if (ch == '%') {
                sb.reverse();
            }
        }
        return sb.toString();
    }


}
