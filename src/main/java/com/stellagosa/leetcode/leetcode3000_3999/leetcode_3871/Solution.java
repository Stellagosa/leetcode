package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3871;

/**
 * @author Stellagosa
 * @description 3871.统计范围内的逗号Ⅱ
 * @date 9/9/2026 6:32 AM Wednesday
 */
public class Solution {

    public long countCommas(long n)
    {
        if (n < 1_000L)
        {
            return 0L;
        }
        if (n < 1_000_000L)
        {
            return n - 999L;
        }
        if (n < 1_000_000_000L)
        {
            return 2 * (n - 999_999L) + 999_000L;
        }
        if (n < 1_000_000_000_000L)
        {
            return 3 * (n - 999_999_999L) + 2 * (999_999_999L - 999_999L) + 999_000L;
        }
        if (n < 1_000_000_000_000_000L)
        {
            return 4 * (n - 999_999_999_999L) + 3 * (999_999_999_999L - 999_999_999L) + 2 * (999_999_999L - 999_999L) + 999_000L;
        }
        return 5 * (n - 999_999_999_999_999L) + 4 * (999_999_999_999_999L - 999_999_999_999L) + 3 * (999_999_999_999L - 999_999_999L) + 2 * (999_999_999L - 999_999L) + 999_000L;
    }

}
