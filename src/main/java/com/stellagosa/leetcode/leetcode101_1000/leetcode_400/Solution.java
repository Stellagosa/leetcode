package com.stellagosa.leetcode.leetcode101_1000.leetcode_400;

/**
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字
 * <p>
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * @Author: Stellagosa
 * @Date: 2021/12/6 13:05
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(findNthDigit(5888));
    }

    public static int findNthDigit(int n) {
        long range_begin = 1;
        long range_end = 9;
        if (n >= range_begin && n <= range_end) return n;
        long temp = 90;
        long count = 1;
        for (int i = 2; i < 10; i++) {
            range_begin = range_end + 1;
            range_end += i * temp;
            temp *= 10;
            if (n >= range_begin && n <= range_end) {
                count = i;
                break;
            }
        }

        // n在 count 位数中,在 count 位数的第p个数
        long p = 1 + (n - range_begin) / count;
        // 第p个数的第q位
        long q = n - range_begin - (p - 1) * count + 1;

        // 在 num 的第q位，也就是右数第 count - q 位
        long num = (long) (Math.pow(10, count-1) + p - 1);
        long res = 0;
        while (count - q >= 0) {
            res = num % 10;
            num /= 10;
            q++;
        }
        return (int)res;
    }
}

/**
 * 1-9 都是1位数，9个数，  n的范围 [1,9]
 * 10-99 都是2位数，总共90个2位数字，180个数， n的范围 [9+1,180+9]
 * 100-999 都是3位数，总共900个3位数字，2700个数， n的范围[180+9+1,2700+180+9]
 * 1000-9999 都是4位数，总共9000个4位数字，36000个数， n的范围[2700+180+9+1, 36000+2700+180+9]
 * 。。。
 * 100 000 000 - 999 999 999 都是9位数,总共900 000 000个9位数，9* 900 000 000 个数，n的范围是
 * [8*90 000 000 + 。。。 + 3*900 + 2*90 + 1*9 + 1, 9*900 000 000 + 8*90 000 000 + 。。。 + 3*900 + 2*90 + 1*9]
 * [788 888 890,8 888 888 889]
 * 。。。
 * <p>
 * n的范围[1,2^31-1]，最大值 2 147 483 647，最大到9位数
 */
