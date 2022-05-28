package com.stellagosa.leetcode.leetcode100_999.leetcode_468;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/29 6:51
 * @Description: 验证IP地址
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.length() < 7 || queryIP.length() > 39) return "Neither";
        char ch = queryIP.charAt(queryIP.length() - 1);
        if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) return "Neither";
        ch = queryIP.charAt(0);
        if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) return "Neither";
        String[] split = queryIP.split("\\.");
        if (split.length == 4) {
            for (String s : split) {
                if (s.length() == 0 || s.length() > 3) return "Neither";
                for (int j = 0; j < s.length(); j++) {
                    ch = s.charAt(j);
                    if (ch < '0' || ch > '9') return "Neither";
                }
                if (s.length() != 1 && s.charAt(0) == '0') return "Neither";
                int x = Integer.parseInt(s);
                if (x < 0 || x > 255) return "Neither";
            }
            return "IPv4";
        } else if (split.length == 1) {
            split = queryIP.split(":");
            if (split.length != 8) return "Neither";
            for (int i = 0; i < 8; i++) {
                if (split[i].length() == 0 || split[i].length() > 4) return "Neither";
                for (int j = 0; j < split[i].length(); j++) {
                    ch = split[i].charAt(j);
                    if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')))
                        return "Neither";
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
