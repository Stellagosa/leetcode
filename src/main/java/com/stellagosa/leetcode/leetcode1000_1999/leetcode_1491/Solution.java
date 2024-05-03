package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1491;

/**
 * @author Stellagosa
 * @description 去掉最低工资和最高工资后的工资平均值
 * @date 2024/5/3 8:08 星期五
 */
public class Solution {

    public double average(int[] salary) {
        int n = salary.length;
        double total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int sal : salary) {
            min = Math.min(min, sal);
            max = Math.max(max, sal);
            total += sal;
        }
        return (total - min - max) / (n - 2);
    }

}
