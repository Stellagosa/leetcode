package com.stellagosa.leetcode.leetcode1_99.leetcode_6;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:20
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String convert = solution.convert("adasdasd", 1);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < numRows; i++) {
            int loc1 = i;
            int loc2 = 2 * numRows - i - 2;
            int k = 2 * numRows - 2;

            if (loc2 != loc1 && loc2 - loc1 < k) {
                while (loc1 < n || loc2 < n) {
                    if (loc1 < n) {
                        builder.append(s.charAt(loc1));
                        loc1 += k;
                    }
                    if (loc2 < n) {
                        builder.append(s.charAt(loc2));
                        loc2 += k;
                    }
                }
            } else {
                while (loc1 < n) {
                    builder.append(s.charAt(loc1));
                    loc1 += k;
                }
            }
        }
        return builder.toString();
    }
}
