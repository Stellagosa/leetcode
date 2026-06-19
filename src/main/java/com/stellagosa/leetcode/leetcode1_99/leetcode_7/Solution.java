package com.stellagosa.leetcode.leetcode1_99.leetcode_7;

/**
 * @author Stellagosa
 * @description 整数反转
 * @date 6/19/2026 9:24 AM June
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(1534236469);
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10)
                return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }


    // public int reverse(int x) {
    //     int res = 0;
    //     while (x != 0) {
    //         int tmp = x % 10;
    //         if (res > 214748364) {
    //             return 0;
    //         }
    //         if (res < -214748364) {
    //             return 0;
    //         }
    //         res = res * 10 + tmp;
    //         x /= 10;
    //     }
    //
    //     return res;
    // }

    // public int reverse(int x) {
    //     if (x == Integer.MIN_VALUE) return 0;
    //     int res = 0;
    //     int flag = x > 0 ? 1 : -1;
    //     x = x > 0 ? x : -x;
    //     while (x > 0) {
    //         int temp = res;
    //         res *= 10;
    //         if (res / 10 != temp) return 0;
    //         res += x % 10;
    //         x /= 10;
    //     }
    //     return res * flag;
    // }

}
