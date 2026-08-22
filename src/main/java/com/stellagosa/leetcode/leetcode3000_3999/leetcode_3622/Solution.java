package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3622;

/**
 * @author Stellagosa
 * @description 3622.判断整除性
 * @date 8/22/2026 10:49 AM Saturday
 */
public class Solution {

    public boolean checkDivisibility(int n) {
        int mult = 1, sum = 0;
        int temp = n;
        while (temp > 0)
        {
            int dig = temp % 10;
            mult *= dig;
            sum += dig;
            temp /= 10;
        }
        return n % (mult + sum) == 0;
    }

}
