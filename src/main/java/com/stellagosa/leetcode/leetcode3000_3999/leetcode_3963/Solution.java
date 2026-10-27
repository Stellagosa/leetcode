package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3963;

/**
 * @author Stellagosa
 * @description 3963.构造恰好一条路径的网络
 * @date 10/27/2026 2:40 PM Tuesday
 */
public class Solution {

    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        ans[0] = ".".repeat(n);
        if (n == 1) {
            for (int i = 1; i < m; i++) {
                ans[i] = ".";
            }
        } else {
            for (int i = 1; i < m; i++) {
                ans[i] = "#".repeat(n - 1) + ".";
            }
        }
        return ans;
    }


}
