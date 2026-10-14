package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3723;

/**
 * @author Stellagosa
 * @description 3723.数位平方和的最大值
 * @date 10/14/2026 8:10 AM Wednesday
 */
public class Solution {

    public String maxSumOfSquares(int num, int sum) {
        if (9 * num < sum) return "";
        int countOfNine = sum / 9;
        int mod = sum % 9;
        StringBuilder builder = new StringBuilder(num);
        builder.repeat("9", countOfNine);
        if (mod != 0) {
            builder.repeat(String.valueOf(mod), 1);
        }
        builder.repeat("0", num - builder.length());
        return builder.toString();
    }

    // public String maxSumOfSquares(int num, int sum) {
    //     if (9 * num < sum) return "";
    //     StringBuilder builder = new StringBuilder();
    //     while (num > 0 || sum > 0) {
    //         if (sum > 8) {
    //             builder.append('9');
    //             sum -= 9;
    //             num--;
    //         } else {
    //             builder.append(sum);
    //             sum = 0;
    //             num --;
    //         }
    //     }
    //     return builder.toString();
    // }

}
