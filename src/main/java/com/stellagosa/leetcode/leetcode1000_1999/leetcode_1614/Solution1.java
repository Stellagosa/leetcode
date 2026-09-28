package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1614;

/**
 * @author Stellagosa
 * @description 1614.括号的最大嵌套深度
 * @date 9/28/2026 10:20 AM Monday
 */
public class Solution1 {


    public int maxDepth(String s) {
        int ans = 0;
        int cur = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cur++;
                ans = Math.max(ans, cur);
            } else if (ch == ')') {
                cur--;
            }
        }
        return ans;
    }
}
