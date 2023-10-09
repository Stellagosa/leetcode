package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2578;

/**
 * @author Stellagosa
 * @description 最小和分割
 * @date 2023/10/9 8:23 星期一
 */
public class Solution {

    public int splitNum(int num) {
        int[] counts = new int[10];
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
        }
        int num1 = 0, num2 = 0;
        int index = 1;
        boolean flag = true;
        while (index < 10) {
            if (counts[index] == 0) {
                index++;
                continue;
            }
            if (flag) {
                num1 = (num1 * 10) + index;

            } else {
                num2 = (num2 * 10) + index;
            }
            counts[index]--;
            flag = !flag;
        }
        return num1 + num2;
    }

}
