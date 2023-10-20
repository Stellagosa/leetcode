package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2525;

/**
 * @author Stellagosa
 * @description 根据规则将箱子分类
 * @date 2023/10/20 16:40 星期五
 */
public class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        long temp = (long) length * width * height;

        if ((length >= 10000 || width >= 10000 || height >= 10000 || temp >= 1000000000) && mass >= 100) return "Both";
        if (length >= 10000 || width >= 10000 || height >= 10000 || temp >= 1000000000) return "Bulky";
        if (mass >= 100) return "Heavy";
        return "Neither";
    }

}
