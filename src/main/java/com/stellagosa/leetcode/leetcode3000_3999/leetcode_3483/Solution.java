package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3483;

/**
 * @author Stellagosa
 * @description 3483.不同三位偶数的数目
 * @date 9/11/2026 8:09 PM Friday
 */
public class Solution {

    public int totalNumber(int[] digits) {
        boolean[] flags = new boolean[1000];
        int ans = 0;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] % 2 != 0) continue;
                    if (flags[digits[i] * 100 + digits[j] * 10 + digits[k]]) continue;
                    flags[digits[i] * 100 + digits[j] * 10 + digits[k]] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
